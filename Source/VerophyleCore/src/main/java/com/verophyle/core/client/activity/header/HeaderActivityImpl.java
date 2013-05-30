/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.header;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.header.HeaderView;
import com.verophyle.core.client.widgets.IdentityAuthentication;
import com.verophyle.core.shared.CoreMessages;
import com.verophyle.core.shared.rf.CoreRequestFactory;
import com.verophyle.core.shared.rf.CoreUserProxy;
import com.verophyle.core.shared.rf.identity.IdentityProxy;
import com.verophyle.core.shared.rf.identity.IdentityRequest;

/**
 * Implementation of the header activity.
 */
public class HeaderActivityImpl extends CoreActivityImpl<CorePlace, HeaderView> implements HeaderActivity {

  private final CoreMessages coreMessages;
  private final CoreRequestFactory requestFactory;
  private final HeaderView headerView;

  private static final List<String>  WHITELIST = Arrays.asList("gordon.tisher@gmail.com", "gordon.tisher@verophyle.com");

  @Inject
  public HeaderActivityImpl(
      CoreLogger logger, 
      CoreMessages coreMessages, 
      CoreRequestFactory requestFactory,
      PlaceController placeController, 
      HeaderView headerView) {
    super(logger, placeController, headerView);

    this.coreMessages = coreMessages;
    this.requestFactory = requestFactory;
    this.headerView = headerView;
  }

  @Override
  public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus) {
    super.start(panel, eventBus);

    initHandlers(eventBus);
    displayAuthInfo();
  }

  private void initHandlers(com.google.gwt.event.shared.EventBus eventBus) {
    // logo click
    this.getView().getLogo().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        onLogoClick();
      }
    });

    // login click
    this.getView().getIdentityAuth().getIdentityLogin().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        onLoginClick();
      }
    });
  }

  private void onLogoClick() {
    goTo(new Index(""));
  }

  private void onLoginClick() {
    final IdentityAuthentication auth = headerView.getIdentityAuth();
    Window.Location.replace(auth.getUrl());
  }

  private void displayAuthInfo() {
    final IdentityRequest request = requestFactory.identityRequest();
    final Request<IdentityProxy> currentIdentity = request.getCurrentIdentity().with("users");

    // request the current identity, then set the name and button accordingly
    currentIdentity.fire(new Receiver<IdentityProxy>() {

      @Override
      public void onSuccess(IdentityProxy identity) {
        final IdentityAuthentication auth = headerView.getIdentityAuth();

        if (identity != null) {
          if (identity.isAnonymous() || isInWhiteList(identity)) {
            final String nickname = identity.getNickname();
            auth.getIdentityInfo().setText(nickname);

            if (identity.isAnonymous())
              setLogin();
            else
              setLogout();

            requestGravatarUrl(identity.getId());
          } else {
            auth.getIdentityInfo().setText("?? unauthorized ??");
            setLogin();
            requestGravatarUrl(identity.getId());
          }
        } else {
          auth.getIdentityInfo().setText("?? no id found ??");
          setLogin();
        }
      }

      @Override
      public void onFailure(ServerFailure error) {
        log(Level.SEVERE, error.getExceptionType() + "\n" + error.getMessage());

        final IdentityAuthentication auth = headerView.getIdentityAuth();

        auth.getIdentityInfo().setText("?? req failed ??");
        setLogin();
      }

    });
  }

  private void requestGravatarUrl(long identityId) {
    // request the gravatar url
    final IdentityRequest gravatarRequest = requestFactory.identityRequest();
    gravatarRequest.getGravatarImageUrl(identityId).fire(new Receiver<String>() {

      @Override
      public void onSuccess(String response) {
        final IdentityAuthentication auth = headerView.getIdentityAuth();
        if (response != null && !response.isEmpty())
          auth.getGravatarImage().setUrl(response);
      }

    });
  }

  private boolean isInWhiteList(IdentityProxy identity) {
    @SuppressWarnings("unused")
    String nick = identity.getNickname();

    final List<CoreUserProxy> users = identity.getUsers();
    if (users != null) {
      for (final CoreUserProxy user : users) {
        String email = user.getEmail();
        if (WHITELIST.contains(email))
          return true;
      }
    }

    return false;
  }

  private void setLogin() {
    final IdentityAuthentication auth = headerView.getIdentityAuth();
    auth.getIdentityLogin().setText(coreMessages.login());

    final String destination = getDestinationUrl();

    requestFactory.identityRequest().getLoginUrl(destination).fire(new Receiver<String>() {
      @Override
      public void onSuccess(String response) {
        auth.setUrl(response);
        if (!GWT.isProdMode())
          auth.getIdentityLogin().setTitle(response);
        headerView.fadeIn(auth);
      }
    });
  }

  private void setLogout() {
    final IdentityAuthentication auth = headerView.getIdentityAuth();
    auth.getIdentityLogin().setText(coreMessages.logout());

    final String destination = getDestinationUrl();

    requestFactory.identityRequest().getLogoutUrl(destination).fire(new Receiver<String>() {
      @Override
      public void onSuccess(String response) {
        auth.setUrl(response);
        if (!GWT.isProdMode())
          auth.getIdentityLogin().setTitle(response);
        headerView.fadeIn(auth);
      }
    });
  }

  private String getDestinationUrl() {
    final UrlBuilder builder = Window.Location.createUrlBuilder();
    return builder.buildString();
  }

}

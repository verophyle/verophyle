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
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Frame;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.CoreUtil;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.event.LoginEvent;
import com.verophyle.core.client.event.LoginEvent.LoginEventHandler;
import com.verophyle.core.client.event.LogoutEvent;
import com.verophyle.core.client.event.LogoutEvent.LogoutEventHandler;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.header.HeaderView;
import com.verophyle.core.client.view.widgets.AuthenticationPopup;
import com.verophyle.core.client.view.widgets.IdentityAuthentication;
import com.verophyle.core.shared.CoreMessages;
import com.verophyle.core.shared.rf.CoreRequestFactory;
import com.verophyle.core.shared.rf.CoreUserProxy;
import com.verophyle.core.shared.rf.identity.IdentityProxy;
import com.verophyle.core.shared.rf.identity.IdentityRequest;

/**
 * Implementation of the header activity.
 */
public class HeaderActivityImpl extends CoreActivityImpl<CorePlace, HeaderView> implements HeaderActivity {

  private final com.google.web.bindery.event.shared.EventBus eventBus;
  private final CoreMessages coreMessages;
  private final CoreRequestFactory requestFactory;
  private final HeaderView headerView;

  private AuthenticationPopup popup = null;
  private String nonce = null;

  private static final List<String>  WHITELIST = Arrays.asList("gordon.tisher@gmail.com", "gordon.tisher@verophyle.com");

  @Inject
  public HeaderActivityImpl(
      com.google.web.bindery.event.shared.EventBus eventBus, 
      CoreLogger logger, 
      CoreMessages coreMessages, 
      CoreRequestFactory requestFactory,
      PlaceController placeController, 
      HeaderView headerView) {
    super(logger, placeController, headerView);

    this.eventBus = eventBus;
    this.coreMessages = coreMessages;
    this.requestFactory = requestFactory;
    this.headerView = headerView;
  }

  @Override
  public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus) {
    super.start(panel, eventBus);

    initHandlers(eventBus);
    initAuthInfo();
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

    // login / logout events
    eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
      @Override
      public void onLoginEvent(LoginEvent event) {
        onLogin();
      }
    });

    eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
      @Override
      public void onLogoutEvent(LogoutEvent event) {
        onLogout();
      }
    });
  }

  private void onLogoClick() {
    goTo(new Index(""));
  }

  private void onLoginClick() {
    final String url = headerView.getIdentityAuth().getUrl();

    if (url != null && popup == null) {
      this.popup = new AuthenticationPopup(url);
      final Frame frame = popup.getFrame();

      if (frame == null) {
        popup.center();
        return;
      }

      // get currently logged-in identity if any
      final IdentityRequest oldIdentityReq = requestFactory.identityRequest();
      oldIdentityReq.getCurrentIdentity().fire(new Receiver<IdentityProxy>() {

        // if we've got an identity, show the popup
        @Override
        public void onSuccess(IdentityProxy response) {
          final long oldIdentityId = response.getId();
          final boolean oldIdentityIsAnonymous = response.isAnonymous();

          frame.addLoadHandler(new LoadHandler() {

            // when the frame loads
            @Override
            public void onLoad(LoadEvent event) {
              final IdentityRequest newIdentityReq = requestFactory.identityRequest();
              newIdentityReq.getLoggedInIdentity(nonce).fire(new Receiver<IdentityProxy>() {

                // now compare identities and fire the appropriate events
                @Override
                public void onSuccess(IdentityProxy response) {
                  if (response == null)
                    return;
                  
                  final long newIdentityId = response.getId();
                  final boolean newIdentityIsAnonymous = response.isAnonymous();

                  if (newIdentityId != oldIdentityId) {
                    if (oldIdentityIsAnonymous) {
                      if (newIdentityIsAnonymous) {
                        // do nothing
                      } else {
                        fireLoginEvent();
                      }
                    } else {
                      if (newIdentityIsAnonymous) {
                        fireLogoutEvent();
                      } else {
                        fireLoginEvent();
                      }
                    }
                  }

                  hidePopup();
                }

                @Override
                public void onFailure(ServerFailure error) {
                  super.onFailure(error);
                  log(Level.SEVERE, "failed to get current user: " + error.getMessage() + "\n" + error.getStackTraceString());
                  hidePopup();
                }

              });
            }

          });

          popup.center();
        }

        @Override
        public void onFailure(ServerFailure error) {
          super.onFailure(error);
          log(Level.SEVERE, "failed to get current user: " + error.getMessage() + "\n" + error.getStackTraceString());
          hidePopup();
        }

      });
    }
  }

  private void hidePopup() {
    nonce = null;
    popup.hide();
    popup = null;    
  }
  
  private void fireLoginEvent() {
    eventBus.fireEvent(new LoginEvent());
  }

  private void fireLogoutEvent() {
    eventBus.fireEvent(new LogoutEvent());
  }

  private void onLogin() {
    initAuthInfo();
  }

  private void onLogout() {
    initAuthInfo();
  }

  private void initAuthInfo() {
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

    final String destination = getDestinationUrl("login");

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

    final String destination = getDestinationUrl("logout");

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

  private String getDestinationUrl(String cmd) {
    nonce = CoreUtil.genUuid();

    final UrlBuilder builder = Window.Location.createUrlBuilder();
    builder.setPath("Authentication");
    builder.setParameter("nonce", nonce);
    builder.setParameter("gwt.codesvr", (String) null);
    return builder.buildString();
  }

}

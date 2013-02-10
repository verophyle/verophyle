package com.verophyle.core.client.activity.header;

import java.util.logging.Level;

import com.google.gwt.event.shared.EventBus;
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
import com.verophyle.core.client.view.widgets.IdentityAuthentication;
import com.verophyle.core.shared.CoreMessages;
import com.verophyle.core.shared.rf.CoreRequestFactory;
import com.verophyle.core.shared.rf.identity.IdentityProxy;
import com.verophyle.core.shared.rf.identity.IdentityRequest;

public class HeaderActivityImpl extends CoreActivityImpl<CorePlace, HeaderView> implements HeaderActivity {

	private final CoreMessages coreMessages;
	private final CoreRequestFactory requestFactory;
	private final HeaderView headerView;
	
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
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		
		final IdentityRequest request = requestFactory.identityRequest();
		final Request<IdentityProxy> currentIdentity = request.getCurrentIdentity();
		
		// request the current identity, then set the name and button accordingly
		currentIdentity.fire(new Receiver<IdentityProxy>() {

			@Override
			public void onSuccess(IdentityProxy identity) {
				final IdentityAuthentication auth = headerView.getIdentityAuth();
				
				if (identity != null) {					
					auth.getIdentityInfo().setText(identity.getHandle());
					
					if (identity.isAnonymous())
						setLogin();
					else
						setLogout();

					// request the gravatar url
					final IdentityRequest gravatarRequest = requestFactory.identityRequest();
					gravatarRequest.getGravatarImageUrl(identity).fire(new Receiver<String>() {

						@Override
						public void onSuccess(String response) {
							if (response != null && !response.isEmpty())
								auth.getGravatarImage().setUrl(response);
						}
						
					});
				} else {
					auth.getIdentityInfo().setText("?? no id found ??");
					setLogin();
				}
			}

			@Override
			public void onFailure(ServerFailure error) {
				log(Level.SEVERE, error.getExceptionType() + "\n" + error.getMessage());

				IdentityAuthentication auth = headerView.getIdentityAuth();

				auth.getIdentityInfo().setText("?? req failed ??");
				setLogin();
			}
			
		});
	}

	@Override
	public void onLogoClick() {
		goTo(new Index(""));
	}

	private void setLogin() {
		final IdentityAuthentication auth = headerView.getIdentityAuth();
		auth.getIdentityLogin().setText(coreMessages.login());
		
		requestFactory.identityRequest().getLoginUrl(Window.Location.getHref()).fire(new Receiver<String>() {
			@Override
			public void onSuccess(String response) {
				auth.setUrl(response);
				auth.getIdentityLogin().setTitle(response);
				headerView.fadeIn(auth);
			}
		});
	}
	
	private void setLogout() {
		final IdentityAuthentication auth = headerView.getIdentityAuth();
		auth.getIdentityLogin().setText(coreMessages.logout());
		
		requestFactory.identityRequest().getLogoutUrl(Window.Location.getHref()).fire(new Receiver<String>() {
			@Override
			public void onSuccess(String response) {
				auth.setUrl(response);
				auth.getIdentityLogin().setTitle(response);
				headerView.fadeIn(auth);
			}
		});
	}
	
}

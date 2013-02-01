package com.verophyle.core.client.activity.header;

import java.util.logging.Level;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.header.HeaderView;
import com.verophyle.core.shared.rf.CoreRequestFactory;
import com.verophyle.core.shared.rf.identity.IdentityProxy;
import com.verophyle.core.shared.rf.identity.IdentityRequest;

public class HeaderActivityImpl extends CoreActivityImpl<CorePlace, HeaderView> implements HeaderActivity {

	private final CoreRequestFactory requestFactory;
	private final HeaderView headerView;
	
	@Inject
	public HeaderActivityImpl(CoreLogger logger, CoreRequestFactory requestFactory, PlaceController placeController, HeaderView headerView) {
		super(logger, placeController, headerView);
		
		this.requestFactory = requestFactory;
		this.headerView = headerView;
	}
		
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		
		IdentityRequest request = requestFactory.identityRequest();
		Request<IdentityProxy> currentIdentity = request.getCurrentIdentity();
		
		currentIdentity.fire(new Receiver<IdentityProxy>() {

			@Override
			public void onSuccess(IdentityProxy identity) {
				String handle = identity != null ? identity.getHandle() : "?";
				headerView.getIdentityAuth().getIdentityInfo().setText(handle);
			}

			@Override
			public void onFailure(ServerFailure error) {
				headerView.getIdentityAuth().getIdentityInfo().setText("?? error ??");
				
				log(Level.SEVERE, error.getExceptionType() + "\n" + error.getMessage());
			}
			
		});
		
	}

}

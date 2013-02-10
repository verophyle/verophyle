package com.verophyle.core.client.view;

import java.util.logging.Level;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;

public abstract class CoreViewImpl extends Composite implements CoreView {
		
	private CoreLogger logger;
	private CorePresenter presenter;
	
	protected CoreViewImpl(CoreLogger logger, CoreResources res) {
		this.logger = logger;
		res.css().ensureInjected();
	}

	protected void log(Level level, String text) {
		logger.log(level, text);
	}
	
	public Widget asWidget() {
		return this;
	}

	public CorePresenter getPresenter() {
		return presenter;
	}
	
	public void setPresenter(CorePresenter presenter) {
		this.presenter = presenter;
	}
	
	public final int FADE_TIME = 1000;
	private final int FADE_STEP_TIME = 100;
	
	public void fadeIn() {
		fadeIn(this);
	}
	
	public void fadeIn(final UIObject uiObject) {
		final double delta = (double)FADE_STEP_TIME / (double)FADE_TIME;
		
		uiObject.getElement().getStyle().setOpacity(0.0);
		uiObject.setVisible(true);		
		
		Timer timer = new Timer() {

			@Override
			public void run() {				
				String ostr = uiObject.getElement().getStyle().getOpacity();
				double opacity;
				
				try {
					opacity = (ostr != null && ostr.length() > 0) ? Double.parseDouble(ostr) : 0;
				} catch (NumberFormatException e) {
					opacity = 0;
				} catch (JavaScriptException e) {
					opacity = 0;
				}
				
				if (opacity < 1) {
					opacity += delta;
					uiObject.getElement().getStyle().setOpacity(opacity);
				} else {
					uiObject.getElement().getStyle().setOpacity(1.0);
					cancel();
				}
			}
			
		};
		
		timer.scheduleRepeating(FADE_STEP_TIME);
	}
	
	public void fadeOut() {
		fadeOut(this);
	}
	
	public void fadeOut(final UIObject uiObject) {
		final double delta = (double)FADE_STEP_TIME / (double)FADE_TIME;
		
		uiObject.getElement().getStyle().setOpacity(1);
		uiObject.setVisible(true);		
		
		Timer timer = new Timer() {

			@Override
			public void run() {				
				String ostr = uiObject.getElement().getStyle().getOpacity();
				double opacity;
				
				try {
					opacity = (ostr != null && ostr.length() > 0) ? Double.parseDouble(ostr) : 1;
				} catch (NumberFormatException e) {
					opacity = 1;
				} catch (JavaScriptException e) {
					opacity = 1;
				}
				
				if (opacity > 0) {
					opacity -= delta;
					uiObject.getElement().getStyle().setOpacity(opacity);
				} else {
					uiObject.getElement().getStyle().setOpacity(0.0);
					uiObject.setVisible(false);
					cancel();
				}
			}
			
		};
		
		timer.scheduleRepeating(FADE_STEP_TIME);		
	}
	
}

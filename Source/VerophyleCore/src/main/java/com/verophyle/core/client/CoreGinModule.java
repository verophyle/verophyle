/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.activity.CoreActivityRegistryImpl;
import com.verophyle.core.client.activity.content.ContentActivity;
import com.verophyle.core.client.activity.content.ContentActivityManager;
import com.verophyle.core.client.activity.content.ContentActivityMapper;
import com.verophyle.core.client.activity.content.ContentIndexActivity;
import com.verophyle.core.client.activity.content.ContentIndexActivityImpl;
import com.verophyle.core.client.activity.content.ContentSecondActivity;
import com.verophyle.core.client.activity.content.ContentSecondActivityImpl;
import com.verophyle.core.client.activity.footer.FooterActivity;
import com.verophyle.core.client.activity.footer.FooterActivityImpl;
import com.verophyle.core.client.activity.footer.FooterActivityManager;
import com.verophyle.core.client.activity.footer.FooterActivityMapper;
import com.verophyle.core.client.activity.header.HeaderActivity;
import com.verophyle.core.client.activity.header.HeaderActivityImpl;
import com.verophyle.core.client.activity.header.HeaderActivityManager;
import com.verophyle.core.client.activity.header.HeaderActivityMapper;
import com.verophyle.core.client.activity.sidebar.SidebarActivity;
import com.verophyle.core.client.activity.sidebar.SidebarActivityImpl;
import com.verophyle.core.client.activity.sidebar.SidebarActivityManager;
import com.verophyle.core.client.activity.sidebar.SidebarActivityMapper;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.core.client.place.CorePlaceHistoryRegistry;
import com.verophyle.core.client.place.CorePlaceHistoryRegistryImpl;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.AppView;
import com.verophyle.core.client.view.AppViewImpl;
import com.verophyle.core.client.view.content.ContentIndexView;
import com.verophyle.core.client.view.content.ContentIndexViewImpl;
import com.verophyle.core.client.view.content.ContentSecondView;
import com.verophyle.core.client.view.content.ContentSecondViewImpl;
import com.verophyle.core.client.view.footer.FooterView;
import com.verophyle.core.client.view.footer.FooterViewImpl;
import com.verophyle.core.client.view.header.HeaderView;
import com.verophyle.core.client.view.header.HeaderViewImpl;
import com.verophyle.core.client.view.sidebar.SidebarView;
import com.verophyle.core.client.view.sidebar.SidebarViewImpl;
import com.verophyle.core.shared.CoreMessages;
import com.verophyle.core.shared.rf.CoreRequestFactory;

/**
 * GIN module for the Core module.
 */
public class CoreGinModule extends AbstractGinModule {

  @Override
  protected void configure() {
    // global objects
    bind(CoreLogger.class).to(CoreLoggerImpl.class).in(Singleton.class);
    bind(CoreResources.class).in(Singleton.class);
    bind(CoreMessages.class).in(Singleton.class);

    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(PlaceHistoryMapper.class).to(CorePlaceHistoryMapper.class).in(Singleton.class);
    bind(CorePlaceHistoryRegistry.class).to(CorePlaceHistoryRegistryImpl.class).in(Singleton.class);

    // activities
    bind(new TypeLiteral<CoreActivityRegistry<HeaderActivity, CorePlace>>(){})
      .to(new TypeLiteral<CoreActivityRegistryImpl<HeaderActivity, CorePlace>>(){})
      .in(Singleton.class);
    bind(HeaderActivityManager.class).in(Singleton.class);
    bind(HeaderActivityMapper.class).in(Singleton.class);
    bind(new TypeLiteral<CoreActivityProxy<HeaderActivity, CorePlace>>(){});
    bind(HeaderActivity.class).to(HeaderActivityImpl.class);

    bind(new TypeLiteral<CoreActivityRegistry<SidebarActivity, CorePlace>>(){})
      .to(new TypeLiteral<CoreActivityRegistryImpl<SidebarActivity, CorePlace>>(){})
      .in(Singleton.class);
    bind(SidebarActivityManager.class).in(Singleton.class);
    bind(SidebarActivityMapper.class).in(Singleton.class);
    bind(new TypeLiteral<CoreActivityProxy<SidebarActivity, CorePlace>>(){});
    bind(SidebarActivity.class).to(SidebarActivityImpl.class);

    bind(new TypeLiteral<CoreActivityRegistry<FooterActivity, CorePlace>>(){})
      .to(new TypeLiteral<CoreActivityRegistryImpl<FooterActivity, CorePlace>>(){})
      .in(Singleton.class);
    bind(FooterActivityManager.class).in(Singleton.class);
    bind(FooterActivityMapper.class).in(Singleton.class);
    bind(new TypeLiteral<CoreActivityProxy<FooterActivity, CorePlace>>(){});
    bind(FooterActivity.class).to(FooterActivityImpl.class);

    bind(new TypeLiteral<CoreActivityRegistry<ContentActivity, CorePlace>>(){})
      .to(new TypeLiteral<CoreActivityRegistryImpl<ContentActivity, CorePlace>>(){})
      .in(Singleton.class);
    bind(ContentActivityManager.class).in(Singleton.class);
    bind(ContentActivityMapper.class).in(Singleton.class);

    bind(new TypeLiteral<CoreActivityProxy<ContentIndexActivity, Index>>(){});
    bind(ContentIndexActivity.class).to(ContentIndexActivityImpl.class);

    bind(new TypeLiteral<CoreActivityProxy<ContentSecondActivity, Second>>(){});
    bind(ContentSecondActivity.class).to(ContentSecondActivityImpl.class);

    // views
    bind(AppView.class).to(AppViewImpl.class).in(Singleton.class);

    bind(HeaderView.class).to(HeaderViewImpl.class).in(Singleton.class);
    bind(SidebarView.class).to(SidebarViewImpl.class).in(Singleton.class);
    bind(FooterView.class).to(FooterViewImpl.class).in(Singleton.class);
    bind(ContentIndexView.class).to(ContentIndexViewImpl.class).in(Singleton.class);
    bind(ContentSecondView.class).to(ContentSecondViewImpl.class).in(Singleton.class);

    // menus
    bind(CoreMenuRegistry.class).to(CoreMenuRegistryImpl.class).in(Singleton.class);

    //
    bind(CoreUtil.class);
  }

  // global objects
  @Provides
  @Singleton
  public PlaceController providePlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }

  @Provides
  @Singleton
  public PlaceHistoryHandler provideHistoryHandler(PlaceController placeController,
                         PlaceHistoryMapper placeHistoryMapper,
                         EventBus eventBus) {
    final PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(placeHistoryMapper);
    placeHistoryHandler.register(placeController, eventBus, new Index("0"));
    return placeHistoryHandler;
  }

  // requestfactory
  @Provides
  @Singleton
  public CoreRequestFactory provideRequestFactory(EventBus eventBus) {
    final CoreRequestFactory requestFactory = GWT.create(CoreRequestFactory.class);
    requestFactory.initialize(eventBus);
    return requestFactory;
  }

}

/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.content;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;

/**
 * Mapper for the Core content activities.
 */
public class ContentActivityMapper extends CoreActivityMapper<ContentActivity, CorePlace> {

  @Inject
  public ContentActivityMapper(CoreActivityRegistry<ContentActivity, CorePlace> registry,
                 Provider<CoreActivityProxy<ContentIndexActivity, Index>> indexActivityProvider, 
                 Provider<CoreActivityProxy<ContentSecondActivity, Second>> secondActivityProvider,
                 CoreLogger logger) {
    super(registry, null, logger);
    
    register(Index.KEY, indexActivityProvider);
    register(Second.KEY, secondActivityProvider);
  }
  
}

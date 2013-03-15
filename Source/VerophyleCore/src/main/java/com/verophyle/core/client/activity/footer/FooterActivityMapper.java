/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.footer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.place.CorePlace;

/**
 * Activity mapper for the footer.
 */
public class FooterActivityMapper extends CoreActivityMapper<FooterActivity, CorePlace> {

  @Inject
  public FooterActivityMapper(CoreActivityRegistry<FooterActivity, CorePlace> registry,
                Provider<CoreActivityProxy<FooterActivity, CorePlace>> provider, 
                CoreLogger logger) {
    super(registry, provider, logger);
  }

}

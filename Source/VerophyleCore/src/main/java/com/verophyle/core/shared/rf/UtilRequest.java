package com.verophyle.core.shared.rf;

import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.verophyle.core.server.rf.CoreServiceLocator;
import com.verophyle.core.server.rf.UtilService;

@Service(value = UtilService.class, locator = CoreServiceLocator.class)
public interface UtilRequest extends RequestContext {
}

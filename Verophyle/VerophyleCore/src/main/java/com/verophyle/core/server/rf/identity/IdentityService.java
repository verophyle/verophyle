package com.verophyle.core.server.rf.identity;

import com.verophyle.core.shared.domain.Identity;

public interface IdentityService {
	Identity getCurrentUser();
}

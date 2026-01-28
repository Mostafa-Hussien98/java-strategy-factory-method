package domain.factory;

import domain.model.CoverageType;
import domain.policy.AuthorizationPolicy;

public interface AuthorizationPolicyFactory {

	AuthorizationPolicy create(CoverageType coverageType);
	
}

package domain.factory;

import java.util.List;

import domain.model.CoverageType;
import domain.policy.AuthorizationPolicy;

public class DefaultAuthorizationPolicyFactory implements AuthorizationPolicyFactory {

	private final List<AuthorizationPolicy> policies;
	
	public DefaultAuthorizationPolicyFactory(
			final List<AuthorizationPolicy> policies) {
		this.policies = List.copyOf(policies);
	}
	
	@Override
	public AuthorizationPolicy create(
			final CoverageType coverageType) {
		for(AuthorizationPolicy policy : this.policies) 
			if(policy.supports(coverageType))
				return policy;
		
		String error = "No Authorization policy for coverage : " + coverageType;
		throw new IllegalArgumentException(error);
	}

}

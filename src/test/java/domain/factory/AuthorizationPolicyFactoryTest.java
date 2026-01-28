package domain.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.model.CoverageType;
import domain.policy.AuthorizationPolicy;
import domain.policy.BasicCoveragePolicy;
import domain.policy.CorporateCoveragePolicy;
import domain.policy.PremiumCoveragePolicy;

class AuthorizationPolicyFactoryTest {

	@Test
	void shouldReturnBasicPolicy() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(
				List.of(new BasicCoveragePolicy(), new PremiumCoveragePolicy(), new CorporateCoveragePolicy()));
		AuthorizationPolicy policy = factory.create(CoverageType.BASIC);
		assertTrue(policy instanceof BasicCoveragePolicy);
	}

	@Test
	void shouldReturnPremiumPolicy() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(
				List.of(new BasicCoveragePolicy(), new PremiumCoveragePolicy(), new CorporateCoveragePolicy()));
		AuthorizationPolicy policy = factory.create(CoverageType.PREMIUM);
		assertTrue(policy instanceof PremiumCoveragePolicy);
	}
	
	@Test
	void shouldReturnCorporatePolicy() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(
				List.of(new BasicCoveragePolicy(), new PremiumCoveragePolicy(), new CorporateCoveragePolicy()));
		AuthorizationPolicy policy = factory.create(CoverageType.CORPORATE);
		assertTrue(policy instanceof CorporateCoveragePolicy);
	}
	
	@Test
	void shouldFailForNotFoundCoverage() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(List.of());
		assertThrows(IllegalArgumentException.class, () -> {
			factory.create(CoverageType.BASIC);
		});
	}
	
}

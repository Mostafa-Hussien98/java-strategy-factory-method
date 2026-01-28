package application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.factory.AuthorizationPolicyFactory;
import domain.factory.DefaultAuthorizationPolicyFactory;
import domain.model.AuthorizationResult;
import domain.model.AuthorizationStatus;
import domain.model.CoverageType;
import domain.model.MedicalService;
import domain.policy.BasicCoveragePolicy;
import domain.policy.PremiumCoveragePolicy;

class AuthorizationMedicalServiceUseCaseTest {

	@Test
	void shouldPremiumCoverageAlwaysApproved() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(List.of(new PremiumCoveragePolicy()));
		AuthorizationMedicalServiceUseCase usecase = new AuthorizationMedicalServiceUseCase(factory);
		AuthorizationResult result = usecase.authorize(CoverageType.PREMIUM, new MedicalService(false));
		assertEquals(AuthorizationStatus.APPROVED, result.getStatus());
	}

	@Test
	void shouldBasicCoverageWithHighCostRequiresAudit() {
		AuthorizationPolicyFactory factory = new DefaultAuthorizationPolicyFactory(List.of(new BasicCoveragePolicy()));
		AuthorizationMedicalServiceUseCase usecase = new AuthorizationMedicalServiceUseCase(factory);
		AuthorizationResult result = usecase.authorize(CoverageType.BASIC, new MedicalService(true));
		assertEquals(AuthorizationStatus.REQUIRES_AUDIT, result.getStatus());
	}
	
	// etc test
	
}

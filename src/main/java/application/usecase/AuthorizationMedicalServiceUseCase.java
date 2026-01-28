package application.usecase;

import domain.factory.AuthorizationPolicyFactory;
import domain.model.AuthorizationResult;
import domain.model.CoverageType;
import domain.model.MedicalService;
import domain.policy.AuthorizationPolicy;

public class AuthorizationMedicalServiceUseCase {

	private final AuthorizationPolicyFactory factory;
	
	public AuthorizationMedicalServiceUseCase(
			final AuthorizationPolicyFactory factory) {
		this.factory = factory;
	}
	
	public AuthorizationResult authorize(
			final CoverageType coverageType,
			final MedicalService medicalService) {
		AuthorizationPolicy policy = factory.create(coverageType);
		return policy.authorize(medicalService);
	}
	
}

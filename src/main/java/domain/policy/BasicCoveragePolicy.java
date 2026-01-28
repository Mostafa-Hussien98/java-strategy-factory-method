package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.CoverageType;
import domain.model.MedicalService;

public class BasicCoveragePolicy implements AuthorizationPolicy {

	@Override
	public boolean supports(
			final CoverageType coverageType) {
		return coverageType == CoverageType.BASIC;
	}

	@Override
	public AuthorizationResult authorize(
			final MedicalService service) {
		if(service.isHighCost())
			return AuthorizationResult.requiresAudit();
		return AuthorizationResult.approved();
	}

}

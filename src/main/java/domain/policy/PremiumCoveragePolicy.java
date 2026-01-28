package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.CoverageType;
import domain.model.MedicalService;

public class PremiumCoveragePolicy implements AuthorizationPolicy {

	@Override
	public boolean supports(
			final CoverageType coverageType) {
		return coverageType == CoverageType.PREMIUM;
	}

	@Override
	public AuthorizationResult authorize(
			final MedicalService service) {
		return AuthorizationResult.approved();
	}

}

package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.CoverageType;
import domain.model.MedicalService;

public class CorporateCoveragePolicy implements AuthorizationPolicy {

	@Override
	public boolean supports(
			final CoverageType coverageType) {
		return coverageType == CoverageType.CORPORATE;
	}

	@Override
	public AuthorizationResult authorize(
			final MedicalService service) {
		return AuthorizationResult.requiresExternalAudit();
	}

}

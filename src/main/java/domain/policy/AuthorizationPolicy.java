package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.CoverageType;
import domain.model.MedicalService;

public interface AuthorizationPolicy {

	boolean supports(CoverageType coverageType);
	
	AuthorizationResult authorize(MedicalService service);
	
}

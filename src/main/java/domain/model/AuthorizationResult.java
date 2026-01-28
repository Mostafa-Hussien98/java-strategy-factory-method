package domain.model;

public class AuthorizationResult {

	public static AuthorizationResult requiresAudit() {
		return new AuthorizationResult(AuthorizationStatus.REQUIRES_AUDIT);
	}

	public static AuthorizationResult approved() {
		return new AuthorizationResult(AuthorizationStatus.APPROVED);
	}

	public static AuthorizationResult requiresExternalAudit() {
		return new AuthorizationResult(AuthorizationStatus.REQUIRES_EXTERNAL_AUDIT);
	}

	private final AuthorizationStatus status;
	
	private AuthorizationResult(
			final AuthorizationStatus status) {
		this.status = status;
	}
	
	public AuthorizationStatus getStatus() {
		return status;
	}
	
}

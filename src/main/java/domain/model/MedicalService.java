package domain.model;

public class MedicalService {

	private boolean isHighCost;
	
	public MedicalService(
			final boolean isHighCost) {
		this.isHighCost = isHighCost;
	}
	
	public boolean isHighCost() {
		return isHighCost;
	}

}

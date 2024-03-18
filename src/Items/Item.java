package Items;

public class Item {

	private int identificationNumber;
	private String location;
	private Boolean availableForPurchase;
	
	public Item(int id, String location, Boolean availableForPurchase){
		
		this.identificationNumber = id;
		this.location = location;
		this.availableForPurchase = availableForPurchase;
		
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getAvailableForPurchase() {
		return availableForPurchase;
	}

	public void setAvailableForPurchase(Boolean availableForPurchase) {
		this.availableForPurchase = availableForPurchase;
	}
}

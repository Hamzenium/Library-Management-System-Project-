package Items;

public class PhyscialItem extends Item {

	private int copies;
	private String dueDate;
	private Boolean itemStatus;
	
	public PhyscialItem(int id, String location, Boolean availableForPurchase, String name, int copies, String dueDate, Boolean itemStatus) {
		super(id,location,availableForPurchase,name);
		this.copies = copies;
		this.dueDate = dueDate;
		this.itemStatus = itemStatus;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}
}

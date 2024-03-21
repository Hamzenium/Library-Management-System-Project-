package Items;

import LibraryManagementSystem.LibraryManagementSystem;

public class PhyscialItem extends Item {

	private int copies;
	private String dueDate;
	private Boolean itemStatus;
	
	public PhyscialItem(int id, String location, Boolean availableForPurchase, String name, int copies, String dueDate, Boolean itemStatus,String category) {
		super(id,location,availableForPurchase,name,category);
		this.copies = copies;
		this.dueDate = dueDate;
		this.itemStatus = itemStatus;
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		system.getPhysicalItem().add(this);
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

	@Override
	public String getDueDates() {
		return this.dueDate;
	}
}

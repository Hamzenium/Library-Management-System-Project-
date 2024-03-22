package Items;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import LibraryManagementSystem.LibraryManagementSystem;

public class PhyscialItem extends Item {

	private int copies;
	private String dueDate;
	private Boolean itemStatus;
	
	public PhyscialItem(int id, String location, Boolean availableForPurchase, String name, int copies, String dueDate, Boolean itemStatus,String category) {
		super(id,location,availableForPurchase,name,category);
		LocalDate currentDate = LocalDate.now();
        
        // Add 7 days to the current date
        LocalDate dateAfter7Days = currentDate.plusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy", Locale.ENGLISH);
        
        // Convert the dateAfter7Days to string using the formatter
        String dateStringAfter7Days = dateAfter7Days.format(formatter);
		this.copies = copies;
		this.dueDate = dateStringAfter7Days;
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

	@Override
	public String setDueDates(String date) {
		// TODO Auto-generated method stub
		return null;
	}
}

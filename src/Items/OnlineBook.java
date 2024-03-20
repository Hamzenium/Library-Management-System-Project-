package Items;

import LibraryManagementSystem.LibraryManagementSystem;

public class OnlineBook extends Item {
	
	public OnlineBook(int id,String name) {
		super(id,name);
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		system.getOnlineBooks().add(this);
	}

	@Override
	public String getDueDates() {
		return null;
	}
	
	public String getCourseName() {
		
		return "Not a course Textbook";
	}
	
	
}

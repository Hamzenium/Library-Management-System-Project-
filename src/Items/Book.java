package Items;

public class Book extends PhyscialItem {

	public Book(int id, String location, Boolean availableForPurchase, int copies, String dueDate, Boolean itemStatus, String name, String category) {
		super(id, location, availableForPurchase,name, copies, dueDate, itemStatus,category);
	}

}

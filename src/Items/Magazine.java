package Items;

public class Magazine extends PhyscialItem {

	public Magazine(int id, String location, Boolean availableForPurchase, int copies, String dueDate,
			Boolean itemStatus, String name,String category) {
		super(id, location, availableForPurchase,name, copies, dueDate, itemStatus,category);
	}

}

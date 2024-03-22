package Items;

public class Magazine extends PhyscialItem {

	public Magazine(int id, String location, Boolean availableForPurchase, int copies,
			Boolean itemStatus, String name,String category) {
		super(id, location, availableForPurchase,name, copies, category, itemStatus,category);
	}

}

package Items;

public class CDs extends PhyscialItem{

	public CDs(int id, String location, Boolean availableForPurchase, int copies, Boolean itemStatus, String name,String category) {
		super(id, location, availableForPurchase,name, copies, category, itemStatus,category);
	}

}

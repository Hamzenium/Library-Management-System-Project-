package ItemIterator;
import java.util.ArrayList;

import Items .*;

public class ItemManager {

	 private ArrayList<PhyscialItem> physicalItems;
	    private ArrayList<OnlineBook> onlineBooks;

	    public ItemManager() {
	        this.physicalItems = new ArrayList<>();
	        this.onlineBooks = new ArrayList<>();
	    }

	    public void addPhysicalItem(PhyscialItem physicalItem) {
	        physicalItems.add(physicalItem);
	    }

	    public void addOnlineBook(OnlineBook onlineBook) {
	        onlineBooks.add(onlineBook);
	    }

	    public PhysicalItemIterator physicalItemIterator() {
	        return new NextPhysicalItemIterator(physicalItems);
	    }

	    public OnlineBookIterator onlineBookIterator() {
	        return new NextOnlineBookIterator(onlineBooks);
	    }
	}

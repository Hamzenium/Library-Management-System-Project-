package ItemIterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import Items.Item;
import Items.PhyscialItem;

public class NextPhysicalItemIterator implements PhysicalItemIterator {
	
	 private ArrayList<PhyscialItem> physicalItems;
	 private int position;
	 
	 public NextPhysicalItemIterator(ArrayList<PhyscialItem> physicalItems) {
	        this.physicalItems = physicalItems;
	        this.position = 0;
	    }

	 @Override
	    public boolean hasNext() {
	        return position < physicalItems.size();
	    }

	    @Override
	    public PhyscialItem next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException("No more physical items");
	        }
	        return physicalItems.get(position++);
	    }
	}

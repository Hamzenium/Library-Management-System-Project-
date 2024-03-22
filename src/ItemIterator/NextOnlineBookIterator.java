package ItemIterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import Items.OnlineBook;

public class NextOnlineBookIterator implements OnlineBookIterator{
	
	    private ArrayList<OnlineBook> onlineBooks;
	    private int position;
	
	    public NextOnlineBookIterator(ArrayList<OnlineBook> onlineBooks) {
	        this.onlineBooks = onlineBooks;
	        this.position = 0;
	    }
	
	@Override
    public boolean hasNext() {
        return position < onlineBooks.size();
    }

    @Override
    public OnlineBook next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more online books");
        }
        return onlineBooks.get(position++);
    }
}

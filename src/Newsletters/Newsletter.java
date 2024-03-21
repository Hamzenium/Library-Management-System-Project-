package Newsletters;

import java.util.ArrayList;
import java.util.List;

import Users.User;

public class Newsletter implements Subject {

	private String name;
	private List<User> subscribers;
	public String getName() {
		return name;
	}
	
	public Newsletter(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }
	public void setName(String name) {
		this.name = name;
	}


	public void update(String newsletterName) {
		for (User user: subscribers) {
			user.update(newsletterName);
		}
		sendNewsletter();
		
	}

	@Override
    public void registerObserver(User observer) {
        subscribers.add(observer);
    }

    @Override
    public void unregisterObserver(User observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (User observer : subscribers) {
            observer.update(name);
        }
    }

    public void sendNewsletter() {
        // Simulating sending newsletter
        System.out.println("Newsletter '" + name + "' is sent to subscribers.");
        notifyObservers();
    }
	
}

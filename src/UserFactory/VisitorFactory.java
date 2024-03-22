package UserFactory;

import Users.User;
import Users.Visitors;

public class VisitorFactory implements ClientFactory {

	@Override
	public User register(String email, String psw, String type) {
		
		return new Visitors(email,psw);
	}

}

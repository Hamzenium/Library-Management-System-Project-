package UserFactory;

import Users.Faculty;
import Users.User;

public class FacultyFactory implements ClientFactory {

	@Override
	public User register(String email, String psw, String type) {
	
		return new Faculty(email,psw);
	}

}

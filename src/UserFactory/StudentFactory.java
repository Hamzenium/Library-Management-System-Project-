package UserFactory;

import Users.Student;
import Users.User;

public class StudentFactory implements ClientFactory {

	@Override
	public User register(String email, String psw, String type) {
		
		return new Student(email, psw);
		
	}

}

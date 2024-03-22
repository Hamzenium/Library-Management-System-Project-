package UserFactory;

import Users.NonFacultyStaff;
import Users.User;

public class NonFacultyStaffFactory  implements ClientFactory{

	@Override
	public User register(String email, String psw, String type) {
		
		return new NonFacultyStaff(email,psw);
	}

}

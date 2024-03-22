package UserFactory;

import Users.User;

public interface ClientFactory {
	
	User register(String email, String psw, String type);

}

package UserFactory;

import Users.User;

public class ConcreteClientFactory implements ClientFactory{

	public User register(String email, String psw, String type) {
		switch(type) {
		case "Student":
			StudentFactory student = new StudentFactory();
		    return  student.register(email, psw,"Studen");
		
		case "faculty":
			
			FacultyFactory faculty = new FacultyFactory();
		    return faculty.register(email, psw,"Faculty");
		
		case "NonFaculty":
			
			NonFacultyStaffFactory nonFaculty = new NonFacultyStaffFactory();
		    return nonFaculty.register(email, psw,"NonFaculty");
		
		case "Visitor" :
			VisitorFactory visitor = new VisitorFactory();
			return visitor.register(email, psw,"Visitor");
		default:
            throw new IllegalArgumentException("Invalid client type");
		
		}
		
	}

}

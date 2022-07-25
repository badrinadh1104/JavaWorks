import dao.UserDAO;

public class MagicOfBooks {
	public static void main(String[] args) {
		
		UserDAO user = new UserDAO();
		String name = user.addUser("badrinadh");
		
	}

}

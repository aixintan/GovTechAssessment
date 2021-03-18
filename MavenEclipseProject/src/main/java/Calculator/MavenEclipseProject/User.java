package Calculator.MavenEclipseProject;

public class User {
	String username;
	double amount;

	public User(String username, double amount) {
		super();
		this.username = username;
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
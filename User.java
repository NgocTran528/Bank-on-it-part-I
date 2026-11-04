import java.util.Scanner;
import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;
	protected Scanner input = new Scanner(System.in);

	public boolean login(){
		System.out.print("User name: ");
		String name = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();
		return login(name, pin);
	} // end login
	
	public boolean login(String name, String pin){
		if (userName.equals(name) && PIN.equals(pin)) {
			System.out.println("Login Successful");
			return true;
		} else {
			System.out.println("Login Failed");
			return false;
		} // end if
	} // end login
	
	public void setUserName(String name){
		userName = name;
	} // end setUserName
	
	public String getUserName(){
		return userName;
	} // end getUserName
	
	public void setPIN(String pin){
		PIN = pin;
	} // end setPIN
	
	public String getPIN(){
		return PIN;
	} // end getPIN
	
	public abstract String getReport();
} // end User

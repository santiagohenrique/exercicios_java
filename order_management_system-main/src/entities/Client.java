package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date birthday;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}



	public Client(String name, String email, Date bithday) {
		this.name = name;
		this.email = email;
		this.birthday = bithday;
	}


	public Date getBithday() {
		return birthday;
	}

	public void setBithday(Date bithday) {
		this.birthday = bithday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return name + " (" + sdf.format(birthday) + ")" + " - " + email;
	}
	
	
	
}

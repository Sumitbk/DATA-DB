package datadb;

public class POJO {
	private String mblno,username,email,pass,address,strcrypt,usertype;

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getStrcrypt() {
		return strcrypt;
	}

	public void setStrcrypt(String strcrypt) {
		this.strcrypt = strcrypt;
	}

	public String getMblno() {
		return mblno;
	}

	public void setMblno(String mblno) {
		this.mblno = mblno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

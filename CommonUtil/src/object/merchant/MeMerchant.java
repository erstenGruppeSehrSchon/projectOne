package object.merchant;

public class MeMerchant extends Merchant{
	private String userName;
	private String password;
	private int status;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus(int status) {
		return this.status = status;
	}
	public void setStatus(int status) {
		 this.status = status;
	}
	
}

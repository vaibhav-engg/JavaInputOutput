
public class UserException extends Exception {
	private String msg;
	public UserException(String s) {
		this.msg = s;
	}
	public String toString() {
		return this.msg;
	}
	

}

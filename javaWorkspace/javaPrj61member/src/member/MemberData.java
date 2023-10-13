package member;

public class MemberData {

//	public MemberData() {
//		
//	}
	public MemberData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public MemberData(String id, String pwd, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	private String id;
	private String pwd;
	private String nick;
	
	public String getId() {
		return this.id;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public String toString() {
		return "id=" + this.id + ", pwd=" + this.pwd + ", nick=" + this.nick;
	}
	
}

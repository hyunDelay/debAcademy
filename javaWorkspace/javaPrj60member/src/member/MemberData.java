package member;

public class MemberData {

	// 필드
	private String id;
	private String pwd;
	private String nick;

	public MemberData() {
		
	}

	public MemberData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	public MemberData(String id, String pwd, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getNick() {
		return this.nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "memberData [id=" + id + ", pwd=" + pwd + ", nick=" + nick + "]";
	}
	
}

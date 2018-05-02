package bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	// ユーザーID
	private String userId;
	// パスワード
	private String password;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

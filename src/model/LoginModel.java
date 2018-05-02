package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import util.CommonUtil;

/**
 * ログイン画面用モデル
 *
 * created by otsuka 2018.04.12
 *
 */
public class LoginModel {
	/**
	 * ログイン情報チェック
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public LoginBean getLoginInfo(String userId, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// もろもろ変数宣言
		LoginBean loginBean = new LoginBean();
		Connection con = null;
		CommonUtil commonUtil = new CommonUtil();
		try {
			// DB接続関連書く
			// ユーザーとかパスとか
			// Oracle JDBC Driverのロード
		    Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(commonUtil.db_url, commonUtil.db_user, commonUtil.db_password);
			System.out.println("MySQLに接続できました。");
			Statement statement = con.createStatement();

			//ユーザIDとパスワードを取得するSQLを実行
			StringBuilder sql = new StringBuilder();
			sql = sql.append("select user_id, user_password from m_user");
			sql = sql.append(" where user_id = " + userId + " and user_password = " + password + ";");
			String strSql = sql.toString();
			ResultSet rs = statement.executeQuery(strSql);

			loginBean.setUserId(rs.getString("user_id"));
			loginBean.setPassword(rs.getString("user_password"));

			// SQLで取得したユーザIDとパスワードを返戻
			return loginBean;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			}catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			}
		}
	}
}

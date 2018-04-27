package servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import model.LoginModel;

/**
* ログイン画面用サーブレット
*
* created by otsuka 2018.04.12
*
*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	* ログイン処理
	*
	* created by otsuka 2018.04.12
	*
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/topMenu.jsp");
		// login.jspからパラメータを取得
		String userId = request.getParameter("loginId");	// ユーザーID
		String password = request.getParameter("loginPass");	// パスワード

		// 各種入力チェック：エラーがあればログイン画面に遷移しエラーメッセージ表示
		// 空チェック
		// 半角英数記号？チェック
		// 文字数チェック

		// LoginBean
		LoginBean loginBean = new LoginBean();
		// SQL実行：LogionModelのgetLoginInfo
		LoginModel loginInfo = new LoginModel();
		try {
			loginBean = loginInfo.getLoginInfo(userId, password);
			userId = loginBean.getUserId();
			password = loginBean.getPassword();
			// selectした結果がnullまたは空でないかチェック
			if (userId == null || userId.equals("") || password == null || password.equals("")) {
				// ユーザIDまたはパスワードにnullまたは空文字を含んでいる場合
				request.setAttribute("errorMessage", "ユーザIDまたはパスワードが一致しません");
				dispatcher = request.getRequestDispatcher("/login.jsp");
			} else {
				// ユーザIDまたはパスワードにnullまたは空文字を含んでいない場合は、入力値がDBに存在するので次画面へ遷移
				// ユーザーIDとパスワードをトップメニュー画面へわたす
				request.setAttribute("loginDataUserId", userId);
				request.setAttribute("loginDataPassword", password);
				// リクエスト送信
//				dispatcher = request.getRequestDispatcher("/topMenu.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

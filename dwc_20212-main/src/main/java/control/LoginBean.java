package control;


import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


@ManagedBean(name = "LoginBean")
@ViewScoped
public class LoginBean {
	
	private String userName;
	private String password;

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

	public String autentica() throws SQLException {
		if (this.userName.equals("LattaTech") && this.password.equals("Password")) {

			System.out.println("auntenticado");
			System.out.println(this.userName);
			System.out.println(this.password);


			return "index.jsf?faces-redirect=true";

		} else {
			System.out.println("nao autenticado");
			System.out.println(this.userName);
			System.out.println(this.password);

			return "<script> alert('usuario nao autenticado') </script>";
		}
	}
	
}
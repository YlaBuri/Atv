package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.model.Usuario;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Usuario user = new Usuario();
		
		String login= request.getParameter("login");
		String senha = request.getParameter("senha");
		
		user.setLogin(login);
		user.setSenha(senha);
		
		if(autenticador(user)==true) {
			//response.sendRedirect("dashboard.jsp?user="+login);
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("dashboard.jsp");
		}else {
			/*String erro="Usuario e senha invalidos";
			response.sendRedirect("index.jsp?erro="+erro);*/
			
			request.setAttribute("erro", "Login e senha invalidos");
			RequestDispatcher d = request.getRequestDispatcher("index.jsp");
			d.forward(request, response);
		}
	}
	
	public boolean autenticador(Usuario user) {
		boolean autenticado = false;
		if(user!=null && user.getLogin()!= null && user.getSenha()!= null && user.getLogin().equals(user.getSenha())) {
			autenticado=true;
		}
		
		return autenticado;
	}

}

package br.com.unisys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaUsuarios extends HttpServlet {
	private static final long serialVersionUID = -6359616861621683724L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nomUsr");
		String html = "";
		
		if(nome == null || nome.trim().equals("")) {
			for(Usuario user: Usuarios.usuarios) {			
				html+="<tr>\n" + 
						"	<td>" +user.getUsuario() + "</td>\n" + 
						"	<td>" + user.getSenha() + "</td>\n" + 
						"</tr>";
			}
		} else {
			for(Usuario user: Usuarios.usuarios) {		
				if(user.getUsuario().toLowerCase().contains(nome.toLowerCase())) {
					html+= user.getUsuario() +"@"+user.getSenha();
					break;
				}
			}
		}
		
		response.getWriter().print(html);
	}
}

package br.com.unisys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroAction extends HttpServlet{
	
	private static final long serialVersionUID = -6359616861621683724L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario u = new Usuario();

		// Captura os dados do formulário.
		String usuario = request.getParameter("txtUsuario");
		String senha = request.getParameter("txtSenha");

		u.setSenha(senha);
		u.setUsuario(usuario);

		// Validação dos dados.
		response.getWriter().print("Usuario cadastrado com Sucesso");

		Usuarios.usuarios.add(u);

	}
}
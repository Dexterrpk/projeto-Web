/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import conexao.PropostadeCursoDAO;
import entidades.pojo.PropostadeCurso;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PropostadeCursoServlets", urlPatterns = {"/PropostadeCursoServlets"})
public class PropostadeCursoServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String acao = request.getParameter("acao");

        if (acao.equals("exc")) {

            String pk_proposta_curso = request.getParameter("pk_proposta_curso");

            PropostadeCurso pr = new PropostadeCurso();

            if (pk_proposta_curso != null) {
                pr.setPk_proposta_curso(Integer.parseInt(pk_proposta_curso));

                PropostadeCursoDAO dao = new PropostadeCursoDAO();
                dao.excluir(pr);
                response.sendRedirect("PropostadeCursoServlets?acao=lis");

            }

        } else if (acao.equals("lis")) {
            PropostadeCursoDAO dao = new PropostadeCursoDAO();
            List<PropostadeCurso> lista = dao.consultarTodos();
            request.setAttribute("lista", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarPdC.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("alt")) {
            String pk_proposta_curso = request.getParameter("pk_proposta_curso");

            PropostadeCursoDAO dao = new PropostadeCursoDAO();

            PropostadeCurso pc = dao.consultarPorId(Integer.parseInt(pk_proposta_curso));
            request.setAttribute("con", pc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PropostadeCurso_Formulario.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("cad")) {

            PropostadeCurso pc = new PropostadeCurso();
            pc.setPk_proposta_curso(0);
            pc.setNome_curso("");
            pc.setDescricao("");
            pc.setPerfilengresso("");

            request.setAttribute("con", pc);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PropostadeCurso_Formulario.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pk_proposta_curso = request.getParameter("pk_proposta_curso");
        String nome_curso = request.getParameter("nome_curso");
        String descricao = request.getParameter("descricao");
        String perfilegresso = request.getParameter("perfilengresso");

        PropostadeCurso pr = new PropostadeCurso();

        if (pk_proposta_curso != null) {

            pr.setPk_proposta_curso(Integer.parseInt(pk_proposta_curso));

            pr.setNome_curso(nome_curso);
            pr.setDescricao(descricao);
            pr.setPerfilengresso(perfilegresso);

            PropostadeCursoDAO dao = new PropostadeCursoDAO();
            dao.salvar(pr);

            RequestDispatcher dispatcher = request.getRequestDispatcher("PropostadeCurso.jsp");
            dispatcher.forward(request, response);

        }
    }

}

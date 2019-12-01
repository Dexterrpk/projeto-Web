/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import conexao.BibliografiaDAO;
import conexao.DisciplinaDAO;
import conexao.PropostadeCursoDAO;
import entidades.pojo.Bibliografia;
import entidades.pojo.Disciplina;
import entidades.pojo.PropostadeCurso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.literal.DestroyedLiteral;


@WebServlet(name = "BibliografiaServlets", urlPatterns = {"/BibliografiaServlets"})
public class BibliografiaServlets extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            
        String acao = request.getParameter("acao");
        

        if (acao.equals("exc")) {
          

            String pk_bibliografia = request.getParameter("pk_bibliografia");

           Bibliografia bi = new Bibliografia();

            if (pk_bibliografia != null) {
                
             
                bi.setPk_bibliografia(Integer.parseInt(pk_bibliografia));
                
                BibliografiaDAO dao = new BibliografiaDAO();
                dao.excluir(bi);
                response.sendRedirect("BibliografiaServlets?acao=lis");

            }
        } else if (acao.equals("lis")) {
            
            
            BibliografiaDAO dao = new BibliografiaDAO();
            
            List<Bibliografia> lista = dao.consultarTodos();
            request.setAttribute("lista", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarBibliografia.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("alt")) {
           String pk_bibliografia = request.getParameter("pk_bibliografia");
           
            BibliografiaDAO dao = new BibliografiaDAO();
            
            Bibliografia bi=dao.consultarPorId(Integer.parseInt(pk_bibliografia));
                    
            request.setAttribute("con", bi);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Bibliografia_Formulario.jsp");
            dispatcher.forward(request, response);
        
            
        }
        else if (acao.equals("cad")) {
            
            Bibliografia bi =  new  Bibliografia();
            bi.setPk_bibliografia(0);
            bi.setDescricao_bibliografica("");
            bi.setId_disciplina(null);
            bi.setTipo_bibliografica("");
        
      
            request.setAttribute("con", bi);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Bibliografia_Formulario.jsp");
            dispatcher.forward(request, response);
            
           
            
             
                
                
            }
           
           
           
           
           
           
         
           
           
       
           
            
            
            
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pk_bibliografia =request.getParameter("pk_bibliografia");
        String descricao_bibliografica = request.getParameter("descricao_bibliografia");
        String id_disciplina = request.getParameter("id_disciplina");
        String  tipo_bibliografica = request.getParameter("tipo_bibliografia");
        
       Bibliografia bi= new Bibliografia ();
        
        
        if (pk_bibliografia!=null) {
            
            bi.setPk_bibliografia(Integer.parseInt(pk_bibliografia));
            bi.setDescricao_bibliografica(descricao_bibliografica);
            bi.setId_disciplina(Integer.parseInt(id_disciplina));
            bi.setTipo_bibliografica(tipo_bibliografica);
            
       

        BibliografiaDAO dao = new BibliografiaDAO();
        dao.salvar(bi);
        
        
			         RequestDispatcher dispatcher = request.getRequestDispatcher("Bibliografia.jsp");
			dispatcher.forward(request, response);
        
        
    }

   
    

    }}

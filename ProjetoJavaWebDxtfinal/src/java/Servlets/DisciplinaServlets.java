/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import conexao.DisciplinaDAO;
import conexao.PropostadeCursoDAO;
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

@WebServlet(name = "DisciplinaServlets", urlPatterns = {"/DisciplinaServlets"})
public class DisciplinaServlets extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            
        String acao = request.getParameter("acao");
        

        if (acao.equals("exc")) {
          

            String pk_disciplina = request.getParameter("id");

            Disciplina dis = new  Disciplina();

            if (pk_disciplina != null) {
                
                dis.setPk_disciplina(Integer.parseInt(pk_disciplina));

                
                DisciplinaDAO dao =  new DisciplinaDAO();
                dao.excluir(dis);
                response.sendRedirect("DisciplinaServlets?acao=lis");

            }
        } else if (acao.equals("lis")) {
            
            
            DisciplinaDAO dao = new DisciplinaDAO();
            
            List<Disciplina> lista = dao.consultarTodos();
            request.setAttribute("lista", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarDisciplina.jsp");
            dispatcher.forward(request, response);

        } else if (acao.equals("alt")) {
            String pk_disciplina = request.getParameter("id");
            DisciplinaDAO dao= new DisciplinaDAO();
                    
            Disciplina dis = dao.consultarPorId(Integer.parseInt(pk_disciplina));
            request.setAttribute("con", dis);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Disciplina_Formulario.jsp");
            dispatcher.forward(request, response);
        
            
        }
        else if (acao.equals("cad")) {
            
           
           
            Disciplina des= new Disciplina();
            des.setPk_disciplina(0);
            des.setNome_disciplina("");
            des.setCarga_horaria(0);
            des.setId__proposta_curso(0);
      
            request.setAttribute("con", des);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Disciplina_Formulario.jsp");
            dispatcher.forward(request, response);
            
           
            
             
                
                
            }
           
           
           
           
           
           
         
           
           
       
           
            
            
            
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pk_disciplina =request.getParameter("id");
        String nome_disciplina = request.getParameter("nome_disciplina");
        String carga_horaria = request.getParameter("carga_horaria");
        String  id__proposta_curso = request.getParameter("id__proposta_curso");
        
        Disciplina dis = new Disciplina();
        
        
        if (pk_disciplina!=null) {
            
       dis.setPk_disciplina(Integer.parseInt(pk_disciplina));
       
       dis.setNome_disciplina(nome_disciplina);
       dis.setCarga_horaria(Float.parseFloat(carga_horaria));
       dis.setId__proposta_curso(Integer.parseInt(id__proposta_curso));

        DisciplinaDAO dao=  new DisciplinaDAO();
        dao.salvar(dis);
        
        
			         RequestDispatcher dispatcher = request.getRequestDispatcher("Disciplina.jsp");
			dispatcher.forward(request, response);
        
        
    }

   
    

    }}

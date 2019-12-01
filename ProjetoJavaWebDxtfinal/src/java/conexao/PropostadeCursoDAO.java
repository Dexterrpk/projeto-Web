/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import entidades.pojo.PropostadeCurso;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.ws.rs.core.Response;


public class PropostadeCursoDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(PropostadeCurso propostadecurso) {

        String sql = "INSERT INTO propostadecurso (nome_curso,descricao,perfilengresso) values(?,?,?)";

        try (PreparedStatement preparador = con.prepareStatement(sql)){
            
            preparador.setString(1, propostadecurso.getNome_curso());
            preparador.setString(2, propostadecurso.getDescricao());
            preparador.setString(3, propostadecurso.getPerfilengresso());

            preparador.execute();
            preparador.close();
            System.out.println("Sucesso salvo !");

        } catch (SQLException ex) {
            System.out.println("ERRO 2 " + ex.getMessage());
        }

    }

    public void alterar(PropostadeCurso propostadecurso) {

        String sql = " UPDATE propostadecurso SET nome_curso=?,descricao=?,perfilengresso=?  WHERE pk_proposta_curso = ?";

        try (PreparedStatement preparador = con.prepareStatement(sql)){
            
            preparador.setString(1, propostadecurso.getNome_curso());
            preparador.setString(2, propostadecurso.getDescricao());
            preparador.setString(3, propostadecurso.getPerfilengresso());
            preparador.setInt   (4, propostadecurso.getPk_proposta_curso());

            preparador.execute();
            preparador.close();
            System.out.println("Alterado com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }

    }

    public void excluir(PropostadeCurso propostadecurso) throws IOException {

        String sql = " DELETE FROM propostadecurso   WHERE pk_proposta_curso = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, propostadecurso.getPk_proposta_curso());

            preparador.execute();
            preparador.close();
            System.out.println("Excluido com Sucesso com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
             
        }

    }
    
    public List<PropostadeCurso> consultarTodos() {

        String sql = " SELECT *FROM propostadecurso";

        List<PropostadeCurso> lista = new ArrayList<>();

        try {
            try (
                    PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {

                    PropostadeCurso pc = new PropostadeCurso();

                    pc.setPk_proposta_curso(resultado.getInt("pk_proposta_curso"));
                    pc.setNome_curso(resultado.getString("nome_curso"));
                    pc.setDescricao(resultado.getString("descricao"));
                    pc.setPerfilengresso(resultado.getString("perfilengresso"));
                    lista.add(pc);

                }
            }
            System.out.println("Consultado  com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }
        return lista;

    }

   
    public PropostadeCurso consultarPorId(Integer pk_proposta_curso) {

        String sql = "SELECT * FROM propostadecurso WHERE pk_proposta_curso = ?";
                                    
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, pk_proposta_curso);

            ResultSet resultado = preparador.executeQuery();
            if (resultado.next()) {
                PropostadeCurso pc = new PropostadeCurso();

                pc.setPk_proposta_curso(resultado.getInt("pk_proposta_curso"));
                pc.setNome_curso(resultado.getString("nome_curso"));
                pc.setDescricao(resultado.getString("descricao"));
                pc.setPerfilengresso(resultado.getString("perfilengresso"));

                return pc;
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }

        return null;
    }
    public void salvar(PropostadeCurso propostadecurso){
          if(propostadecurso.getPk_proposta_curso()!=null&&propostadecurso.getPk_proposta_curso()!=0){
               alterar(propostadecurso);
                System.out.println("alterardo  no banco de dados");;
              
              
          }
          else{
           
            cadastrar(propostadecurso);
             System.out.println("Cadastrou  no banco de dados");
             
          }


}

}





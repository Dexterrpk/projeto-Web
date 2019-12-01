/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import entidades.pojo.Bibliografia;
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

public class BibliografiaDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Bibliografia bibliografia) {

        //Monta SQL
        String sql = "INSERT INTO bibliografia (descricao_bibliografia,id_disciplina,tipo_bibliografia) values(?,?,?)";

        try (PreparedStatement preparador = con.prepareStatement(sql)){
            //controi Prepared Statement com sql
            
            preparador.setString(1, bibliografia.getDescricao_bibliografica());
            preparador.setInt(2, bibliografia.getId_disciplina());
            preparador.setString(3, bibliografia.getTipo_bibliografica());

            preparador.execute();
            preparador.close();
            System.out.println("Sucesso salvo !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }

    }

    public void alterar(Bibliografia bibliografia) {

        //Monta SQL
        String sql = " UPDATE bibliografia  SET descricao_bibliografia=?,id_disciplina=?,tipo_bibliografia=?  WHERE pk_bibliografia = ?";

        try (PreparedStatement preparador = con.prepareStatement(sql)){
            //controi Prepared Statement com sql
            
            preparador.setString(1, bibliografia.getDescricao_bibliografica());
            preparador.setInt(2, bibliografia.getId_disciplina());
            preparador.setString(3, bibliografia.getTipo_bibliografica());
            preparador.setInt   (4, bibliografia.getPk_bibliografia());

            preparador.execute();
            preparador.close();
            System.out.println("Alterado com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }

    }

    public void excluir(Bibliografia bibliografia) throws IOException {

        //Monta SQL
        String sql = " DELETE FROM bibliografia   WHERE pk_bibliografia = ?";

        try {
            //controi Prepared Statement com sql
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, bibliografia.getPk_bibliografia());

            preparador.execute();
            preparador.close();
            System.out.println("Excluido com Sucesso com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
             
        }

    }
    
    public List<Bibliografia> consultarTodos() {

        //Monta SQL
        String sql = " SELECT *FROM bibliografia";

        List<Bibliografia> lista = new ArrayList<>();

        try {
            try ( //controi Prepared Statement com sql
                    PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {

                    Bibliografia bi = new Bibliografia();
                   
                    
                    bi.setPk_bibliografia(resultado.getInt("pk_bibliografia"));
                    bi.setDescricao_bibliografica(resultado.getString("descricao_bibliografia"));
                    bi.setId_disciplina(resultado.getInt("id_disciplina"));
                    bi.setTipo_bibliografica(resultado.getString("tipo_bibliografia"));

                    lista.add(bi);

                }
            }
            System.out.println("Consultado  com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }
        return lista;

    }

    /**
     * faz a busca de 1 registro banco de dados por id do propodta de curso pelo
     * numero do id da proposta
     *
     * @param pk_bibliografia
     * @return ele retorna nulo quando nao encontra 
     *
     */
    public Bibliografia consultarPorId(Integer pk_bibliografia) {
        //objeto de retorno do metodo 

        String sql = "SELECT * FROM bibliografia WHERE pk_bibliografia = ?";
                                    
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, pk_bibliografia);

            //retorno da consulta em resulset
            ResultSet resultado = preparador.executeQuery();
            //sem ter  registro
            if (resultado.next()) {
                //instancia do Proposta de curso 
                
               Bibliografia bi = new Bibliografia();
               
                bi.setPk_bibliografia(resultado.getInt("pk_bibliografia"));
                bi.setDescricao_bibliografica(resultado.getString("descricao_bibliografia"));
                bi.setId_disciplina(resultado.getInt("id_disciplina"));
                bi.setTipo_bibliografica(resultado.getString("tipo_bibliografia"));



                return bi;
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }

        return null;
    }
    public void salvar(Bibliografia bibliografia){
          if(bibliografia.getPk_bibliografia()!=null && bibliografia.getPk_bibliografia()!=0){
               alterar(bibliografia);
                System.out.println("alterardo  no banco de dados");
              
              
          }
          else{
           
            cadastrar(bibliografia);
             System.out.println("Cadastrou  no banco de dados");
             
          }


}

}





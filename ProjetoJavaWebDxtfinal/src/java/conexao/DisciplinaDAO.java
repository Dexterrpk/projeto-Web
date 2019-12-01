/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;


import entidades.pojo.Disciplina;
import entidades.pojo.PropostadeCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    private Connection con = Conexao.getConnection();

    public void cadastrar(Disciplina  disciplina) {

        //Monta SQL
        String sql =" INSERT INTO disciplina (nome_disciplina, carga_horaria, id_proposta_curso) VALUES (?, ?, ?)";

        try (PreparedStatement preparador = con.prepareStatement(sql)) {
            //controi Prepared Statement com sql

            preparador.setString(1, disciplina.getNome_disciplina());
            preparador.setFloat(2, disciplina.getCarga_horaria());
            preparador.setInt(3, disciplina.getId__proposta_curso());

            preparador.execute();
            preparador.close();
            System.out.println("Sucesso salvo !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage()+ex);
        }

    }

    public void alterar(Disciplina disciplina) {

        //Monta SQL
        String sql = " UPDATE disciplina SET nome_disciplina=?,carga_horaria=?,id_proposta_curso=?  WHERE pk_disciplina = ?";

        try (PreparedStatement preparador = con.prepareStatement(sql)) {
            //controi Prepared Statement com sql

            preparador.setString(1, disciplina.getNome_disciplina());
            preparador.setFloat(2, disciplina.getCarga_horaria());
            preparador.setInt(3, disciplina.getId__proposta_curso());
            preparador.setInt(4, disciplina.getPk_disciplina());

            preparador.execute();
            preparador.close();
            System.out.println("Alterado com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }

    }

    public void excluir(Disciplina disciplina) {

        //Monta SQL
        String sql = " DELETE FROM disciplina   WHERE pk_disciplina = ?";

        try {
            try ( //controi Prepared Statement com sql
                    PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setInt(1, disciplina.getPk_disciplina());
                
                preparador.execute();
            }
            System.out.println("Excluido com Sucesso com sucesso !");

        } catch (SQLException ex) {
            System.out.println("ERRO no PreparedStatement " + ex.getMessage());
        }

    }

    public List<Disciplina> consultarTodos() {

        //Monta SQL
        String sql = " SELECT *FROM disciplina";

        List<Disciplina> lista = new ArrayList<>();

        try {
            try ( //controi Prepared Statement com sql
                    PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {

                    Disciplina d = new Disciplina();

                    d.setPk_disciplina(resultado.getInt("pk_disciplina"));
                    d.setNome_disciplina(resultado.getString("nome_disciplina"));
                    d.setCarga_horaria(resultado.getFloat("carga_horaria"));
                    d.setId__proposta_curso(resultado.getInt("id_proposta_curso"));
                    

                    lista.add(d);

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
     * @param pk_disciplina
     * @return ele retorna nulo quando nao encontra
     *
     */
    public Disciplina consultarPorId(Integer pk_disciplina) {
        //objeto de retorno do metodo 

        String sql = "SELECT * FROM disciplina WHERE pk_disciplina = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, pk_disciplina);

            //retorno da consulta em resulset
            ResultSet resultado = preparador.executeQuery();
            //sem ter  registro
            if (resultado.next()) {
                //instancia do Proposta de curso 
                Disciplina  d = new Disciplina();

                d.setPk_disciplina(resultado.getInt("pk_disciplina"));
                d.setNome_disciplina(resultado.getString("nome_disciplina"));
                d.setCarga_horaria(resultado.getFloat("carga_horaria"));
               d.setId__proposta_curso(resultado.getInt("id_proposta_curso"));

               

                return d;
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }

        return null;
    }

    public void salvar(Disciplina  disciplina) {
        if (disciplina.getPk_disciplina() !=null && disciplina.getPk_disciplina() != 0){
            alterar(disciplina);
            System.out.println("alterardo  no banco de dados");

        } else {

            cadastrar(disciplina);
            System.out.println("Cadastrou  no banco de dados");

        }

    }

}

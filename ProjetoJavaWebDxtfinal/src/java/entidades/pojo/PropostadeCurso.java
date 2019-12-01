/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.pojo;

public class PropostadeCurso {

    private Integer pk_proposta_curso;
    private String nome_curso;
    private String descricao;
    private String perfilengresso;

    public Integer getPk_proposta_curso() {
        return pk_proposta_curso;
    }

    public void setPk_proposta_curso(Integer pk_proposta_curso) {
        this.pk_proposta_curso = pk_proposta_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPerfilengresso() {
        return perfilengresso;
    }

    public void setPerfilengresso(String perfilengresso) {
        this.perfilengresso = perfilengresso;
    }

}

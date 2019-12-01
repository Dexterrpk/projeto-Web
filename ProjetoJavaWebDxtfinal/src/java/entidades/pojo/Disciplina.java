/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.pojo;

import entidades.pojo.PropostadeCurso;
import java.util.List;

public class Disciplina {

    private Integer pk_disciplina;
    private String nome_disciplina;
    private float carga_horaria;
    private Integer id__proposta_curso;

    public Integer getPk_disciplina() {
        return pk_disciplina;
    }

    public void setPk_disciplina(Integer pk_disciplina) {
        this.pk_disciplina = pk_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public float getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(float carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Integer getId__proposta_curso() {
        return id__proposta_curso;
    }

    public void setId__proposta_curso(Integer id__proposta_curso) {
        this.id__proposta_curso = id__proposta_curso;

    }

}

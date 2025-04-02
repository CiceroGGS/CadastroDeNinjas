package dev.cicerojava10x.CadastroDeNinjas.Missoes;

import dev.cicerojava10x.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@AllArgsConstructor
@Data
@Getter
@Setter
public class MissoesModel {

    /******************************************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeDaMissao;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    /******************************************/

//    public MissoesModel() {
//    }
//
//    public MissoesModel(long id, String nomeDaMissao, String dificuldade) {
//        this.id = id;
//        this.nomeDaMissao = nomeDaMissao;
//        this.dificuldade = dificuldade;
//    }
//
//    public MissoesModel(long id, String nomeDaMissao, String dificuldade, List<NinjaModel> ninjas) {
//        this.id = id;
//        this.nomeDaMissao = nomeDaMissao;
//        this.dificuldade = dificuldade;
//        this.ninjas = ninjas;
//    }

    /******************************************/

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getNomeDaMissao() {
//        return nomeDaMissao;
//    }
//
//    public void setNomeDaMissao(String nomeDaMissao) {
//        this.nomeDaMissao = nomeDaMissao;
//    }
//
//    public String getDificuldade() {
//        return dificuldade;
//    }
//
//    public void setDificuldade(String dificuldade) {
//        this.dificuldade = dificuldade;
//    }
//
//    public List<NinjaModel> getNinja() {
//        return ninjas;
//    }
//
//    public void setNinja(List<NinjaModel> ninja) {
//        this.ninjas = ninja;
//    }

    /******************************************/

}

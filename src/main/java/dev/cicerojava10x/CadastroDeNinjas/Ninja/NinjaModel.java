package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import dev.cicerojava10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
//import lombok.*;

@Entity
@Table(name = "tb_ninja")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Getter
//@Setter
public class NinjaModel {

    /******************************************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    /******************************************/

    public NinjaModel() {}

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel(long id, String nome, String email, int idade, MissoesModel missoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missoes = missoes;
    }

    public NinjaModel(long id, String nome, String email, int idade, String imgUrl, MissoesModel missoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.imgUrl = imgUrl;
        this.missoes = missoes;
    }

    /******************************************/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
/******************************************/
}

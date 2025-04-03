package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "rank")
    private String rank;

    @Column (name = "idade")
    private int idade;

    @ManyToOne()
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    /******************************************/

    public NinjaModel() {

    }

    public NinjaModel(String nome, String email, String imgUrl, String rank, int idade, MissoesModel missoes) {
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.rank = rank;
        this.idade = idade;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /******************************************/
}

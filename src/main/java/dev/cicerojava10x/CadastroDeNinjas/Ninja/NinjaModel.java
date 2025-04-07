package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import dev.cicerojava10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ninja")
@ToString(exclude = "missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    /******************************************/

}

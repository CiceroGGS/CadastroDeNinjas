package dev.cicerojava10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cicerojava10x.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MissoesModel {

    /******************************************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //@OneToMany - Uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

    /******************************************/

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /******************************************/

}

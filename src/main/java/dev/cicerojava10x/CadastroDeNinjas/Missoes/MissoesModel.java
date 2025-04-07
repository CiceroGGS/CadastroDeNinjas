package dev.cicerojava10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cicerojava10x.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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

}

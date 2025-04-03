package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import dev.cicerojava10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    private NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    // CREATE
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody Map<String, Object> request) {
        NinjaModel ninja = new NinjaModel();
        ninja.setNome((String) request.get("nome"));
        ninja.setEmail((String) request.get("email"));
        ninja.setIdade(((Number) request.get("idade")).intValue());
        ninja.setImgUrl((String) request.get("img_url"));
        ninja.setRank((String) request.get("rank"));

        if (request.containsKey("missoes_id")) {
            Long missaoId = ((Number) request.get("missoes_id")).longValue();
            MissoesModel missao = new MissoesModel();
            missao.setId(missaoId);
            ninja.setMissoes(missao);
        }

        return ninjaService.criarNinja(ninja);
    }

    // READ
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // READ
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // UPDATE
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Criado ninja";
    }

    // DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

    @PutMapping("atualizar/{id}")
    public NinjaModel atualizarTodosCamposNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.atualizarTodosCamposNinja(id, ninjaAtualizado);
    }
}

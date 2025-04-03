package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import dev.cicerojava10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.http.ResponseEntity;
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

    /********************************************/
    // CREATE
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody Map<String, Object> request) {

          NinjaDTO ninjaDTO = new NinjaDTO();

          ninjaDTO.setNome((String) request.get("nome"));
          ninjaDTO.setEmail((String) request.get("email"));
          ninjaDTO.setIdade(((Number) request.get("idade")).intValue());
          ninjaDTO.setImgUrl((String) request.get("img_url"));
          ninjaDTO.setRank((String) request.get("rank"));

        if (request.containsKey("missoes_id")) {
            Long missaoId = ((Number) request.get("missoes_id")).longValue();
            MissoesModel missao = new MissoesModel();
            missao.setId(missaoId);
            ninjaDTO.setMissoes(missao);
        }

        return ninjaService.criarNinja(ninjaDTO);
    }

    /********************************************/
    // READ
    @GetMapping("/listar")
    public List<NinjaDTO>  listarNinjas() {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        return ninjas;
    }

    /********************************************/
    // READ
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    /********************************************/
    // UPDATE
    @PatchMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.atualizarNinja(id, ninjaDTO);
    }

    /********************************************/
    // DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}

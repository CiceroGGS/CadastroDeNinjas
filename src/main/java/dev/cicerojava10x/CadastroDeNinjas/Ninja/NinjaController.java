package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import dev.cicerojava10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> criarNinja(@RequestBody Map<String, Object> request) {

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

        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID)" + novoNinja.getId());
    }

    /********************************************/
    // READ
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas() {

        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjas);

    }

    /********************************************/
    // READ
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao localizado");
        }

    }
    /********************************************/
    // UPDATE
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {

        if(ninjaService.listarNinjasPorId(id) != null) {
            NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao encontrado");
        }

    }

    /********************************************/
    // DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao encontrado");
        }

    }

}

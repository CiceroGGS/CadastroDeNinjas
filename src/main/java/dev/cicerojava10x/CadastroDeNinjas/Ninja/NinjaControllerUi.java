package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    private NinjaControllerUi(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {

        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";

    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){

        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";

    }

}

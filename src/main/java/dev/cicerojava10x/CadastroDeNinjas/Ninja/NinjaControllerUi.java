package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String listarNinjas(Model) {

        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        return "Ninjas Listados";

    }

}

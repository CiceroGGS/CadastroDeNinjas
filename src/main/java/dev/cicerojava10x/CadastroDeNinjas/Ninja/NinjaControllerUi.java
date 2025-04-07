package dev.cicerojava10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    private NinjaControllerUi(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

}

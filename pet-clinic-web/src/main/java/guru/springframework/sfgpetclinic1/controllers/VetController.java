package guru.springframework.sfgpetclinic1.controllers;

import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String ListOwners(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}

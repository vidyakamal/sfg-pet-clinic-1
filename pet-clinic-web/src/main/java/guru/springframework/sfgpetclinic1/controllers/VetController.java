package guru.springframework.sfgpetclinic1.controllers;

import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html","/vets.html"})
    public String ListOwners(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}

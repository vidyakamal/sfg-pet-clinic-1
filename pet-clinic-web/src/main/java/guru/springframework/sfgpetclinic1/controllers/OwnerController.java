package guru.springframework.sfgpetclinic1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @RequestMapping({"/owners","/owners.index","owners.index.html"})
    public String ListOwners(){
        return "owners/index";
    }
}

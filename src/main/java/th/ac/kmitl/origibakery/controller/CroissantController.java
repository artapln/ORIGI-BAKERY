package th.ac.kmitl.origibakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CroissantController {

    @RequestMapping("/croissant")
    public String getCroissantPage() {
        return "croissant";
    }
}
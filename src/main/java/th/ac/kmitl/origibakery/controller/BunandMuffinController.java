package th.ac.kmitl.origibakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BunandMuffinController {
    @RequestMapping("/bunandmuffin")
    public String getBunandMuffinPage() {
        return "bunandmuffin";
    }
}

package psw.spring.springmvcsemplice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/prova")
public class Prova {

    @RequestMapping(method = RequestMethod.GET)
    public String prova(Model m){
        m.addAttribute("nome", "Sergio");
        return "pippo.jsp";
    }
}

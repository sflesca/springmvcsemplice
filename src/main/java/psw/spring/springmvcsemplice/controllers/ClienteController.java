package psw.spring.springmvcsemplice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import psw.spring.springmvcsemplice.repositories.ClienteRepository;

@Controller
@RequestMapping("/clienti")
public class ClienteController {

    @Autowired
    ClienteRepository rep;

    @RequestMapping(method = RequestMethod.GET)
    public String getClienti(Model m){
        m.addAttribute("clienti", rep.findAll());
        return "clienti.jsp";
    }
}

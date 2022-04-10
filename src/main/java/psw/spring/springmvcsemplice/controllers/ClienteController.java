package psw.spring.springmvcsemplice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import psw.spring.springmvcsemplice.entities.Cliente;
import psw.spring.springmvcsemplice.repositories.ClienteRepository;

@Controller
@RequestMapping("/clienti")
public class ClienteController {

    @Autowired
    ClienteRepository rep;

    @RequestMapping(method = RequestMethod.GET)
    public String getClienti(Model m){
        m.addAttribute("clienti", rep.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/modcliente", method = RequestMethod.GET)
    public String modcliente(Model m, @RequestParam("id") long id){
        System.out.println("ID: "+id);
        Cliente c = rep.findById(id).get();
        if (c!= null)
            System.out.println(c);
        m.addAttribute("cliente", c);
        return "/modcliente.jsp";
    }

    @RequestMapping(value = "/modcliente", method = RequestMethod.POST)
    @Transactional
    public String modcliente(Model m, @RequestParam("id") long id, @RequestParam("nome") String newnome){
        System.out.println("ID: "+id);
        Cliente c = rep.findById(id).get();
        c.setNome(newnome);
        m.addAttribute("clienti", rep.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/eliminacliente", method = RequestMethod.GET)
    @Transactional
    public String delcliente(Model m, @RequestParam("id") long id){
        rep.deleteById(id);
        m.addAttribute("msg", "Cliente cancellato");
        m.addAttribute("clienti", rep.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/inscliente", method = RequestMethod.POST)
    @Transactional
    public String inscliente(Model m, @RequestParam("nome") String nome){
        Cliente c = new Cliente();
        c.setNome(nome);
        rep.save(c);
        m.addAttribute("msg", "Cliente Inserito");
        m.addAttribute("clienti", rep.findAll());
        return "/clienti.jsp";
    }
}

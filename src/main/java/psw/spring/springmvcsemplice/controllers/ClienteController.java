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
import psw.spring.springmvcsemplice.services.ClienteService;

@Controller
@RequestMapping("/clienti")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
    public String getClienti(Model m){
        m.addAttribute("clienti", clienteService.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/modcliente", method = RequestMethod.GET)
    public String modcliente(Model m, @RequestParam("id") long id){
        m.addAttribute("cliente", clienteService.getClienteById(id));
        return "/modcliente.jsp";
    }

    @RequestMapping(value = "/modcliente", method = RequestMethod.POST)
    public String modcliente(Model m, @RequestParam("id") long id, @RequestParam("nome") String newnome){
        clienteService.modificaCliente(id, newnome);
        m.addAttribute("clienti", clienteService.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/eliminacliente", method = RequestMethod.GET)
    public String delcliente(Model m, @RequestParam("id") long id){
        clienteService.eliminaCliente(id);
        m.addAttribute("msg", "Cliente cancellato");
        m.addAttribute("clienti", clienteService.findAll());
        return "/clienti.jsp";
    }

    @RequestMapping(value = "/inscliente", method = RequestMethod.POST)
    public String inscliente(Model m, @RequestParam("nome") String nome){
        clienteService.insCliente(nome);
        m.addAttribute("msg", "Cliente Inserito");
        m.addAttribute("clienti", clienteService.findAll());
        return "/clienti.jsp";
    }
}

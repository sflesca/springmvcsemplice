package psw.spring.springmvcsemplice.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import psw.spring.springmvcsemplice.entities.Cliente;
import psw.spring.springmvcsemplice.services.ClienteService;

@RestController
@RequestMapping(path="/rest/cliente",
        produces="application/json")
@CrossOrigin(origins = "*")
public class ClienteRestController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public Iterable<Cliente> getAll(){
        return clienteService.findAll();
    }

    @PostMapping(path="/create", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente c){
        return clienteService.insCliente(c.getNome());
    }

}

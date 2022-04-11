package psw.spring.springmvcsemplice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psw.spring.springmvcsemplice.entities.Cliente;
import psw.spring.springmvcsemplice.repositories.ClienteRepository;

import java.util.List;

@Service
@Transactional
public class ClienteService {
    @Autowired
    ClienteRepository rep;

    @Transactional(readOnly=true)
    public List<Cliente> findAll() {
        return rep.findAll();
    }

    @Transactional(readOnly=true)
    public Cliente getClienteById(long id) {
        return rep.findById(id).get();
    }

    public void modificaCliente(long id, String nome){
        Cliente c = rep.findById(id).get();
        c.setNome(nome);
    }

    public void eliminaCliente(long id){
        rep.deleteById(id);
    }

    public void insCliente(String nome){
        rep.save(new Cliente(nome));
    }
}



package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViaCepServiceImpl implements ViaCepService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscaPorID(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public void inserir(Cliente cliente) {

        }

}

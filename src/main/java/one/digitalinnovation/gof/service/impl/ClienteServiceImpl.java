package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class ClienteServiceImpl extends ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    private Long Cep;

    private ClienteServiceImpl() {
    }

    public static ClienteServiceImpl createClienteServiceImpl() {
        return new ClienteServiceImpl();
    }

    @Override
    public void inserir(Cliente cliente) {
        // 1º Verificar se o cliente já existe pelo CEP
        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getCep(Cep));

        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente com esse CEP já existe.");
        }

        // 2º Integrar com o ViaCEP (se o cliente não existe)
        try {
            // Obter dados do ViaCEP
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://viacep.com.br//" + cliente.getCep(Cep) + "/json/";
            Endereco enderecoViaCEP = restTemplate.getForObject(url, Endereco.class);

            // Criar ou atualizar o endereço no banco de dados
            Endereco endereco = new add(enderecoViaCEP);

            // 3º Inserir o cliente, vinculando o endereço
            cliente.setEndereco();
            clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao integrar com o ViaCEP: " + e.getMessage());
        }
    }

    private class add extends Endereco {
        public add(Endereco enderecoViaCEP) {
            super();
        }
    }
}
package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {


    public ViaCepClient viaCepClient = new ViaCepClient();

    public default ViaCepClient buscarPorCep(String cep) {
        return viaCepClient.EnderecoViaCep(cep);
    }

    class ViaCepClient {
        public ViaCepClient EnderecoViaCep(String cep) {
            return viaCepClient;
        }
    }
}

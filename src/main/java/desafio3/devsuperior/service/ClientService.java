package desafio3.devsuperior.service;

import desafio3.devsuperior.dto.ClientDto;
import desafio3.devsuperior.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public ClientDto findById(Long id) {
    }

    public void delete(Long id) {
    }
}

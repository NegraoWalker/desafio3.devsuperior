package desafio3.devsuperior.service;

import desafio3.devsuperior.dto.ClientDto;
import desafio3.devsuperior.model.Client;
import desafio3.devsuperior.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

//    @Transactional(readOnly = true)
//    public ClientDto findById(Long id) {
////        Client client = clientRepository.findById(id).orElseThrow();
////        return new ClientDto(client);
//    }
//
//    @Transactional(readOnly = true)
//    public List<ClientDto> findAll() {
//    }

    @Transactional
    public ClientDto insert(ClientDto clientDto) {
        Client client = new Client();
        transformDtoToEntity(clientDto, client);
        clientRepository.save(client);
        return new ClientDto(client);
    }

//    @Transactional
//    public ClientDto update(Long id) {
//    }
//
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void delete(Long id) {
//    }

    /*Método usado para converter de dto para entidade:*/
    public void transformDtoToEntity(ClientDto clientDto, Client client) {
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setIncome(client.getIncome());
        client.setBirthDate(clientDto.getBirthDate());
        client.setChildren(client.getChildren());
    }

}

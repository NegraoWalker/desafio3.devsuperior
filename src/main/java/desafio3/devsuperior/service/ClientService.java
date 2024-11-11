package desafio3.devsuperior.service;

import desafio3.devsuperior.dto.ClientDto;
import desafio3.devsuperior.exception.DatabaseIntegrityViolationException;
import desafio3.devsuperior.exception.ResourceNotFoundException;
import desafio3.devsuperior.model.Client;
import desafio3.devsuperior.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        Page<ClientDto> clientDtos = clients.map(ClientDto::new);
        return clientDtos;
    }

    @Transactional
    public ClientDto insert(ClientDto clientDto) {
        Client client = new Client();
        transformDtoToEntity(clientDto, client);
        clientRepository.save(client);
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto clientDto) {
        try {
            Client client = clientRepository.getReferenceById(id);
            transformDtoToEntity(clientDto, client);
            return new ClientDto(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseIntegrityViolationException("Violação da integridade referencial!");
        }

    }

    /*Método usado para converter de dto para entidade:*/
    public void transformDtoToEntity(ClientDto clientDto, Client client) {
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setIncome(clientDto.getIncome());
        client.setBirthDate(clientDto.getBirthDate());
        client.setChildren(clientDto.getChildren());
    }

}

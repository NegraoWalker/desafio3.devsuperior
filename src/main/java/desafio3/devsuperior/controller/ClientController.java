package desafio3.devsuperior.controller;

import desafio3.devsuperior.dto.ClientDto;
import desafio3.devsuperior.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

//    @GetMapping("/{id}")
//    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<ClientDto> findAll() {
//        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll(pageable));
//    }

    @PostMapping
    public ResponseEntity<ClientDto> insert(@RequestBody ClientDto clientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.insert(clientDto));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClientDto> update() {
//        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id, productDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        clientService.delete(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

}

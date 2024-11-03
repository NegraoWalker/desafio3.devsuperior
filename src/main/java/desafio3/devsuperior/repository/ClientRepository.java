package desafio3.devsuperior.repository;

import desafio3.devsuperior.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Long, Client> {
}
package br.com.gft.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

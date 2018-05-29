package br.net.ti2.MarinaAbramovick.repositories;


import br.net.ti2.MarinaAbramovick.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
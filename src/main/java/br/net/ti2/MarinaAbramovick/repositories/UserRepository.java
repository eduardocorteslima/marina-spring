package br.net.ti2.MarinaAbramovick.repositories;


import br.net.ti2.MarinaAbramovick.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);
}
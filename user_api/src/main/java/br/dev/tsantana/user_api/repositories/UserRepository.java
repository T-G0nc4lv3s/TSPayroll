package br.dev.tsantana.user_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.tsantana.user_api.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

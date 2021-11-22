package com.example.springpractice.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);  //email을 통해 가입 시 이미 생성된 사용자인지 확인
}

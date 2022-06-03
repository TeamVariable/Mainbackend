package com.backend.rootbackend.domain.repository;

import com.backend.rootbackend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, QuerydslPredicateExecutor<User> {
}

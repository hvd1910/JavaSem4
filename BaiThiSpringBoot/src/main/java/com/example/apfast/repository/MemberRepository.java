package com.example.apfast.repository;

import com.example.apfast.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Members, String> {
    Optional<Members> findByUserId(String userId);
}

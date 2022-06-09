package com.example.covoit.repository;

import com.example.covoit.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<ContactEntity, Integer> {
}

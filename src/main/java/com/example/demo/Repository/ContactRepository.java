package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.ContactMessage;

public interface ContactRepository extends JpaRepository<ContactMessage, Long>
{

}

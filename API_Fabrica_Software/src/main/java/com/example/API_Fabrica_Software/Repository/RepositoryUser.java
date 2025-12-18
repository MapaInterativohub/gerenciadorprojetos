package com.example.API_Fabrica_Software.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API_Fabrica_Software.Model.ClassUsers;

public interface RepositoryUser extends JpaRepository<ClassUsers,String>{
 Optional<ClassUsers> findByEmail(String email);
}

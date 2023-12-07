package com.example.tp1.Repository.Client;


import com.example.tp1.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>, ClientRepositoryCustum {

}

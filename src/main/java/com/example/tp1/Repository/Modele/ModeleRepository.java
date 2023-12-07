package com.example.tp1.Repository.Modele;

import com.example.tp1.Entity.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeleRepository extends JpaRepository<Modele,Long>,ModeleRepositoryCustom {

}

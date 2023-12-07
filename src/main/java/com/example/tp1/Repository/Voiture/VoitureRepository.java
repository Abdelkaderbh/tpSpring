package com.example.tp1.Repository.Voiture;

import com.example.tp1.Entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long>,VoitureRepositoryCustum {
}

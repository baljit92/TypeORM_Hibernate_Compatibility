package com.example.hibernate.repositories;

import java.util.List;

import com.example.hibernate.entities.Info;
import com.example.hibernate.entities.InfoDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * InfoRepository
 */
public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findAllByDescriptionContainingIgnoreCase (String description);

    List<Info> findAllByUserId(long id);

    @Query("SELECT new com.example.hibernate.entities.InfoDTO(q.description) FROM Info q WHERE q.userId =?1")
    List<InfoDTO> findInfosForUser (long id);

}
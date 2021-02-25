package com.nsw.fsjavapostgresreact.repositories;
import com.nsw.fsjavapostgresreact.models.Lounge;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoungeRepository extends JpaRepository<Lounge, Long> {

    Optional<Lounge> findByName(String name);
}

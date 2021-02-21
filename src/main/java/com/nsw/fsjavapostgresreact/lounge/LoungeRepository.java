package com.nsw.fsjavapostgresreact.lounge.repository;
import com.nsw.fsjavapostgresreact.lounge.Lounge;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoungeRepository extends JpaRepository<Lounge, Long> {

    Optional<Lounge> findByName(String name);
}

package com.brunojustino.restapi.repository;

import com.brunojustino.restapi.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Integer> {
}

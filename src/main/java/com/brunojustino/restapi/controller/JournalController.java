package com.brunojustino.restapi.controller;

import com.brunojustino.restapi.entity.Journal;
import com.brunojustino.restapi.entity.Users;
import com.brunojustino.restapi.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalController {
    @Autowired
    JournalRepository repo;

    @GetMapping("/journal")
    public List<Journal> getAllUsers(){
        List<Journal> journals = repo.findAll();
        return journals;
    }

    @PostMapping("/journal/add")
    public ResponseEntity<Journal> createUser(@RequestBody Journal journal) {
        Journal newJournal = repo.save(journal);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJournal);
    }
}

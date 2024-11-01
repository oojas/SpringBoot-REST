package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.Modals.Author;
import com.restfulapi.spring_rest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @PostMapping(value = "/storeValue")
    public Author storeAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
    @GetMapping(value = "/getAuthors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
//    @GetMapping(value = "/getAuthor/{author-id}")
//    public ResponseEntity<Author> getAuthById(@PathVariable(value = "author-id") Integer id){
//        return authorRepository.findById(id).map(author -> ResponseEntity.ok(author)).orElseGet(()->ResponseEntity.badRequest().body(new Author()));
//    }

    @GetMapping(value = "/getAuthorAge/{age}")
    public List<Author> getAuthorByFirstName(@PathVariable(value = "age") int age){
        return authorRepository.findAllByAgeGreaterThan(age);
//        return results.stream().map(
//             result-> new Author((Integer)result[0],(String)result[1],(String)result[2],(String)result[3],(int)result[4],(LocalDateTime)result[5],(LocalDateTime)result[6]))
//                .collect(Collectors.toList());
    }
}

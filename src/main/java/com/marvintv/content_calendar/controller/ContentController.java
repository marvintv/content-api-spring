package com.marvintv.content_calendar.controller;


import com.marvintv.content_calendar.model.Content;
import com.marvintv.content_calendar.repository.ContentCollectionRepository;
import com.marvintv.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin()
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    //make a request and find all peices of content in the system
    @GetMapping("")
    public List<Content> findAll(){

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable int id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public  void create(@Valid @RequestBody   Content content){
        repository.save(content);

    }



    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        if (!content.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "ID in path must match ID in request body");
        }
        repository.save(content);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.deleteById(id);
    }

}

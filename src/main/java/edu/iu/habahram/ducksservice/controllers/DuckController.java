package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.model.DuckData;
import edu.iu.habahram.ducksservice.model.Duck;
import edu.iu.habahram.ducksservice.repository.DucksRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ducks")
public class DuckController {

    private DucksRepository ducksRepository;

    public DuckController(DucksRepository ducksRepository) {
        this.ducksRepository = ducksRepository;
    }


   @PostMapping
    public int add(@RequestBody DuckData duck) {
       try {
           return ducksRepository.add(duck);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    @GetMapping
    public List<DuckData> findAll() {
        try {
            return ducksRepository.findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuckData> find(@PathVariable int id) {
        try {
            DuckData duck = ducksRepository.find(id);
            if(duck != null) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(duck);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/image")
    public boolean updateImage(@PathVariable int id,
                               @RequestParam MultipartFile file) {
        try {
            return ducksRepository.updateImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/audio")
    public boolean updateAudio(@PathVariable int id,
                               @RequestParam MultipartFile file) {
        try {
            return ducksRepository.updateAudio(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) {
        try {
            byte[] image = ducksRepository.getImage(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/audio")
    public ResponseEntity<?> getAudio(@PathVariable int id) {
        try {
            byte[] image = ducksRepository.getAudio(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.valueOf("audio/mp3"))
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

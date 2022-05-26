package controller;

import domain.Bakeries;
import domain.BakeriesDTO;
import service.BakeriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BakeriesController {

    private final BakeriesService bakeriesService;

    @Autowired
    public BakeriesController(BakeriesService bakeriesService){
        this.bakeriesService = bakeriesService;
    }

    @GetMapping("/bakeries")
    public ResponseEntity<List<BakeriesDTO>> getAllBakeries(){
        return new ResponseEntity<>(bakeriesService.getAllBakeries(), HttpStatus.OK);
    }

    @GetMapping("/bakeries/{id}")
    public ResponseEntity<BakeriesDTO> getBakeriesById(@PathVariable String id){
        return new ResponseEntity<>(bakeriesService.getBakeriesById(id), HttpStatus.OK);
    }


    @GetMapping("/exception")
    public ResponseEntity<BakeriesDTO> testException() throws Exception{
        throw new Exception("..");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }
}




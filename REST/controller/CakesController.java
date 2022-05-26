package controller;

import domain.Cakes;
import domain.CakesDTO;
import service.CakesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CakesController {
    private final CakesService cakesService;

    @Autowired
    public CakesController(CakesService cakesService){
        this.cakesService = cakesService;
    }

    @GetMapping("/cakes")
    public ResponseEntity<List<CakesDTO>> getAllCakes(){
        return new ResponseEntity<>(cakesService.getAllCakes(), HttpStatus.OK);
    }

    @GetMapping("/cakes/{id}")
    public ResponseEntity<CakesDTO> getCakesById(@PathVariable String id){
        return new ResponseEntity<>(cakesService.getCakesById(id), HttpStatus.OK);
    }

    @GetMapping("/exception")
    public ResponseEntity<CakesDTO> testException() throws Exception{
        throw new Exception("..");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }
}

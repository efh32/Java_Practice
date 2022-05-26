package controller;

import domain.BakeryInventory;
import domain.BakeryInventoryDTO;
import service.BakeryInventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BakeryInventoryController {

    private final BakeryInventoryService bakeryInventoryService;

    @Autowired
    public BakeryInventoryController(BakeryInventoryService bakeryInventoryService) {
        this.bakeryInventoryService = bakeryInventoryService;
    }

    @GetMapping("/bakeryInventory")
    public ResponseEntity<List<BakeryInventoryDTO>> getAllBakeryInventory() {
        return new ResponseEntity<>(bakeryInventoryService.getAllBakeryInventory(), HttpStatus.OK);
    }

    @GetMapping("/bakeryinventory/{id}")
    public ResponseEntity<BakeryInventoryDTO> getBakeryInventorybyId(@PathVariable String id) {
        return new ResponseEntity<>(bakeryInventoryService.getBakeryInventoryById(id), HttpStatus.OK);
    }

    @GetMapping("/exception")
    public ResponseEntity<BakeryInventoryDTO> testException() throws Exception{
        throw new Exception("..");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }
}

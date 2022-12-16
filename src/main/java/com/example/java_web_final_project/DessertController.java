package com.example.java_web_final_project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dessert")
public class DessertController {
    private final DessertService dessertService;
    private final DessertRepository dessertRepository;
    public DessertController(DessertService dessertService, DessertRepository dessertRepository){
        this.dessertService = dessertService;
        this.dessertRepository = dessertRepository;
    }


    @GetMapping
    public List<Dessert> getDesserts()
    {
        return dessertService.all();
    }

    @PostMapping
    public void addDessert(@RequestBody Dessert dessert)
    {
        dessertService.add(dessert);
    }



    @PutMapping("/{id}")
    public void updatedDessert(@RequestParam(value = "id") Integer id, @RequestBody Dessert dessert) {
        dessertService.update(dessert,id);
    }


    @DeleteMapping("/{id}")
    public void deleteDessert(@RequestParam(value = "id") Integer id) {
    dessertService.deleteDessert(id);
    }
}

package com.example.java_web_final_project;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DessertService {
    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository){
        this.dessertRepository = dessertRepository;
    }


    public List<Dessert> all()
    {
        return dessertRepository.findAll();
    }

    public void add(Dessert dessert)
    {
        dessertRepository.save(dessert);
    }


    public void update(Dessert dessert, int id){
        Optional<Dessert> dessert1 = dessertRepository.findById(id);
        if (dessert1.isPresent());

            Dessert updatedDessert = dessert1.get();

            updatedDessert.setName(dessert.getName());
            dessertRepository.save(updatedDessert);


    }
        public boolean deleteDessert(int id){
            dessertRepository.deleteById(id);
            return true;
        }

}

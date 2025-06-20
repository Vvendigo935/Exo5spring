package org.example.exo5spring.service;

import org.example.exo5spring.dao.FurnitureRepository;
import org.example.exo5spring.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
}
public Furniture getFurnitureById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
}
public Furniture createFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
}
public void delete(Furniture furniture) {
        furnitureRepository.delete(furniture);
}
public Furniture updateFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
}
}
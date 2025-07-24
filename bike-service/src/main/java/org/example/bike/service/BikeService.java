package org.example.bike.service;

import org.example.bike.entity.Bike;
import org.example.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll() {
        return bikeRepository.findAll();
    }

    public Bike getBikeById(int id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Bike update(int id, Bike bikeDetails) {
        Bike bike = bikeRepository.findById(id).orElse(null);
        if (bike != null) {
            bike.setBrand(bikeDetails.getBrand());
            bike.setModel(bikeDetails.getModel());
            return bikeRepository.save(bike);
        }
        return null;
    }

    public void delete(int id) {
        bikeRepository.deleteById(id);
    }
}

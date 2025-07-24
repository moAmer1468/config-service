package org.example.bike.controller;

import org.example.bike.entity.Bike;
import org.example.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id) {
        Bike bike = bikeService.getBikeById(id);
        if (bike == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike newBike = bikeService.save(bike);
        return ResponseEntity.ok(newBike);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> update(@PathVariable("id") int id, @RequestBody Bike bike) {
        Bike updatedBike = bikeService.update(id, bike);
        if (updatedBike == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Bike bike = bikeService.getBikeById(id);
        if (bike == null) {
            return ResponseEntity.notFound().build();
        }
        bikeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

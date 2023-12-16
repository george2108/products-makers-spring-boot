package com.application.rest.controllers;


import com.application.rest.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.services.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    @Autowired
    private IMakerService makerService;

    @GetMapping("/{id}")
    public ResponseEntity<Maker> findById(@PathVariable Long id) {
        Optional<Maker> maker = makerService.findById(id);

        // si no existe retornar un 404 y si existe retornar un 200 con el objeto
        return maker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Maker>> findAll() {
        return ResponseEntity.ok(makerService.findAll());
    }

    public ResponseEntity<Maker> save(@RequestBody MakerDTO makerDTO) {
        Maker maker = new Maker();
        maker.setName(makerDTO.getName());
        makerService.save(maker);

    }
}

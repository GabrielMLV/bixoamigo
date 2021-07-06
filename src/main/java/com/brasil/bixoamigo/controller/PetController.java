package com.brasil.bixoamigo.controller;

import com.brasil.bixoamigo.DTO.PetCriarAtualizarDTO;
import com.brasil.bixoamigo.Exceptions.PetException;
import com.brasil.bixoamigo.model.Pet;
import com.brasil.bixoamigo.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping({"/pet"})
public class PetController {

    @Resource
    private PetService petService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Pet>> all(){
        return ResponseEntity.ok().body(this.petService.findAll());
    }

    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Pet> adicionarPet(@RequestBody @Valid PetCriarAtualizarDTO pet){
        return ResponseEntity.ok().body(this.petService.criarPet(pet));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizarPet(@PathVariable Long id, @RequestBody @Valid PetCriarAtualizarDTO pet) throws PetException {
        return ResponseEntity.ok().body(this.petService.atualizarPet(id, pet));
    }
}

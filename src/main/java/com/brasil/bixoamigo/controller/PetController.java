package com.brasil.bixoamigo.controller;

import com.brasil.bixoamigo.DTO.PetCriarAtualizarDTO;
import com.brasil.bixoamigo.Exceptions.PetException;
import com.brasil.bixoamigo.model.Pet;
import com.brasil.bixoamigo.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping({"/pet"})
@Api(value = "Pet")
public class PetController {

    @Resource
    private PetService petService;

    @CrossOrigin
    @ApiOperation(value = "Retorna todos os Pets")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Pet>> all(){
        return ResponseEntity.ok().body(this.petService.findAll());
    }

    @CrossOrigin
    @ApiOperation(value = "Criar Pet")
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes = "aplication/json")
    public ResponseEntity<PetCriarAtualizarDTO> adicionarPet(@RequestBody @Valid PetCriarAtualizarDTO pet){
        return this.petService.criarPet(pet);
    }

    @CrossOrigin
    @ApiOperation(value = "Atualizar Pet existente")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces="application/json", consumes = "aplication/json")
    public ResponseEntity<PetCriarAtualizarDTO> atualizarPet(@PathVariable Long id, @RequestBody @Valid PetCriarAtualizarDTO pet) throws PetException {
        return this.petService.atualizarPet(id, pet);
    }

    @CrossOrigin
    @ApiOperation(value = "Remove um Pet existente")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarPet(@PathVariable Long id) throws PetException {
        return this.petService.deletarPet(id);
    }

    @CrossOrigin
    @ApiOperation(value = "Retorna um Pet existente")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Pet> buscarPet(@PathVariable Long id) throws PetException {
        return this.petService.buscarPet(id);
    }
}

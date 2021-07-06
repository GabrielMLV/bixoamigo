package com.brasil.bixoamigo.service;

import com.brasil.bixoamigo.DTO.PetCriarAtualizarDTO;
import com.brasil.bixoamigo.Exceptions.PetException;
import com.brasil.bixoamigo.model.Pet;
import com.brasil.bixoamigo.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PetService {

    @Resource
    private PetRepository petRepository;

    public List<Pet> findAll(){
        return petRepository.findAll();
    }

    public Pet criarPet(PetCriarAtualizarDTO petDTO){
        Pet newPet = PetCriarAtualizarDTO.criarPet(petDTO);
        return this.petRepository.save(newPet);
    }

    @Transactional
    public Pet atualizarPet(Long id, PetCriarAtualizarDTO petDTO) throws PetException{
            Pet pet = this.petRepository.getById(id);
            System.out.println(pet.getNome());
            System.out.println("Pas");
            if(!Objects.nonNull(pet)){
                throw new PetException("Pet não encontrado");
            }
            pet.setNome(petDTO.getNome());
            pet.setBio(petDTO.getBio());
            pet.setTipoPet(petDTO.getTipoPet());
            pet.setGeneroPet(petDTO.getGeneroPet());
            pet.setRaca(petDTO.getRaca());
            pet.setNascimento(petDTO.getNascimento());
            pet.setPesoAtual(petDTO.getPesoAtual());

            return this.petRepository.save(pet);



    };

}

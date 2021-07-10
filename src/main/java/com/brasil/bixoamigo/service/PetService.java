package com.brasil.bixoamigo.service;

import com.brasil.bixoamigo.DTO.PetCriarAtualizarDTO;
import com.brasil.bixoamigo.DTO.response.ResponsePetDTO;
import com.brasil.bixoamigo.Exceptions.PetException;
import com.brasil.bixoamigo.model.Pet;
import com.brasil.bixoamigo.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PetService {

    @Resource
    private PetRepository petRepository;

    public List<Pet> findAll(){
        return petRepository.findAll();
    }

    public ResponseEntity<PetCriarAtualizarDTO> criarPet(PetCriarAtualizarDTO petDTO){
        Pet newPet = PetCriarAtualizarDTO.criarPet(petDTO);
        return ResponseEntity.ok().body(new PetCriarAtualizarDTO(this.petRepository.save(newPet)));
    }

    @Transactional
    public ResponseEntity<PetCriarAtualizarDTO> atualizarPet(Long id, PetCriarAtualizarDTO petDTO) throws PetException{

        return petRepository.findById(id)
            .map(record -> {
                record.setNome(petDTO.getNome());
                record.setBio(petDTO.getBio());
                record.setTipoPet(petDTO.getTipoPet());
                record.setGeneroPet(petDTO.getGeneroPet());
                record.setRaca(petDTO.getRaca());
                record.setNascimento(petDTO.getNascimento());
                record.setPesoAtual(petDTO.getPesoAtual());
                Pet updated = petRepository.save(record);
                return ResponseEntity.ok().body(new PetCriarAtualizarDTO(updated));
            }).orElse(ResponseEntity.notFound().build());

    };

    @Transactional
    public ResponseEntity<?> deletarPet(Long idPet){
        return petRepository.findById(idPet)
            .map(record -> {
                petRepository.deleteById(idPet);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ResponsePetDTO> buscarPet(Long idPet){
        return petRepository.findById(idPet)
                .map(record -> ResponseEntity.ok().body(new ResponsePetDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }



}

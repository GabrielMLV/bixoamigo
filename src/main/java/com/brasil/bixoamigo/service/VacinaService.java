package com.brasil.bixoamigo.service;

import com.brasil.bixoamigo.DTO.VacinaCriarAtualizarDTO;
import com.brasil.bixoamigo.model.Vacina;
import com.brasil.bixoamigo.repository.PetRepository;
import com.brasil.bixoamigo.repository.VacinaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class VacinaService {

    @Resource
    private VacinaRepository vacinaRepository;

    @Resource
    private PetRepository petRepository;


    @Transactional
    public ResponseEntity<VacinaCriarAtualizarDTO> adicionarVacinaAoPet(VacinaCriarAtualizarDTO vacinaDTO){
        return petRepository.findById(vacinaDTO.getId_pet())
            .map(pet -> {
                Vacina vacina = VacinaCriarAtualizarDTO.converterVacina(vacinaDTO, pet);
                return ResponseEntity.ok().body(new VacinaCriarAtualizarDTO(this.vacinaRepository.save(vacina)));
            }).orElse(ResponseEntity.notFound().build());

    }
}

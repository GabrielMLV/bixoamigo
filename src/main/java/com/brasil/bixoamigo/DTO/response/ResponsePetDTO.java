package com.brasil.bixoamigo.DTO.response;

import com.brasil.bixoamigo.enums.GeneroPet;
import com.brasil.bixoamigo.enums.TipoPet;
import com.brasil.bixoamigo.model.Pet;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponsePetDTO {

    private Long id;
    private String nome;
    private String bio;
    private String raca;
    private TipoPet tipoPet;
    private GeneroPet generoPet;
    private LocalDate nascimento;
    private BigDecimal pesoAtual;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaAtualizacao;
    private List<ResponseVacinaDTO> vacinas;

    public ResponsePetDTO(Pet pet){
        this.id = pet.getId();
        this.nome = pet.getNome();
        this.bio = pet.getBio();
        this.generoPet = pet.getGeneroPet();
        this.tipoPet = pet.getTipoPet();
        this.nascimento = pet.getNascimento();
        this.pesoAtual = pet.getPesoAtual();
        this.raca = pet.getRaca();
        this.dataCriacao = pet.getDataCriacao();
        this.dataUltimaAtualizacao = pet.getDataUltimaAtualizacao();
        this.vacinas = ResponseVacinaDTO.convertVacinas(pet.getVacinas());
    }

    public static List<ResponsePetDTO> converterPets(List<Pet> pets){
        List<ResponsePetDTO> petDTOS = new ArrayList<>();

        for(Pet p: pets){
            petDTOS.add(new ResponsePetDTO(p));
        }

        return petDTOS;
    }
}

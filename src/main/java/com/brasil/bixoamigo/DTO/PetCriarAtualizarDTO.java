package com.brasil.bixoamigo.DTO;

import com.brasil.bixoamigo.enums.GeneroPet;
import com.brasil.bixoamigo.enums.TipoPet;
import com.brasil.bixoamigo.model.Pet;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PetCriarAtualizarDTO {

    @NonNull
    private String nome;

    @NonNull
    private String bio;

    @NonNull
    private String raca;

    @NonNull
    private TipoPet tipoPet;

    @NonNull
    private GeneroPet generoPet;

    private LocalDate nascimento;
    private BigDecimal pesoAtual;


    public static Pet criarPet(PetCriarAtualizarDTO petCriarAtualizarDTO){
        Pet novoPet = new Pet();
        novoPet.setNome(petCriarAtualizarDTO.getNome());
        novoPet.setBio(petCriarAtualizarDTO.getBio());
        novoPet.setGeneroPet(petCriarAtualizarDTO.getGeneroPet());
        novoPet.setTipoPet(petCriarAtualizarDTO.getTipoPet());
        novoPet.setNascimento(petCriarAtualizarDTO.getNascimento());
        novoPet.setPesoAtual(petCriarAtualizarDTO.getPesoAtual());
        novoPet.setRaca(petCriarAtualizarDTO.getRaca());

        return novoPet;
    }
}

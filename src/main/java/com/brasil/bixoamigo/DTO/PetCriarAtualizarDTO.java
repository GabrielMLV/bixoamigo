package com.brasil.bixoamigo.DTO;

import com.brasil.bixoamigo.enums.GeneroPet;
import com.brasil.bixoamigo.enums.TipoPet;
import com.brasil.bixoamigo.model.Pet;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PetCriarAtualizarDTO {

    private Long id;

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

    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaAtualizacao;


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

    public PetCriarAtualizarDTO(Pet pet){
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
    }
}

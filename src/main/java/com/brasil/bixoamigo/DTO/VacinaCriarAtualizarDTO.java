package com.brasil.bixoamigo.DTO;

import com.brasil.bixoamigo.enums.StatusVacina;
import com.brasil.bixoamigo.model.Pet;
import com.brasil.bixoamigo.model.Vacina;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VacinaCriarAtualizarDTO {

    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String observacao;

    @NonNull
    private StatusVacina statusVacina;

    @NonNull
    private Long id_pet;

    private LocalDate dataVacinacao;

    private LocalDate revacinar;

    public static Vacina converterVacina(VacinaCriarAtualizarDTO vacinaDTO, Pet pet){
        Vacina novaVacina = new Vacina();
        novaVacina.setNome(vacinaDTO.getNome());
        novaVacina.setObservacao(vacinaDTO.getObservacao());
        novaVacina.setDataVacinacao(vacinaDTO.getDataVacinacao());
        novaVacina.setRevacinar(vacinaDTO.getRevacinar());
        novaVacina.setStatusVacina(vacinaDTO.getStatusVacina());
        novaVacina.setPet(pet);

        return novaVacina;
    }

    public VacinaCriarAtualizarDTO(Vacina vacina){
        this.id = vacina.getId();
        this.nome = vacina.getNome();
        this.observacao = vacina.getObservacao();
        this.dataVacinacao = vacina.getDataVacinacao();
        this.revacinar = vacina.getRevacinar();
        this.statusVacina = vacina.getStatusVacina();
        this.id_pet = vacina.getPet().getId();
    }

}

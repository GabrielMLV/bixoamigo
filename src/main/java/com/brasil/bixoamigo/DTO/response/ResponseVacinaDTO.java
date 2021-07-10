package com.brasil.bixoamigo.DTO.response;

import com.brasil.bixoamigo.enums.StatusVacina;
import com.brasil.bixoamigo.model.Vacina;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseVacinaDTO {

    private Long id;

    private String nome;

    private String observacao;

    private LocalDate dataVacinacao;

    private LocalDate revacinar;

    private StatusVacina statusVacina;

    private Long id_pet;

    public ResponseVacinaDTO(Vacina vacina){
        this.id = vacina.getId();
        this.nome = vacina.getNome();
        this.observacao = vacina.getObservacao();
        this.dataVacinacao = vacina.getDataVacinacao();
        this.revacinar = vacina.getRevacinar();
        this.statusVacina = vacina.getStatusVacina();
        this.id_pet = vacina.getPet().getId();
    }

    public static List<ResponseVacinaDTO> convertVacinas(List<Vacina> vacinas){
        List<ResponseVacinaDTO> r = new ArrayList<>();

        for(Vacina v : vacinas){
            r.add(new ResponseVacinaDTO(v));
        }

        return r;
    }
}

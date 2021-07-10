package com.brasil.bixoamigo.model;

import com.brasil.bixoamigo.enums.StatusVacina;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "vacinas")
@Table(name = "vacinas")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nome")
    private String nome;

    @NonNull
    @Column(name = "observacao")
    private String observacao;

    @Column(name = "data_vacinacao")
    private LocalDate dataVacinacao;

    @Column(name = "revacinar")
    private LocalDate revacinar;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_vacina")
    private StatusVacina statusVacina;

    @ManyToOne
    @JoinColumn(name="id_pet")
    private Pet pet;

}

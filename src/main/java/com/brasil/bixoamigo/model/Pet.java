package com.brasil.bixoamigo.model;

import com.brasil.bixoamigo.enums.GeneroPet;
import com.brasil.bixoamigo.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "pets")
@SQLDelete(sql = "UPDATE pets SET deleted=true WHERE id=?") //delete seta status deleted para true
@Where(clause = "deleted = false") //retorna apenas os registros com status deleted = false (não deletado)
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nome")
    private String nome;

    @NonNull
    @Column(name = "bio")
    private String bio;

    @NonNull
    @Column(name = "raca")
    private String raca;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pet")
    private TipoPet tipoPet;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "genero_pet")
    private GeneroPet generoPet;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @Column(name = "peso_atual", columnDefinition = "NUMERIC(2,3)")
    private BigDecimal pesoAtual;

    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataUltimaAtualizacao;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Vacina> vacinas;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;



}

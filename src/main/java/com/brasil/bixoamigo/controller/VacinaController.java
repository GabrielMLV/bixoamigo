package com.brasil.bixoamigo.controller;

import com.brasil.bixoamigo.DTO.PetCriarAtualizarDTO;
import com.brasil.bixoamigo.DTO.VacinaCriarAtualizarDTO;
import com.brasil.bixoamigo.service.VacinaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/vacina"})
@Api(value = "Vacina")
public class VacinaController {

    @Resource
    private VacinaService vacinaService;

    @CrossOrigin
    @ApiOperation(value = "Adicionar vacina ao Pet")
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes = "application/json")
    public ResponseEntity<VacinaCriarAtualizarDTO> adicionarVacina(@RequestBody @Valid VacinaCriarAtualizarDTO vacinaDTO){
        return this.vacinaService.adicionarVacinaAoPet(vacinaDTO);
    }
}

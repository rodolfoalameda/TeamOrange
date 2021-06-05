package com.teamorange.fipapi.controller;

import com.teamorange.fipapi.domain.model.VeiculoDTO;
import com.teamorange.fipapi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDTO> insert(@RequestBody VeiculoDTO veiculoDTO){
        veiculoService.insert(veiculoDTO);
        return new ResponseEntity<VeiculoDTO>(HttpStatus.CREATED);
    }
}

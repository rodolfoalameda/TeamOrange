package com.teamorange.fipapi.controller;

import com.teamorange.fipapi.domain.model.UsuarioDTO;
import com.teamorange.fipapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuarioDTO){
       usuarioService.insert(usuarioDTO);
       return new ResponseEntity<UsuarioDTO>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
}

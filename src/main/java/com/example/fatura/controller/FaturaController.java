package com.example.fatura.controller;

import com.example.fatura.model.Fatura;
import com.example.fatura.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaRepository faturaRepository;
    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Fatura> adicionarFatura(@Valid @RequestBody Fatura fatura) {
        return ResponseEntity.ok(faturaRepository.save(fatura));
    }
}

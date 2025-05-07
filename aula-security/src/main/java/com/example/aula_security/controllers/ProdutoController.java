package com.example.aula_security.controllers;

import com.example.aula_security.domain.product.Produto;
import com.example.aula_security.domain.product.ProdutoDTO;
import com.example.aula_security.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ProdutoDTO dto = produtoService.findByID(id);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> getAllProducts() {
        return produtoService.findAll();
    }

    @PostMapping
    public ProdutoDTO registrarProdutor(@RequestBody Produto body) {
        Produto newProduto = produtoService.registrarProduto(body);

        return new ProdutoDTO(newProduto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO product) {
        return produtoService.atualizarProduto(id, product);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

}

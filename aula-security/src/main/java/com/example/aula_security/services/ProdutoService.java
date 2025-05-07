package com.example.aula_security.services;


import com.example.aula_security.domain.product.Produto;
import com.example.aula_security.domain.product.ProdutoDTO;
import com.example.aula_security.exceptions.RecursoNaoEncontradoException;
import com.example.aula_security.repositories.ProdutoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto registrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findByID(Long id) {
        return produtoRepository.findById(id).map(ProdutoDTO::new).orElseThrow( () -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {

        return produtoRepository.findAll().stream().map(ProdutoDTO::new).toList();
    }


    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setDesc(dto.getDesc());
        produto.setPreco(dto.getPreco());

        return new ProdutoDTO(produto);
    }

    @Transactional
    public void deletarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }

}

package com.example.aula_security.domain.product;

import jakarta.persistence.*;
import java.util.Objects;

@Table(name = "produtos")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, name = "produto_id")
    private Long id;
    @Column(nullable = false, name = "produto_nome", columnDefinition = "TEXT")
    private String nome;
    @Column(nullable = false, name = "produto_desc", columnDefinition = "TEXT")
    private String desc;
    @Column(nullable = false, name = "produto_preco")
    private Double preco;

    public Produto(String nome, String desc, Double preco) {
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
    }

    public Produto() {
    }

    public Produto(ProdutoDTO data){
        this.nome = data.getNome();
        this.desc = data.getDesc();
        this.preco = data.getPreco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(desc, produto.desc) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, desc, preco);
    }

}

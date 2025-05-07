package com.example.aula_security.domain.product;


import org.springframework.beans.BeanUtils;


public class ProdutoDTO {

    private Long id;
    private String nome;
    private String desc;
    private Double preco;


    public ProdutoDTO(Produto produto) {
        BeanUtils.copyProperties(produto, this);
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
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", preço=" + preco +
                '}';
    }
}
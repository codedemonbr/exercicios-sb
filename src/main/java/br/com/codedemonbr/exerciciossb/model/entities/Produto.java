package br.com.codedemonbr.exerciciossb.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	private String name;

	@Min(0)
	@Max(1)
	private Double desconto;

	@Min(0)
	private Double preco;

	public Produto() {
		super();
	}

	public Produto(String name, Double desconto, Double preco) {
		super();
		this.name = name;
		setPreco(preco);
		setDesconto(desconto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {

		this.preco = preco;

	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {

		this.desconto = desconto;

	}

}

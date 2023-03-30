package com.ficticiusclean.deliveryclean.business.veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VeiculoFakeBuilder {
	
	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	private LocalDate dataFabricacao;
	private BigDecimal consumoCidade;
	private BigDecimal consumoRodovias;
	
	public VeiculoFakeBuilder padrao() {
		this.id = new Random().nextLong();
		this.nome = "Veiculo " + UUID.randomUUID().toString();
		this.marca = "Marca 1";
		this.modelo = "Modelo 1";
		this.dataFabricacao = LocalDate.now().minusMonths(5);
		this.consumoCidade = new BigDecimal("12");
		this.consumoRodovias = new BigDecimal("16");
		return this;
	}
	
	public VeiculoFakeBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public VeiculoFakeBuilder nomeNulo() {
		this.nome = null;
		return this;
	}
	
	public VeiculoFakeBuilder marcaNulo() {
		this.marca = null;
		return this;
	}

	public VeiculoFakeBuilder modeloNulo() {
		this.modelo = null;
		return this;
	}
	
	public VeiculoFakeBuilder nomeEmBranco() {
		this.nome = "";
		return this;
	}
	
	public VeiculoFakeBuilder marcaEmBranco() {
		this.marca = "";
		return this;
	}

	public VeiculoFakeBuilder modeloEmBranco() {
		this.modelo = "";
		return this;
	}

	public VeiculoFakeBuilder dataFabricacaoNulo() {
		this.dataFabricacao = null;
		return this;
	}

	public VeiculoFakeBuilder consumoCidadeNulo() {
		this.consumoCidade = null;
		return this;
	}

	public VeiculoFakeBuilder consumoRodoviasNulo() {
		this.consumoRodovias = null;
		return this;
	}
	
	public VeiculoFakeBuilder setConsumoCidade(BigDecimal consumoCidade) {
		this.consumoCidade = consumoCidade;
		return this;
	}
	
	public VeiculoFakeBuilder setConsumoRodovias(BigDecimal consumoRodovias) {
		this.consumoRodovias = consumoRodovias;
		return this;
	}
	
	public VeiculoFakeBuilder setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
		return this;
	}
	
	public Veiculo novoVeiculo() {
		return new Veiculo(id, nome, marca, modelo, dataFabricacao, consumoCidade, consumoRodovias, false);
	}

}

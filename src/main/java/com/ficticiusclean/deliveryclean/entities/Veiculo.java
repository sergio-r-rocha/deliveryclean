package com.ficticiusclean.deliveryclean.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ficticiusclean.deliveryclean.web.dto.veiculo.AtualizaVeiculoDto;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.CadastroVeiculoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "veiculos")
@NoArgsConstructor
@AllArgsConstructor()
@EqualsAndHashCode(of = "id")
@ToString
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	@NotBlank
	@Getter
	@Column(unique = true)
	private String nome;
	@NotBlank
	@Getter
	private String marca;
	@NotBlank
	@Getter
	private String modelo;
	@NotNull
	@Getter
	@Column(name = "data_fabricacao")
	private LocalDate dataFabricacao;
	@NotNull
	@Getter
	@Column(name = "consumo_cidade")
	private BigDecimal consumoCidade;
	@NotNull
	@Getter
	@Column(name = "consumo_rodovias")
	private BigDecimal consumoRodovias;
	@Getter
	private boolean excluido;
	public Veiculo(CadastroVeiculoDto dados) {
		this.nome = dados.nome();
		this.marca = dados.marca();
		this.modelo = dados.modelo();
		this.dataFabricacao = dados.dataFabricacao();
		this.consumoCidade = dados.consumoCidade();
		this.consumoRodovias = dados.consumoRodovias();
	}
	public Veiculo(AtualizaVeiculoDto dados) {
		this.id = dados.id();
		this.nome = dados.nome();
		this.marca = dados.marca();
		this.modelo = dados.modelo();
		this.dataFabricacao = dados.dataFabricacao();
		this.consumoCidade = dados.consumoCidade();
		this.consumoRodovias = dados.consumoRodovias();
	}
	public void excluir() {
		this.excluido = true;
	}

}

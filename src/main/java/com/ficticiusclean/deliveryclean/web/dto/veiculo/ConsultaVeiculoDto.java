package com.ficticiusclean.deliveryclean.web.dto.veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

public record ConsultaVeiculoDto(Long id , String nome, String marca, String modelo, LocalDate dataFabricacao, BigDecimal consumoCidade, BigDecimal consumoRodovias) {
	
	public ConsultaVeiculoDto(Veiculo veiculo) {
		this(veiculo.getId(), veiculo.getNome(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getDataFabricacao(),
				veiculo.getConsumoCidade(), veiculo.getConsumoRodovias());
	}

}

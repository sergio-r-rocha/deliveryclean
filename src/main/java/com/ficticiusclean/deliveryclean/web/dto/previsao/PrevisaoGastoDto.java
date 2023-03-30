package com.ficticiusclean.deliveryclean.web.dto.previsao;

import java.math.BigDecimal;

import com.ficticiusclean.deliveryclean.business.previsaogasto.PrevisaoGasto;

public record PrevisaoGastoDto(
		String nome,
		String marca,
		Integer ano,
		BigDecimal combustivelGasto,
		BigDecimal valorGasto 
	) {
	
	public PrevisaoGastoDto(PrevisaoGasto previsaoGasto) {
		this(previsaoGasto.getVeiculo().getNome(), previsaoGasto.getVeiculo().getMarca(),
				previsaoGasto.getVeiculo().getDataFabricacao().getYear(), previsaoGasto.getQuantidadeCombustivel(),
				previsaoGasto.getValorGasto());
	}

}

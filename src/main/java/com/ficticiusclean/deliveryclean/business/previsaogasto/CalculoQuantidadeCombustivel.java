package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

@Component
public class CalculoQuantidadeCombustivel {
	
	public BigDecimal calcular(Veiculo veiculo, BigDecimal kmCidade, BigDecimal kmRodovias) {
		BigDecimal gastoCidade = kmCidade != null ? kmCidade.divide(veiculo.getConsumoCidade(), 2, RoundingMode.HALF_EVEN) : BigDecimal.ZERO;
		BigDecimal gastoRodovias = kmRodovias != null ? kmRodovias.divide(veiculo.getConsumoRodovias(), 2, RoundingMode.HALF_EVEN) : BigDecimal.ZERO;
		
		return gastoCidade.add(gastoRodovias).setScale(2);
	}

}

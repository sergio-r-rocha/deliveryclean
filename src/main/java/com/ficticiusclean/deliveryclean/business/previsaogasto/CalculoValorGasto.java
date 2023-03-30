package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculoValorGasto {
	
	public BigDecimal calcular(BigDecimal precoCombustivel, BigDecimal quantidadeCombustivel) {
		return precoCombustivel != null && quantidadeCombustivel!= null ? precoCombustivel.multiply(quantidadeCombustivel).setScale(2) : BigDecimal.ZERO.setScale(2);
	}

}

package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.math.BigDecimal;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class PrevisaoGasto {
	
	@Getter
	private Veiculo veiculo;
	@Getter
	private BigDecimal quantidadeCombustivel;
	@Getter
	private BigDecimal valorGasto;

}

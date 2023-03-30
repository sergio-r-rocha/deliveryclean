package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculoValorGastoTest {
	
	@Autowired
	private CalculoValorGasto calculo;
	
	@Test
	void informa_preco_e_quantidade() {
		BigDecimal precoCombustivel = new BigDecimal("5");
		BigDecimal quantidadeCombustivel = new BigDecimal("33.00");
		
		assertThat(new BigDecimal("165.00")).isEqualTo(calculo.calcular(precoCombustivel, quantidadeCombustivel));
	}
	
	@Test
	void nao_informa_preco() {
		BigDecimal precoCombustivel = null;
		BigDecimal quantidadeCombustivel = new BigDecimal("25.30");
		
		assertThat(new BigDecimal("0.00")).isEqualTo(calculo.calcular(precoCombustivel, quantidadeCombustivel));
	}
	
	@Test
	void nao_informa_quantidade() {
		BigDecimal precoCombustivel = new BigDecimal("5.00");
		BigDecimal quantidadeCombustivel = null;
		
		assertThat(new BigDecimal("0.00")).isEqualTo(calculo.calcular(precoCombustivel, quantidadeCombustivel));
	}

	@Test
	void nao_informa_quantidade_nem_preco() {
		BigDecimal precoCombustivel = null;
		BigDecimal quantidadeCombustivel = null;
		
		assertThat(new BigDecimal("0.00")).isEqualTo(calculo.calcular(precoCombustivel, quantidadeCombustivel));
	}

}

package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

@SpringBootTest
public class CalculoQuantidadeCombustiveTest {
	
	@Autowired
	private CalculoQuantidadeCombustivel calculo;
	
	private Veiculo veiculo;
	
	@BeforeEach
	public void setup() {
		veiculo = new Veiculo(1L, "Veículo 1", "Veículo 1", "Veículo 1", LocalDate.now().minusMonths(5),
				new BigDecimal("10"), new BigDecimal("12"), false);
	}
	
	@Test
	public void calcular_informando_cidade_e_rodovias() {
		BigDecimal quantidade = calculo.calcular(veiculo, new BigDecimal("50"), new BigDecimal("120"));
		
		assertEquals(new BigDecimal("15.00"), quantidade);
	}
	
	@Test
	public void calcular_informando_apenas_cidade() {
		BigDecimal quantidade = calculo.calcular(veiculo, new BigDecimal("50"), null);
		
		assertEquals(new BigDecimal("5.00"), quantidade);
	}
	
	@Test
	public void calcular_informando_apenas_rodovias() {
		BigDecimal quantidade = calculo.calcular(veiculo, null, new BigDecimal("90"));
		
		assertEquals(new BigDecimal("7.50"), quantidade);
	}
	
	@Test
	public void calcular_nao_informando_nem_cidade_nem_rodovias() {
		BigDecimal quantidade = calculo.calcular(veiculo, null, null);
		
		assertEquals(new BigDecimal("0.00"), quantidade);
	}

}

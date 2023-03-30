package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoFakeBuilder;
import com.ficticiusclean.deliveryclean.entities.Veiculo;
import com.ficticiusclean.deliveryclean.repositories.VeiculoRepository;

@SpringBootTest
class CalculoPrevisaoTest {
	
	@MockBean
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CalculoPrevisao calculoPrevisao;
	
	private VeiculoFakeBuilder veiculoBuilderPadrao;
	
	@BeforeEach
	public void setup() {
		veiculoBuilderPadrao = new VeiculoFakeBuilder();
	}

	@Test
	void calcular_previsao() {
		Veiculo gastador  = veiculoBuilderPadrao.padrao().setConsumoCidade(BigDecimal.ONE).setConsumoRodovias(BigDecimal.ONE).novoVeiculo();
		Veiculo economico = veiculoBuilderPadrao.padrao().setConsumoCidade(BigDecimal.TEN).setConsumoRodovias(BigDecimal.TEN).novoVeiculo();
		
		List<Veiculo> listVeiculos = Arrays.asList(gastador, economico);
		
		Mockito.when(veiculoRepository.findAll()).thenReturn(listVeiculos);
		
		BigDecimal precoGasolina = new BigDecimal("5");
		BigDecimal kmCidade = new BigDecimal("50");
		BigDecimal kmRodovias = new BigDecimal("55");
		
		List<PrevisaoGasto> listPrevisao = calculoPrevisao.calcularPrevisao(precoGasolina, kmCidade, kmRodovias);
		
		assertThat(new BigDecimal("105.00")).isEqualTo(listPrevisao.get(0).getQuantidadeCombustivel());
		assertThat(new BigDecimal("525.00")).isEqualTo(listPrevisao.get(0).getValorGasto());
		assertThat(new BigDecimal("10.50")).isEqualTo(listPrevisao.get(1).getQuantidadeCombustivel());
		assertThat(new BigDecimal("52.50")).isEqualTo(listPrevisao.get(1).getValorGasto());
	}

}

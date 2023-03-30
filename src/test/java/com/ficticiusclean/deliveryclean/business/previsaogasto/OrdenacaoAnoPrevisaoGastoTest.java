package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

class OrdenacaoAnoPrevisaoGastoTest {
	
	@Test
	void ordenacao_correta() {
		Veiculo veiculoAnoAtual = new Veiculo(1L, "Veículo 1", "Marca 1", "Modelo 1", LocalDate.now(), BigDecimal.TEN, BigDecimal.TEN, false);
		Veiculo veiculoAnoPassado = new Veiculo(2L, "Veículo 2", "Marca 2", "Modelo 2", LocalDate.now().minusYears(1), BigDecimal.TEN, BigDecimal.TEN, false);
		PrevisaoGasto previsao1 = new PrevisaoGasto(veiculoAnoAtual, BigDecimal.TEN, BigDecimal.TEN);
		PrevisaoGasto previsao2 = new PrevisaoGasto(veiculoAnoPassado, BigDecimal.TEN, BigDecimal.TEN);
		
		List<PrevisaoGasto> list = new ArrayList<>();
		list.add(previsao1);
		list.add(previsao2);
		
		OrdenacaoPrevisaoGasto ordenacao = new OrdenacaoAnoPrevisaoGasto();
		ordenacao.executar(list);
		
		assertThat(list.get(0)).isEqualTo(previsao2);
	}

	@Test
	void lista_nula_nao_levantar_excecao() {
		List<PrevisaoGasto> list = null;
		OrdenacaoPrevisaoGasto ordenacao = new OrdenacaoAnoPrevisaoGasto();
		ordenacao.executar(list);
		assertThat(list).isNull();
	}

}

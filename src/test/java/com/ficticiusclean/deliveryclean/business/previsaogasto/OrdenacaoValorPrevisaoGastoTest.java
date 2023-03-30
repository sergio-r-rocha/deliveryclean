package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

class OrdenacaoValorPrevisaoGastoTest {

	@Test
	void ordenacao_correta() {
		Veiculo veiculo1 = new Veiculo();
		Veiculo veiculo2 = new Veiculo();
		PrevisaoGasto previsao1 = new PrevisaoGasto(veiculo1, BigDecimal.TEN, BigDecimal.TEN);
		PrevisaoGasto previsao2 = new PrevisaoGasto(veiculo2, BigDecimal.ONE, BigDecimal.ONE);
		
		List<PrevisaoGasto> list = new ArrayList<>();
		list.add(previsao1);
		list.add(previsao2);
		
		OrdenacaoPrevisaoGasto ordenacao = new OrdenacaoValorPrevisaoGasto();
		ordenacao.executar(list);
		
		assertThat(list.get(0)).isEqualTo(previsao2);
	}

	@Test
	void lista_nula_nao_levantar_excecao() {
		List<PrevisaoGasto> list = null;
		OrdenacaoPrevisaoGasto ordenacao = new OrdenacaoValorPrevisaoGasto();
		ordenacao.executar(list);
		assertThat(list).isNull();
	}

}

package com.ficticiusclean.deliveryclean.web.dto.previsao;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.ficticiusclean.deliveryclean.business.previsaogasto.PrevisaoGasto;
import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoFakeBuilder;
import com.ficticiusclean.deliveryclean.entities.Veiculo;

class PrevisaoGastoDtoTest {

	@Test
	void test() {
		Veiculo veiculo = new VeiculoFakeBuilder().padrao().novoVeiculo();
		PrevisaoGasto previsaoGasto = new PrevisaoGasto(veiculo, BigDecimal.ONE, BigDecimal.TEN);
		PrevisaoGastoDto dto = new PrevisaoGastoDto(previsaoGasto);
		assertThat(previsaoGasto.getVeiculo().getNome()).isEqualTo(dto.nome());
		assertThat(previsaoGasto.getVeiculo().getMarca()).isEqualTo(dto.marca());
		assertThat(previsaoGasto.getVeiculo().getDataFabricacao().getYear()).isEqualTo(dto.ano());
		assertThat(previsaoGasto.getQuantidadeCombustivel()).isEqualTo(dto.combustivelGasto());
		assertThat(previsaoGasto.getValorGasto()).isEqualTo(dto.valorGasto());
	}

}

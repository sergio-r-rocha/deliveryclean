package com.ficticiusclean.deliveryclean.business.previsaogasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoFakeBuilder;

class PrevisaoGastoTest {

	@Test
	void equals_e_hash_code_veiculos_diferentes() {
		var veiculo1 = new VeiculoFakeBuilder().padrao().novoVeiculo();
		var previsaoGasto1 = new PrevisaoGasto(veiculo1, BigDecimal.ONE, BigDecimal.TEN);
		
		var veiculo2 = new VeiculoFakeBuilder().padrao().novoVeiculo();
		var previsaoGasto2 = new PrevisaoGasto(veiculo2, BigDecimal.ONE, BigDecimal.TEN);
		
		assertThat(previsaoGasto1).isNotEqualTo(previsaoGasto2);
		assertThat(previsaoGasto1.hashCode()).isNotEqualByComparingTo(previsaoGasto2.hashCode());
	}
	
	@Test
	void equals_e_hash_code_veiculos_com_mesmo_id() {
		var veiculo1 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto1 = new PrevisaoGasto(veiculo1, BigDecimal.ONE, BigDecimal.TEN);
		
		var veiculo2 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto2 = new PrevisaoGasto(veiculo2, BigDecimal.ONE, BigDecimal.TEN);
		
		assertThat(previsaoGasto1).isEqualTo(previsaoGasto2);
		assertThat(previsaoGasto1.hashCode()).isEqualByComparingTo(previsaoGasto2.hashCode());
	}
	
	@Test
	void equals_e_hash_code_quantidade_combustivel_diferente() {
		var veiculo1 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto1 = new PrevisaoGasto(veiculo1, BigDecimal.ONE, BigDecimal.TEN);
		
		var veiculo2 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto2 = new PrevisaoGasto(veiculo2, BigDecimal.TEN, BigDecimal.TEN);
		
		assertThat(previsaoGasto1).isNotEqualTo(previsaoGasto2);
		assertThat(previsaoGasto1.hashCode()).isNotEqualByComparingTo(previsaoGasto2.hashCode());
	}
	
	@Test
	void equals_e_hash_code_valor_gasto_diferente() {
		var veiculo1 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto1 = new PrevisaoGasto(veiculo1, BigDecimal.ONE, BigDecimal.TEN);
		
		var veiculo2 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto2 = new PrevisaoGasto(veiculo2, BigDecimal.ONE, BigDecimal.ONE);
		
		assertThat(previsaoGasto1).isNotEqualTo(previsaoGasto2);
		assertThat(previsaoGasto1.hashCode()).isNotEqualByComparingTo(previsaoGasto2.hashCode());
	}
	
	@Test
	void equals_e_hash_code_tudo_diferente() {
		var veiculo1 = new VeiculoFakeBuilder().padrao().setId(1L).novoVeiculo();
		var previsaoGasto1 = new PrevisaoGasto(veiculo1, BigDecimal.ONE, BigDecimal.TEN);
		
		var veiculo2 = new VeiculoFakeBuilder().padrao().setId(2L).novoVeiculo();
		var previsaoGasto2 = new PrevisaoGasto(veiculo2, BigDecimal.TEN, BigDecimal.ONE);
		
		assertThat(previsaoGasto1).isNotEqualTo(previsaoGasto2);
		assertThat(previsaoGasto1.hashCode()).isNotEqualByComparingTo(previsaoGasto2.hashCode());
	}

}

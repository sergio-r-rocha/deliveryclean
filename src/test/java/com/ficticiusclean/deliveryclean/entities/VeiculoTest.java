package com.ficticiusclean.deliveryclean.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ficticiusclean.deliveryclean.business.veiculo.VeiculoFakeBuilder;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.AtualizaVeiculoDto;
import com.ficticiusclean.deliveryclean.web.dto.veiculo.CadastroVeiculoDto;

class VeiculoTest {
	
	private VeiculoFakeBuilder veiculoFakeBuilder;
	
	@BeforeEach
	public void setup() {
		veiculoFakeBuilder = new VeiculoFakeBuilder();
	}

	@Test
	void cadastro_veiculo_dto_converter_veiculo() {
		var cadastroVeiculoDto = new CadastroVeiculoDto("nome", "marca", "modelo", LocalDate.now(), new BigDecimal("12"), new BigDecimal("16"));
		var veiculo = new Veiculo(cadastroVeiculoDto);
		assertThat(veiculo.getNome()).isEqualTo(cadastroVeiculoDto.nome());
		assertThat(veiculo.getMarca()).isEqualTo(cadastroVeiculoDto.marca());
		assertThat(veiculo.getModelo()).isEqualTo(cadastroVeiculoDto.modelo());
		assertThat(veiculo.getDataFabricacao()).isEqualTo(cadastroVeiculoDto.dataFabricacao());
		assertThat(veiculo.getConsumoCidade()).isEqualTo(cadastroVeiculoDto.consumoCidade());
		assertThat(veiculo.getConsumoRodovias()).isEqualTo(cadastroVeiculoDto.consumoRodovias());
	}
	
	@Test
	void atualiza_veiculo_dto_converter_veiculo() {
		var atualizaVeiculoDto = new AtualizaVeiculoDto(1L, "nome", "marca", "modelo", LocalDate.now(), new BigDecimal("12"), new BigDecimal("16"));
		var veiculo = new Veiculo(atualizaVeiculoDto);
		assertThat(veiculo.getId()).isEqualTo(atualizaVeiculoDto.id());
		assertThat(veiculo.getNome()).isEqualTo(atualizaVeiculoDto.nome());
		assertThat(veiculo.getMarca()).isEqualTo(atualizaVeiculoDto.marca());
		assertThat(veiculo.getModelo()).isEqualTo(atualizaVeiculoDto.modelo());
		assertThat(veiculo.getDataFabricacao()).isEqualTo(atualizaVeiculoDto.dataFabricacao());
		assertThat(veiculo.getConsumoCidade()).isEqualTo(atualizaVeiculoDto.consumoCidade());
		assertThat(veiculo.getConsumoRodovias()).isEqualTo(atualizaVeiculoDto.consumoRodovias());
	}
	
	@Test
	void excluir() {
		var veiculo = new Veiculo();
		assertThat(veiculo.isExcluido()).isEqualTo(false);
		veiculo.excluir();
		assertThat(veiculo.isExcluido()).isEqualTo(true);
	}
	
	@Test
	void equals_and_hash_code() {
		Veiculo veiculo1 = veiculoFakeBuilder.setId(1L).novoVeiculo();
		Veiculo veiculo2 = veiculoFakeBuilder.setId(1L).novoVeiculo();
		Veiculo veiculo3 = veiculoFakeBuilder.setId(3L).novoVeiculo();
		assertThat(veiculo1).isEqualTo(veiculo2);
		assertThat(veiculo1).isNotEqualTo(veiculo3);
		assertThat(veiculo1.hashCode()).isEqualByComparingTo(veiculo2.hashCode());
		assertThat(veiculo1.hashCode()).isNotEqualByComparingTo(veiculo3.hashCode());
	}

}

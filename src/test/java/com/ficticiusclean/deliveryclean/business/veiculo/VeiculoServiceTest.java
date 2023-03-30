package com.ficticiusclean.deliveryclean.business.veiculo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

@SpringBootTest
@TestPropertySource(properties = { "delivery.clean.soft-delete=false" })
class VeiculoServiceTest {
	
	@Autowired
	private VeiculoService service;
	
	private VeiculoFakeBuilder veiculoFakeBuilder;
	
	@Mock
	private Pageable pageable;
	
	@BeforeEach
	public void setup() {
		veiculoFakeBuilder = new VeiculoFakeBuilder();
	}

	@Test
	void cadastrar_dados_ok() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculo);
		assertThat(veiculoSalvo.getId()).isNotNull();
	}
	
	@Test
	void cadastrar_nome_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().nomeNulo().novoVeiculo();
		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_marca_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().marcaNulo().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_modelo_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().modeloNulo().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_nome_em_branco() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().nomeEmBranco().novoVeiculo();
		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_marca_em_branco() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().marcaEmBranco().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_modelo_em_branco() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().modeloEmBranco().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_data_fabricacao_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().dataFabricacaoNulo().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_consumo_cidade_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().consumoCidadeNulo().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void cadastrar_consumo_rodovias_nulo() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().consumoRodoviasNulo().novoVeiculo();

		assertThrows(Exception.class, () -> service.cadastrar(veiculo));
	}
	
	@Test
	void atualizar_dados_ok() {
		Veiculo veiculo = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculo);
		
		String nomeAlterado = "Veiculo " + UUID.randomUUID().toString();
		Veiculo veiculoAlterado = service.atualizar(new Veiculo(veiculoSalvo.getId(), nomeAlterado, veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido()));
		
		assertThat(veiculoSalvo.getNome()).isNotEqualTo(veiculoAlterado.getNome());
	}
	
	@Test
	void atualizar_nome_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String nome = null;
		
		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), nome, veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_marca_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String marca = null;

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), marca,
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_modelo_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String modelo = null;

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), veiculoSalvo.getMarca(),
				modelo, veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_nome_em_branco() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String nome = "";
		
		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), nome, veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_marca_em_branco() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String marca = "";

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), marca,
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_modelo_em_branco() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		String modelo = "";

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), veiculoSalvo.getMarca(),
				modelo, veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_data_fabricacao_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		LocalDate dataFabricacao = null;

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), dataFabricacao, veiculoSalvo.getConsumoCidade(),
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_consumo_cidade_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		BigDecimal consumoCidade = null;

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), consumoCidade,
				veiculoSalvo.getConsumoRodovias(), veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void atualizar_consumo_rodovias_nulo() {
		Veiculo veiculoCompleto = veiculoFakeBuilder.padrao().novoVeiculo();
		Veiculo veiculoSalvo = service.cadastrar(veiculoCompleto);
		
		BigDecimal consumoRodovias = null;

		Veiculo veiculoAlterado = new Veiculo(veiculoSalvo.getId(), veiculoSalvo.getNome(), veiculoSalvo.getMarca(),
				veiculoSalvo.getModelo(), veiculoSalvo.getDataFabricacao(), veiculoSalvo.getConsumoCidade(),
				consumoRodovias, veiculoSalvo.isExcluido());
		assertThrows(Exception.class, () -> service.atualizar(veiculoAlterado));
	}
	
	@Test
	void excluir() {
		Long id = 1L;
		Veiculo veiculo = service.buscarPorId(id);
		assertNotNull(veiculo);
		service.excluir(id);
		veiculo = service.buscarPorId(id);
		assertNull(service.buscarPorId(id));
	}

}

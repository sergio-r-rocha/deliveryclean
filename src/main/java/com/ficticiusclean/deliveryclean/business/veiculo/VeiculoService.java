package com.ficticiusclean.deliveryclean.business.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficticiusclean.deliveryclean.entities.Veiculo;
import com.ficticiusclean.deliveryclean.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Value("${delivery.clean.soft-delete}")
	private String softDelete;
	
	public Page<Veiculo> listar(Pageable pageable) {
		return veiculoRepository.findAllByExcluidoFalse(pageable);
	}

	@Transactional
	public Veiculo cadastrar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public Veiculo atualizar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Transactional
	public void excluir(Long id) {
		if (softDelete != null && softDelete.equalsIgnoreCase("true")) {
			Veiculo veiculo = veiculoRepository.getReferenceById(id);
			veiculo.excluir();
		} else {
			veiculoRepository.deleteById(id);
		}
	}
	
	public Veiculo buscarPorId(Long id) {
		return veiculoRepository.findById(id).orElse(null);
	}

}

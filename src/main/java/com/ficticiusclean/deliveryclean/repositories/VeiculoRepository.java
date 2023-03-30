package com.ficticiusclean.deliveryclean.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ficticiusclean.deliveryclean.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Page<Veiculo> findAllByExcluidoFalse(Pageable pageable);

}

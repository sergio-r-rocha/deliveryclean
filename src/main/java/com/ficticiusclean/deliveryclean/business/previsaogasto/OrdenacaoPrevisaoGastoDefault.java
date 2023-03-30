package com.ficticiusclean.deliveryclean.business.previsaogasto;

import java.util.List;

public abstract class OrdenacaoPrevisaoGastoDefault implements OrdenacaoPrevisaoGasto {

	@Override
	public void executar(List<PrevisaoGasto> list) {
		if (list != null) {
			doSort(list);
		}
	}

	protected abstract void doSort(List<PrevisaoGasto> list);

}

package com.nelioalves.mc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.PagamentoComBoleto;

/**
 * Classe de serviço responsável por preencher as informações de pagamento com boleto
 * 
 * @author Adriano Rocha
 * @since 17/11/2019
 *
 */
@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}

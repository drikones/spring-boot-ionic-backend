package com.nelioalves.mc.domain.enuns;

/**
 * Enum que identifica se cliente irá possuir CPF ou CNPJ
 * 
 * @author Adriano Rocha
 * @since 27/07/2019
 */
public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) 
		{
			return null;
		}
		for(TipoCliente tipoCliente : TipoCliente.values()) 
		{
			if(cod.equals(tipoCliente.getCod()))
			{
				return tipoCliente;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}

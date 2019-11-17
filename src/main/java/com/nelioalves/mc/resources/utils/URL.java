package com.nelioalves.mc.resources.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe utilitária para quebrar a lista de categorias informadas na requisição de produtos
 * e fazer o encoding do nome do produto
 * 
 * @author Adriano Rocha
 * @since  16/11/2019
 */
public class URL {
	
	/**
	 * Faz o encoding do nome do produto
	 * @param nome
	 * @return
	 */
	public static String encodingParam(String nome) {
		try {
			return URLDecoder.decode(nome, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	/**
	 * Quebra a lista de categorias informadas na requisição de produtos em um array de inteiros
	 * @param s
	 * @return
	 */
	public static List<Integer> decodeIntList(String s){
		try {
			if(s.contains(","))
			{
				return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
			}
			else {
				List<Integer> argument = new ArrayList<>();
				argument.add(Integer.parseInt(s));
				return argument;
			}
		} catch (NumberFormatException e) {
			return null;
		}
	}
}

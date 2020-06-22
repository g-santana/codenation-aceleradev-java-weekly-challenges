package br.com.codenation.desafioexe;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	private DesafioApplication() {}

	public static List<Integer> fibonacci() {
		List<Integer> sequenciaFibonacci = new ArrayList<>(asList(0));
		int termoAnterior;
		int parada = 350;
		
		for (int termoAtual = 1; termoAtual <= parada; termoAtual += termoAnterior) {
			sequenciaFibonacci.add(termoAtual);
			termoAnterior = sequenciaFibonacci.get(sequenciaFibonacci.size() - 2);
		}
		
		sequenciaFibonacci.add(sequenciaFibonacci.get(sequenciaFibonacci.size() - 2)
				+ sequenciaFibonacci.get(sequenciaFibonacci.size() - 1));
		
		return sequenciaFibonacci;
	}

	public static Boolean isFibonacci(Integer numero) {
		return fibonacci().contains(numero);
	}
}
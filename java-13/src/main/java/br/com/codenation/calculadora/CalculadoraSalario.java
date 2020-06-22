package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBruto) {
		if (salarioBruto < 1039.00)
			return Math.round(0.0);
		return Math.round(
				salarioBruto - descontoINSS(salarioBruto) - descontoIRRF(salarioBruto - descontoINSS(salarioBruto)));
	}

	private double descontoINSS(double salarioBruto) {
		if (salarioBruto < 1500.01) {
			return salarioBruto * 0.08;
		} else if (salarioBruto < 4000.01) {
			return salarioBruto * 0.09;
		}
		return salarioBruto * 0.11;
	}

	private double descontoIRRF(double salarioDescontadoINSS) {
		if (salarioDescontadoINSS < 3000.01) {
			return 0;
		} else if (salarioDescontadoINSS < 6000.01) {
			return salarioDescontadoINSS * 0.075;
		}
		return salarioDescontadoINSS * 0.15;
	}
}

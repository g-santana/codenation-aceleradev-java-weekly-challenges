package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {

	private static final int SALTO = 3;
	private static final int ASCII_LOWER_A = (int) 'a';
	private static final int ASCII_LOWER_Z = (int) 'z';
	private static final int TAMANHO_ALFABETO = 26;

	@Override
	public String criptografar(String texto) {
		validaTexto(texto);
		return transformaTexto(texto, SALTO);
	}

	@Override
	public String descriptografar(String texto) {
		validaTexto(texto);
		return transformaTexto(texto, -SALTO);
	}
	
	private void validaTexto(String texto) {
		if(texto.isEmpty())
			throw new IllegalArgumentException("A string informada não pode estar vazia.");
	}
	
	private String transformaTexto(String texto, int salto) {
		char[] stringQuebrada = texto.toLowerCase().toCharArray();
		List<Character> codigosAscii = new ArrayList<>();

		for (char caracter : stringQuebrada) {
			int num = (int) caracter;

			if (Character.isLetter(caracter)) {
				if (num + salto > ASCII_LOWER_Z) {
					codigosAscii.add((char) (num + salto - TAMANHO_ALFABETO));
				} else if(num + salto < ASCII_LOWER_A) {
					codigosAscii.add((char) (num + salto + TAMANHO_ALFABETO));
				} else {
					codigosAscii.add((char) (num + salto));
				}
			} else {
				codigosAscii.add((char) (num));
			}
		}

		return codigosAscii.stream().map(String::valueOf).collect(Collectors.joining());
	}
}

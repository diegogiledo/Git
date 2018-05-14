package Control;

public class ComprobarDni {

	public static boolean DNICorrecto(String dni) {
		String letra = "";
		String num = "";
		boolean esCorrecto = false;
		long numeros = 0;
		String[] aux = dni.split("");
		if (dni.length() == 9) {
			for (int j = 0; j < dni.length() - 1; j++) {
				if (Character.isDigit(aux[j].charAt(0))) {
					// System.out.println("Caracter" + j + " " + aux[j].charAt(0));
					num += aux[j];
				} else {
					return esCorrecto;
				}
			}
			if (!Character.isDigit(aux[8].charAt(0))) {
				letra = aux[8].toUpperCase();
				// System.out.println("Letra " + letra);
			} else {
				return esCorrecto;
			}
			// System.out.println("Longitud: " + num.length());
			if (num.length() == 8) {
				numeros = Long.parseLong(num);
				// System.out.println("Numeros: " + numeros);
				char caracter = letra.charAt(0);
				char letraDNI = LETRAS_DNI[(int) (numeros % 23)];
				if (caracter == letraDNI) {
					esCorrecto = true;
				}

			} else {
				return esCorrecto;
			}
		}

		return esCorrecto;
	}

	private static final char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
			'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T' };

}

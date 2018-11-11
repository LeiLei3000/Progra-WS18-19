package programmierungMitArrays;

public class Transponieren {

	public static void main(String[] args) {
		int zeilen = groesseEinlesen("Zeilen");
		int spalten = groesseEinlesen("Spalten");
		matrixTransponieren(spalten, zeilen);
	}

	public static void matrixTransponieren(int spalten, int zeilen) {
		int[][] matrix = new int[zeilen][spalten];
		int[][] transMatrix = new int[spalten][zeilen];
		
		// Eine Matrix beliebiger Groessee (mindestens 1 × 1) vom Benutzer einliest
		for (int j = 0; j < spalten; j++) {
			for (int i = 0; i < zeilen; i++) {
				matrix[i][j] = SimpleIO.getInt("Wie lautet die Zahl fuer Position (" + (i + 1) + ", " + (j + 1) + ")?");
			}
		}
		
		// Die Matrix transponieren
		for (int j = 0; j < spalten; j++) {
			for (int i = 0; i < zeilen; i++) {
				transMatrix[j][i] = matrix[i][j];
			}
		}
		
		// Die Matrix sowie die transponierte Matrix in geeigneter Form ausgeben
		System.out.println(" Matrix:\n" + matrixToString(matrix));
		System.out.println("\n Transponierte Matrix:\n" + matrixToString(transMatrix));
	}
	
	static String matrixToString(int[][] matrix) {
		String result = "";
		for(int[] zeile : matrix) {
			for (int zelle : zeile)
				result += zelle + " ";
			result += "\n";
		}
		return result;
	}

	static int groesseEinlesen(String bezeichnung) {
		int result;
		do {
			result = SimpleIO.getInt("Wie viele " + bezeichnung + " hat die Matrix? (>= 1)");
		} while (result < 1);
		return result;
	}
}

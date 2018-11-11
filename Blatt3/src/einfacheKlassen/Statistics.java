package einfacheKlassen;

public class Statistics {
	
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		statistics.addValue(2);
		statistics.addValue(105);
		statistics.addValue(-366);
		statistics.addValue(44);
		statistics.addValue(11);
		SimpleIO.output("Minimum: " + statistics.getMinimum());
		SimpleIO.output("Maximum: " + statistics.getMaximum());
		SimpleIO.output("Durchschnitt: " + statistics.getAverage());
	}

	int [] werte = new int [100];
	int laenge = 0;
	
	public void addValue(int value) {
		if (laenge == 100) {
			SimpleIO.output("Fehler: es sind schon 100 Elemente hinzugefuegt worden");
		}
		else {
			werte[laenge] = value;
			laenge++;
		}
	}

	public int getMinimum() {
		int result = werte[0];
		if (laenge == 0) {
			SimpleIO.output("Fehler : keine Daten");
			return 0;
		}
		for (int i = 0; i < laenge; i++) {
			if (result > werte[i]) {
				result = werte[i];
			}
		}
		return result;
	}

	public int getMaximum() {
		int result = werte[0];
		if (laenge == 0) {
			SimpleIO.output("Fehler : keine Daten");
			return 0;
		}
		for (int i = 0; i < laenge; i++) {
			if (result < werte[i]) {
				result = werte[i];
			}
		}
		return result;
	}

	public double getAverage() {
		if (laenge == 0) {
			SimpleIO.output("Fehler : keine Daten");
			return 0;
		}
		double result = 0;
		for(int i = 0; i < laenge; i++) {
			result += werte[i];
		}
		return result/laenge;
	}
	
}
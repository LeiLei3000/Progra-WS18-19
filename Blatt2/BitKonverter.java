
public class BitKonverter {
	
//Hilfsmethoden
	
	// Welches Verfahren moechte der User nutzen?
	public static String verfahren () {
		String Input = "";
		do {
			Input = SimpleIO.getString("Bitte waehlen Sie aus: \nDecimal: Dezimalzahl ins Zweierkomplement konvertieren. \nBinary: 8-bit-Zweierkomplement als Dezimalzahl darstellen.");
		} while(!Input.equals("Decimal") && !Input.equals("Binary"));
		return Input;
	}
	
	// Vertausche alle 0en und 1en
	public static String vertausche(String s) {
		String VertauschteBits = "";
		for(int i = 0; i < 8; i++) {
			if(s.charAt(i)=='1') {
				VertauschteBits = VertauschteBits + '0';
			} else {
				VertauschteBits = VertauschteBits + '1';
			}
		}
		return VertauschteBits;
	}
	
	// Addiere 1 zu den String
	public static String plusEins(String s) {
		String PlusEins = "";
		for(int i = 7; i >= 0; i--) {
			if(s.charAt(i) == '1') {
				PlusEins = '0' + PlusEins;
				continue;
			}
			PlusEins = '1' + PlusEins;
			for(int j = i-1; j >= 0; j--) {
				PlusEins = s.charAt(j)+ PlusEins;
			}
			break;
		}
		return PlusEins;		
	}
	
	//Welche Zahl ist im String
	public static int nullOderEins(char a) {
		int x = a == '1'? 1 : 0;
		return x;
	}

//Main Programm
	
	public static void main(String[] args) {
		
		
		String Input = verfahren();
		
		int dezimalzahl=0, dividend, rest;
		String Bitzahl = "";
		boolean positiv = true;
		
		//Dezimalzahl in eine 8-bit-Zahl umwandeln
		if(Input.equals("Decimal")) {
			do {
				dezimalzahl = SimpleIO.getInt("Bitte geben Sie eine Zahl zwischen -128 und 127 ein");
			} while(dezimalzahl < -128 || dezimalzahl >127);
			
			dividend = dezimalzahl;
			dividend = dividend > 0 ? dividend : -dividend;
			
			for(int i = 0; i < 8; i++) {
				rest = dividend % 2;
				dividend = dividend/2;
				Bitzahl = rest + Bitzahl;
			}
			if(dezimalzahl < 0) {
				Bitzahl = vertausche(Bitzahl);
				Bitzahl = plusEins(Bitzahl);
			}
			
			SimpleIO.output("Ihre Dezimalzahl im Zweierkomplement dargestellt ist " + Bitzahl);
			return;
			
			
		} else {
			//8-bit zu Dezimalzahl umwandeln
			do {
				Bitzahl = SimpleIO.getString("Geben Sie Eine 8-Bit-Zahl ein");
			} while(Bitzahl.length() != 8);
			
			//Ueberpruefe auf Korrektheit
			for(int i = 0; i < 8; i++) {
				if(Bitzahl.charAt(i) != '0' && Bitzahl.charAt(i) != '1') {
					SimpleIO.output("Fehler: Das war keine Binaerzahl");
					return;
				}
			}
			
			//falls Zahl negativ
			if(Bitzahl.charAt(0) == '1') {
				Bitzahl = vertausche(Bitzahl);
				Bitzahl = plusEins(Bitzahl);
				positiv = false;
			}
			
			for(int i = 0; i < 8; i++) {
				dezimalzahl = (int) (dezimalzahl + Math.pow(2, i) *  nullOderEins(Bitzahl.charAt(7-i)));
			}
			
			if(positiv) {
				SimpleIO.output("Ihr 8 - Bit - Zweierkomplement entspricht der Dezimalzahl " + dezimalzahl);
				return;
			}
			
			SimpleIO.output("Ihr 8 - Bit - Zweierkomplement entspricht der Dezimalzahl " + -dezimalzahl);
			return;
		}
		
	}

}

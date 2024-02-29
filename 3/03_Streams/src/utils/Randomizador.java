package utils;

import java.util.ArrayList;
import java.util.List;

public class Randomizador {
	
	private ArrayList<String> nombres = new ArrayList<String>();	
	
	public Randomizador() {
		super();
		nombres.add("Pepe");
		nombres.add("Mariela");
		nombres.add("Gabriel");
		nombres.add("Noelia");
		nombres.add("Jorge");
		nombres.add("Mirta");
		nombres.add("Andres");
		nombres.add("Miguel");
		nombres.add("Mirta");
		nombres.add("Martin");
		nombres.add("Ana");
		nombres.add("Elias");
		nombres.add("Rosa");
		
		List<String> listaCopia = new ArrayList<String>(nombres);
		
		for (String string : listaCopia) {
			nombres.add(string.toLowerCase());
		}
	}



	public String getNombre() {
		int pos = (int) ( Math.random() * nombres.size());
		
		return nombres.get(pos);
	}

	public int getInt(int min, int max) {
		return min + (int) (Math.random() * (max-min));
	}

	public double getDouble(int min, int max) {
		return getInt(min*100, max*100) / 100.0;
	}
	
}

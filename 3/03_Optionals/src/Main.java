import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
	
	
	public static void main(String[] args) {
		
		
		List<String> lista = new ArrayList<String>();
		
		Optional<String> optPalabra = Optional.ofNullable(obtenerString());
		
		if(!optPalabra.isPresent()) {
			return;
		}
		
		String palabra = optPalabra.orElse("");
		
		lista.add(palabra);
		
		System.out.println("El texto es: "+lista.get(0).toUpperCase());
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static String obtenerString() {
		return null;
	}

}

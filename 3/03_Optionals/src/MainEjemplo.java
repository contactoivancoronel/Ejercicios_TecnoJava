import java.util.Optional;

public class MainEjemplo {
	
	public static Optional<String> getNombreByDNI(int dni){
		return Optional.ofNullable(null);
	}
	
	

	public static void main(String[] args) {
		
//		String s = null;
//		
//		Optional<String> oString = Optional.ofNullable(s);
//		
//		
//		String nombre = (s==null) ? s : "";
//		
//		System.out.println(nombre.toUpperCase());
		
		Optional<String> oString = getNombreByDNI(123);
		String nombre;
		
		if(oString.isPresent()) {
			nombre = oString.get();
		}else {
			System.out.println("No se encontró el dni");
		}
		
		oString.ifPresentOrElse(
				(s)->System.out.println("Existe") 
				, ()-> System.out.println("No Existe") 
		);
		
		oString.orElseThrow(  ()-> new ExceptionInInitializerError("No existe")  );
		
	}

}

package interfaces;

@FunctionalInterface
public interface Mostrable {


	public void mostrar();
	
	public default void mostrarDosVeces() {
		this.mostrar();
		this.mostrar();
	}
	
}

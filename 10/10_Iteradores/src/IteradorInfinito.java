import java.util.Iterator;

public class IteradorInfinito implements Iterator<Integer>{

	private int ultimoNumero = 0;
	private int maximo;
	
	
	
	public IteradorInfinito(int maximo) {
		super();
		this.maximo = maximo;
	}

	@Override
	public boolean hasNext() {
		return ultimoNumero < maximo;
	}

	@Override
	public Integer next() {
		ultimoNumero += 1;
		return ultimoNumero;
	}

}

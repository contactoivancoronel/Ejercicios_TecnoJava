import java.io.DataInputStream;
import java.io.IOException;

public class HioLectura extends Thread {

	private DataInputStream dis;

	public HioLectura(DataInputStream dis) {
		super();
		this.dis = dis;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String respuesta;
				respuesta = dis.readUTF();
				System.out.println("El cliente envio: " + respuesta);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

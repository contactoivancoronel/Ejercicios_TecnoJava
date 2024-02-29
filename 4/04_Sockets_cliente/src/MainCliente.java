import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Soy el que se quiere conectar");
		try {
			// Me conecto
			Socket s = new Socket("192.168.0.34", 3493);
			// Extraigo la herramienta de entrada de datos
			InputStream inputSocket = s.getInputStream();

			// Extraigo la herramienta de salida de datos
			OutputStream outputSocket = s.getOutputStream();
			

			DataOutputStream dos = new DataOutputStream(outputSocket);
			DataInputStream dis = new DataInputStream(inputSocket);


			Thread hilo = new HioLectura(dis);
			hilo.start();
			
			while (true) {
				String texto = sc.nextLine();
				dos.writeUTF(texto);

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("fin del progrma");

	}

}

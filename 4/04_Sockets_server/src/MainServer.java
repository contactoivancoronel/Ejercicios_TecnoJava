import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Creo el server");
			ServerSocket ss = new ServerSocket(3493);
			System.out.println("Espero a alguien...");
			Socket s = ss.accept();
			System.out.println("Alguien se conectó...");

			OutputStream outputSocket = s.getOutputStream();
			InputStream inputSocket = s.getInputStream();
			
			DataOutputStream dos = new DataOutputStream(outputSocket);
			DataInputStream dis = new DataInputStream(inputSocket);
			
			Thread hilo = new HioLectura(dis);
			hilo.start();


			while (true) {
				dos.writeUTF(sc.nextLine());

				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Fin del programa");
	}

}

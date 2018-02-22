package distributed.nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver implements Runnable {
	
	private Socket client;

	public Receiver(Socket client) {
		this.client = client;
	}

	public void run() {
		String line;
		BufferedReader in = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			line = in.readLine();

			System.out.println(line);
			// send data back to the client
			String line2 = "Hello From Server";
			out.println(line2);
			System.out.println("Message sent to client at: " + client.getPort());
			line = in.readLine();


		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

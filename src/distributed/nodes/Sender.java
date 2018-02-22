package distributed.nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Sender {
	private int[] portArray;
	
	public Sender(int[] ports) {
		//System.out.println("Inside Sender");
		this.portArray = Arrays.copyOfRange(ports, 0, ports.length);
		//this.port = port;
	}
	
	public void sendMessage() {
		boolean scanning = true;
		String message;
		BufferedReader reader = null;
		PrintWriter writer = null;
		for(int port:portArray) {
			while(scanning){
				try	{
					System.out.println("Trying");
					// Create a client socket and connect to server at 127.0.0.1 port 5000
					Socket clientSocket = new Socket("localhost",port);
					scanning = false;
					/* Create BufferedReader to read messages from server. Input stream is in bytes. 
						They are converted to characters by InputStreamReader.
						Characters from the InputStreamReader are converted to buffered characters by BufferedReader.
						This is done for efficiency purpose.
					*/
					reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

					// PrintWriter is a bridge between character data and the socket's low-level output stream
					writer = new PrintWriter(clientSocket.getOutputStream(), true);
					
				} catch(Exception ex) {
					System.out.println("Could not connect");
					//ex.printStackTrace();
					try {
						System.out.println("Sleeping");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				writer.println("Hello from Client: "+ port);
				message = reader.readLine();
				System.out.println(message);
			} catch(IOException e) {
				System.out.println("Read failed");
				System.exit(100);
			}
		}
		
	}

}

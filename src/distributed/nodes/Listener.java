package distributed.nodes;

import java.io.IOException;
import java.net.ServerSocket;

public class Listener implements Runnable {
	private int port;
	
	public Listener(int port) {
		System.out.println("Listener port:" + port);
		this.port = port;
	}

	public void run() {
		
		try	{
		
			//Create a server socket at port 5000
			ServerSocket serverSock = new ServerSocket(port);
			System.out.println("Inside Listener");
			//Server goes into a permanent loop accepting connections from clients			
			while(true)
			{
				//Listens for a connection to be made to this socket and accepts it
				//The method blocks until a connection is made
				Receiver w;
				try {
					System.out.println("Waiting for client");
					w = new Receiver(serverSock.accept());
					Thread t = new Thread(w);
					t.start();
				} catch(IOException e) {
					System.out.println("accept failed");
					System.exit(100);
				}				
			}

		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}

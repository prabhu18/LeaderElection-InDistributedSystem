package com.utd.distributed.servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage implements Runnable {
	
	private BufferedReader in;
    private PrintWriter out;
    private String myPort;
    
    public SendMessage(int port) {
    	this.myPort = Integer.toString(port);
	}

	@Override
	public void run() {
		try {
			Socket s1 = new Socket("localhost",8586);
			System.out.println("Client: "+"Connection Established");
			in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			out = new PrintWriter(s1.getOutputStream(), true);
			out.println(myPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

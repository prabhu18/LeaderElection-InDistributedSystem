package com.utd.distributed.servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ReceiveMessage implements Runnable {
	
	private Socket socket;
	private int nodeNumber;
	private ArrayList<String> data;
	
	public ReceiveMessage(Socket socket, int nodeNumber) {
		this.socket = socket;
		this.nodeNumber = nodeNumber;
		System.out.println("New node with node number " + nodeNumber + " at socket " + socket);
	}
	
	@Override
	public void run(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.flush();
            System.out.println(in.readLine());
            data.add(in.readLine() + "@" + socket.getInetAddress().getCanonicalHostName());
            //System.out.println("Hostname: " + socket.getInetAddress().getCanonicalHostName());
            //hostnames.add(socket.getInetAddress().getCanonicalHostName());
            //out.println("Hello, you are node#" + nodeNumber + ".");
            //out.flush();
            
		} catch(Exception e) {
			System.out.println("Error handling node# " + nodeNumber + ": " + e);
		} finally {
			try {
				socket.close();
			} catch(Exception e) {
				System.out.println("Could not close socket");
			}
			System.out.println("Socket with node# " + nodeNumber +" closed");
		}
	}
	
	public ArrayList<String> getHostnames() {
		return data;
	}

}

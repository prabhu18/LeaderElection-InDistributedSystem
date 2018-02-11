package com.utd.distributed.servers;

import java.net.ServerSocket;

public class Node1 {

	public static void main(String[] args) throws Exception {
		final int port = 8545;
		int nodeNumber = 0;
		
		ServerSocket serverSocket = new ServerSocket(port);

		try{
			Thread receiveThread = new Thread(new ReceiveMessage(serverSocket.accept(), ++nodeNumber));
			receiveThread.start();
			SendMessage message = new SendMessage(port);
			Thread sendThread = new Thread(new SendMessage(port));
			sendThread.start();
			
		}
		finally {
			//serverSocket.close();
		}
		
	}

}
	

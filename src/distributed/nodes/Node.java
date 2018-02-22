package distributed.nodes;

import java.util.Arrays;

public class Node {

	public static void main(String[] args) {
		Listener listener = new Listener(Integer.parseInt(args[0]));
		Thread thread = new Thread(listener);
		thread.start();
		int n = Integer.parseInt(args[1]);
		int[] neighbors = new int[n];
		for(int i=0; i< n; i++){
			neighbors[i] = Integer.parseInt(args[i+2]);
		}
		Sender sender = new Sender(neighbors);
		sender.sendMessage();
		
	}

}


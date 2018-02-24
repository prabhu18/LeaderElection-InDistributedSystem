import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Readconfig {

	public static void main(String args[]) throws IOException
	{
		
		  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		  String node_id= br.readLine();	
		  File file = new File("C:\\users\\prabh\\Desktop\\config.txt");
		 
		  BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		  br1.readLine();
		  
		  int count = Integer.parseInt(br1.readLine());
		 
		  String st;
		  br1.readLine();
		  br1.readLine();
		  
		  HashMap<String,ArrayList<String>>HS= new HashMap<String, ArrayList<String>>();
		  while (count>0)
		  {
			st=br1.readLine();
			String[] a= st.split(" +");
			HS.put(a[1],new ArrayList<String>());
			HS.get(a[1]).add(a[2]);
			HS.get(a[1]).add(a[3]);
		    count=count-1;
		  }		
		
		  br1.readLine();
		  br1.readLine();
		  HashMap<String,ArrayList<String>> HS_neighbor=new HashMap<String,ArrayList<String>>(); 
		  
		  st=br1.readLine();
		  while(st != null)
		  {
			String[] a= st.split(" +");
			HS_neighbor.put(a[1],new ArrayList<String>());
			int i=2;
			while(i<a.length)
			{
				HS_neighbor.get(a[1]).add(a[i]);
				i=i+1;
			}
			st=br1.readLine();
		  }
		  br1.close();
		  br.close();
		  
		 System.out.println(HS.get(node_id));
		 System.out.println(HS_neighbor.get(node_id));
		  
		  
	}
			
  }
	


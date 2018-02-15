import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class User {
	
	BlockingQueue outMessages1;
	BlockingQueue outMessages2;
	
	Socket outSocket1;
	Socket outSocket2;
	
	Socket inSocket1;
	Socket inSocket2;
	
	HashSet receivedMessages;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		

	}
	
	public void run(){
		this.outMessages1 = new ArrayBlockingQueue(1024);
		this.outMessages2 = new ArrayBlockingQueue(1024);
		
		this.outSocket1 = new Socket();
		this.outSocket2 = new Socket();
		
		this.inSocket1 = new Socket();
		this.inSocket2 = new Socket();
		
		this.receivedMessages = new HashSet();
	}
	
	
	private class Sender{
		
	}
	
	private class Receiver{
		
	}

}

package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4.member;

public class Simulation implements Runnable {
	
	private Strecke strecke;
	private Zug[] zuege;
	private Object printLock;
	private boolean running = true;

	public static void main(String [] args){

		Strecke strecke = new Strecke(70);
		
		Block[] blocks = new Block[8];
		
		blocks[0] = new Block(10, 0);
        blocks[1] = new Block(5, 10);
        blocks[2] = new Block(10, 15);
        blocks[3] = new Block(10, 25);
        blocks[4] = new Block(15, 35);
        blocks[5] = new Block(10, 50);
        blocks[6] = new Block(5, 60);
        blocks[7] = new Block(5, 65);
		
		for(int i = 0; i < blocks.length; i++){
			strecke.addBlock(blocks[i]);
		}
		
		Zug[] zuege = new Zug[5];
		
		Object printLock = new Object();
		
		zuege[0] = new Zug(6,'A',5,strecke,printLock);
		zuege[1] = new Zug(11,'B',15,strecke,printLock);
		zuege[2] = new Zug(20,'C',5,strecke,printLock);
		zuege[3] = new Zug(30,'D',10,strecke,printLock);
		zuege[4] = new Zug(45,'E',6,strecke,printLock);
        
        
		Simulation sim = new Simulation(strecke,zuege,printLock);
		
		Thread t = new Thread(sim);
		t.start();
	}
	
	public Simulation(Strecke strecke, Zug[] zuege,Object printLock){
		this.strecke = strecke;
		this.zuege = zuege;
		this.printLock = printLock;
	}

	@Override
	public void run() {
		
		Thread [] threads = new Thread[zuege.length]; 
		
		for(int i = 0; i< zuege.length; i++){
			threads[i] = new Thread(zuege[i]);
		}
		
		for(int i = 0; i < threads.length; i++){
			threads[i].start();
		}
		
		while(running){
			
			
			System.err.println(addZuege());
			
	
			synchronized(printLock){
				try {
					printLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	private String addZuege(){
		String s = strecke.getString();
		int count = 0;
		for(Zug zug : zuege){
			s = s.substring(0,zug.getPosition()+count+1) + zug.getName() + s.substring(zug.getPosition()+count+1);
			count++;
		}
		
		return s;
		
	}
	
	
}

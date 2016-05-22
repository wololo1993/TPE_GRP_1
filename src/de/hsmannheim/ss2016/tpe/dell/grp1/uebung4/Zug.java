package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4.member;

public class Zug implements Runnable {
	private boolean running = true;
	private int geschwindigkeit;
	private char name;
	private int position;
	private Object printLock;
	
	private Strecke strecke;	
	
	public Zug( int position, char name,int geschwindigkeit, Strecke strecke, Object printLock) {
		this.geschwindigkeit = geschwindigkeit;
		this.name = name;
		this.position = position;
		this.strecke = strecke;
		this.printLock = printLock;
	}


	@Override
	public void run() {

		while(running){
		int count = geschwindigkeit;
			
			while(count > 0 && running){
				
				Block block = strecke.array[position];
				Block nextBlock;
				if(position >= strecke.length-1){
					nextBlock = null;
				} else {
				 nextBlock = strecke.array[position + 1];
				}

				if(nextBlock != null && nextBlock.getStart() == position+1 && nextBlock.isLocked()){
					synchronized (nextBlock) {
						try {
							System.out.println(this.name + " Warte auf Block at Pos"+this.position);
							nextBlock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if(block != null){
					if(block.getEnd() == position){
						System.out.println(this.name + " Leaving Block at Pos:"+this.position);
						block.unlock();
					}
					if(block.getStart() == position){
						System.out.println(this.name + " Entering Block at Pos"+this.position);
						block.lock();
					}
				}
				
				count--;
				
				
				synchronized (printLock){
					System.out.println("Zug:"+this.name+ " Wants pos print Pos:"+this.position);
					printLock.notify();
				}
				
				
				position++;
				
				try {
					Thread.sleep((1000/geschwindigkeit));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				if(this.position >= strecke.length-1){
					running = false;
				}
			}
			
			
			
		}

		System.out.println(this.name + "Finished");

		
		}
	
	public int getPosition(){
		return position;
	}
	public char getName(){
		return name;
	}


}

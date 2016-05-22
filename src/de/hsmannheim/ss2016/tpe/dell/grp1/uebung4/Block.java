package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4.member;

public class Block {

	private boolean locked;
	private int start;
	private int end;

	public Block( int length, int start) {
		this.start = start;
		this.end = start + length-1;
	}

	public boolean isLocked() {
		return locked;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public void unlock() {
		System.out.println("Block "+this.getStart()+" unlocked");
		synchronized(this){
			notify();
		}
		locked = false;
	}

	public synchronized void lock() {
		System.out.println("Block "+this.getStart()+" locked");
		locked = true;
	}

}

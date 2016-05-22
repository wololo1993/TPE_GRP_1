package de.hsmannheim.ss2016.tpe.dell.grp1.uebung4.member;

public class Strecke {

	int length;
	Block[] array;
	private int blocksLength = 0;

	String strecke = "";

	public Strecke(int length) {
		this.length = length;
		array = new Block[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

	public void addBlock(Block block) {

		array[block.getStart()] = block;
		array[block.getEnd()] = block;

	}

	public void initiallizeStrecke() {
		updateString();
	}

	public void updateString() {
		String s = "";
		for (int i = 0; i < length; i++) {
			if (array[i] != null) {
				if (array[i].getStart() == i) {
					if (array[i].isLocked()) {
						s += "|";
					} else {
						s += "_";
					}
				} else {
					s += "-";
				}
			} else {
				s += "-";
			}

		}
		strecke = s;
	}

	public String getString() {
		updateString();
		return strecke;
	}

}

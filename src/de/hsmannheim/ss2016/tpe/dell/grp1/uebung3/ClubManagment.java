package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3;

public class ClubManagment {

	public static void main(String args[]) {

		MembershipList<Integer, Member> List = new MembershipList();
		
		List.put(new Member(2, 16, "Musterman", "Heinz"));
		List.put(new Member(6, 15, "Koch", "Anni"));
		List.put(new Member(5,  9, "Simpson", "Bart"));
		List.put(new Member(4,  5, "Simpson", "Lisa"));
		
		System.out.println("Länge Vereinsliste: " + List.size());
		
		List.forEach((k, v) -> System.out.println(k));
		
		List.remove(1);
		
	}
}

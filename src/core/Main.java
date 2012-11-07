package core;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) { // Aboubakrine:22376329643 samba:
												// 2152075399 8327901605
		RunOffVote r = new RunOffVote("run_off.txt");

		for (int i = 0; i < r.Candidats.size() - 1; i++) {

			System.out.println("----------------------Round " + (i + 1)
					+ "------------------------");
			r.runOff(i);
			Candidat c = r.getCandidatToEliminate();
			r.getCandidatToEliminate().isEliminated = true;
			System.out.println(r.Candidats);
			System.out.println(c.name + " " + c.vows + " Eliminated !");
		}
		
		System.out.println("********WINNER*********");
		System.out.println(r.winner());
		
		System.out.println("Total voters: " + r.voteOrder.size());

	}
}
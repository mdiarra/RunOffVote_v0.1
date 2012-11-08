package core;

public class Main {

	/**
<<<<<<< HEAD
	 * Main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		RunOffVote r = new RunOffVote("run_off.txt");

		/*
		 * Round = number of candidats -1
		 */
		for (int i = 0; i < r.Candidats.size() - 1; i++) {// start of round
=======
	 * @param args
	 */
	public static void main(String[] args) { // Aboubakrine:22376329643 samba:
												// 2152075399 8327901605
		RunOffVote r = new RunOffVote("run_off.txt");

		for (int i = 0; i < r.Candidats.size() - 1; i++) {
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283

			System.out.println("----------------------Round " + (i + 1)
					+ "------------------------");
			r.runOff(i);
<<<<<<< HEAD
			System.out.println("Total voters: " + r.numberOfVotes);
			if (r.somebodyWon())
				break; // if a candidat has more than 50
						// or if only 1 candidat is left
			Candidat c = r.getCandidatToEliminate();
			r.getCandidatToEliminate().isEliminated = true; // eleminate the
															// candidat with the
															// lowest vows
			System.out.println(r.Candidats);
			System.out.println(c.name + " " + c.vows + " Eliminated !");
		}// end of round

		System.out.println("********WINNER*********");
		System.out.println(r.winner.name + " wins with " + r.winner.vows
				+ " vows");
=======
			Candidat c = r.getCandidatToEliminate();
			r.getCandidatToEliminate().isEliminated = true;
			System.out.println(r.Candidats);
			System.out.println(c.name + " " + c.vows + " Eliminated !");
		}
		
		System.out.println("********WINNER*********");
		System.out.println(r.winner());
		
		System.out.println("Total voters: " + r.voteOrder.size());

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	}
}
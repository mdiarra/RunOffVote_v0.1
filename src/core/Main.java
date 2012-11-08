package core;

public class Main {

	/**
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

			System.out.println("----------------------Round " + (i + 1)
					+ "------------------------");
			r.runOff(i);
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
	}
}
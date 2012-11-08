package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class RunOffVote {
<<<<<<< HEAD
	
	String file; //the text file that contains all the data (candidats and voters' vote)

	private Vector<String> temp = new Vector<String>();// Contains all the lines of the text file
	Vector<Candidat> Candidats = new Vector<Candidat>(); // first line of the textFile
	Vector<Vector<Integer>> voteOrder = new Vector<Vector<Integer>>();// The rest of the textFile

	Candidat winner = new Candidat();// the vote winner
	int numberOfVotes = 0; // grows at each round
=======
	String file = "run_off.txt";

	Vector<Candidat> Candidats = new Vector<Candidat>();
	Vector<Vector<Integer>> voteOrder = new Vector<Vector<Integer>>();
	private Vector<String> temp = new Vector<String>();// Contains all the lines
														// of the text file
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283

	/**
	 * Constructor
	 * 
	 * @param file
	 */
	public RunOffVote(String file) {
		this.file = file;
		loadData();
<<<<<<< HEAD

	}

	/**
	 * This function puts all the data in the text file "run_off.txt" in the
	 * vector temp, and initialize the vector of candidats and the vector of
	 * voters
	 */
=======
		setVotePerRound();
		// runOff(5);

	}

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	public void loadData() {
		try {

			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;

			while ((line = br.readLine()) != null) {

				temp.add(line);
			}
			br.close();

			setCandidats();
			setVoteOrder();

<<<<<<< HEAD
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * This function puts the first line of the txt file "run_off.txt" in the
	 * vector "Candidats" by creating a new Candidat object for each name
	 */
=======
			// System.out.println(Candidats);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	private void setCandidats() {

		String tempCandidats = temp.firstElement() + ",";
		int i = 0;
		Candidat candidat = new Candidat();
		while (tempCandidats.length() > 0) {

<<<<<<< HEAD
			// create name = position 0 to comma
=======
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
			String name = tempCandidats
					.substring(0, tempCandidats.indexOf(","));
			candidat = new Candidat(name, i);
			i++;
<<<<<<< HEAD
			// add the new candidat in the vector "Candiats"
			Candidats.add(candidat);

			// delete the first of the vector "tempCandidats"
			tempCandidats = tempCandidats.replaceFirst(
					tempCandidats.substring(0, tempCandidats.indexOf(",") + 1),
					"");
		}

	}

	/**
	 * This function fill the vector "voteOrder" with the data in "run_off.txt"
	 * by skipping the first line, which is the name of the candidats.
	 */
	private void setVoteOrder() {
		for (int i = 1; i < temp.size(); i++) {
			// deleting the comma from the name
			String s = temp.elementAt(i).replaceAll(",", "");
			// creating a vector "tempVoteOrder" to store the preferences of
			// each voter
=======
			Candidats.add(candidat);
			tempCandidats = tempCandidats.replaceFirst(
					tempCandidats.substring(0, tempCandidats.indexOf(",") + 1),
					"");// delete the first candidat in the String
		}
		for (int j = 0; j < Candidats.size(); j++)
			Candidats.elementAt(j).setVowsPerRound(Candidats.size());// fill the
																		// vector
																		// of
																		// size
																		// "candidats
																		// by
																		// 0's
	}

	private void setVoteOrder() {
		for (int i = 1; i < temp.size(); i++) {
			String s = temp.elementAt(i).replaceAll(",", "");
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
			Vector<Integer> tempVoteOrder = new Vector<Integer>();
			for (int j = 0; j < s.length(); j++)
				tempVoteOrder.add(Integer.parseInt(Character.toString(s
						.charAt(j))));
<<<<<<< HEAD
			// add the vector "tempVoteOrder" to the vector "voteOrder"
=======
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
			voteOrder.add(tempVoteOrder);
		}
	}

<<<<<<< HEAD
	/**
	 * This function increments the vows of a candidat each time somebody votes
	 * him. Initially, every candidat's vows=0.
	 * 
	 * @param round
	 */
	public void runOff(int round) {

		for (int i = 0; i < voteOrder.size(); i++) {

			/*
			 * Depending on the round, get the number voted and take 1 from this
			 * number; because the counting start from 0 while programming, but
			 * the voters start voting according to the candidat number 1.
			 */
			int count = voteOrder.elementAt(i).elementAt(round) - 1;

			// get the candidat at the position "count" from the vector
			// Candidats
			Candidat candidat = Candidats.elementAt(count);

			// increment the vow only if the candidat is not eleminated
			if (!candidat.isEliminated) {
				int vow = candidat.getVows() + 1;
				candidat.setVows(vow);

			}

		}
		numberOfVotes += voteOrder.size();

	}

	/**
	 * This function check the vector "Candidats" and returns the candidat with
	 * the lowest vows.
	 * 
	 * @return the candidat to eleminate.
	 */
=======
	public void runOff(int round) {

		// icrement the candidat vows when somebody vote him
		for (int i = 0; i < voteOrder.size(); i++) {

			// Depending on the round, get the number voted
			int count = voteOrder.elementAt(i).elementAt(round) - 1;

			Candidat candidat = Candidats.elementAt(count);

			if (candidat.getId() == count && !candidat.isEliminated) {
				int vow = candidat.getVows() + 1;
				candidat.setVows(vow);

				// candidat.calculatePercentage(voteOrder.size());
			}

		}

	}

	public void setVotePerRound() {

		for (int round = 0; round < Candidats.size(); round++)
			for (int i = 0; i < voteOrder.size(); i++) {

				// Depending on the round, get the number voted
				int count = voteOrder.elementAt(i).elementAt(round) - 1;

				Candidat candidat = Candidats.elementAt(count);

				if (candidat.getId() == count) {
					candidat.vowsPerRound.set(round,
							candidat.vowsPerRound.get(round) + 1);
				}
			}
	}

	/**
	 * Eliminate candidat
	 */
	public void proceedElimination(Vector<Candidat> v) {

		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).vows == getCandidatToEliminate().vows
					&& !v.get(i).isEliminated)
				v.get(i).isEliminated = true;
		}
	}

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	public Candidat getCandidatToEliminate() {

		Candidat candidat = new Candidat();
		Candidat toEliminate = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			if (!Candidats.elementAt(i).isEliminated)
				toEliminate = Candidats.elementAt(i);
		}

<<<<<<< HEAD
		// Find the candidat with the lowest vow depending on the round
=======
		/**
		 * Find the candidat with the lowest vow depending on the round
		 */

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
		for (int i = 0; i < Candidats.size(); i++) {
			candidat = Candidats.elementAt(i);
			if (!candidat.isEliminated && candidat.vows < toEliminate.vows) {
				toEliminate = candidat;
			}
<<<<<<< HEAD
		}
		return toEliminate;
	}

	/**
	 * This function check if there is a winner; if a candidat has more than 50%
	 * for example or if all the other candidats are eliminated except one.
	 * 
	 * @return true if there is a winner \n\t and false if no winner yet
	 */
	public boolean somebodyWon() {
		boolean b = false;
		Candidat c = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			c = Candidats.elementAt(i);
			if (c.vows > numberOfVotes / 2) {
				winner = c;
				b = true;
			}
		}
		if (!b)
			for (int i = 0; i < Candidats.size(); i++)
				if (!Candidats.elementAt(i).isEliminated)
					this.winner = Candidats.elementAt(i);

		return b;
=======

		}
		

		return toEliminate;
	}

	public Candidat winner() {
		Candidat winner = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			if(!Candidats.elementAt(i).isEliminated)winner = Candidats.elementAt(i);
		}
		return winner;
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	}

}

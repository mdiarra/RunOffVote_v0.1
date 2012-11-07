package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class RunOffVote {
	String file = "run_off.txt";

	Vector<Candidat> Candidats = new Vector<Candidat>();
	Vector<Vector<Integer>> voteOrder = new Vector<Vector<Integer>>();
	private Vector<String> temp = new Vector<String>();// Contains all the lines
														// of the text file

	/**
	 * Constructor
	 * 
	 * @param file
	 */
	public RunOffVote(String file) {
		this.file = file;
		loadData();
		setVotePerRound();
		// runOff(5);

	}

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

			// System.out.println(Candidats);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	private void setCandidats() {

		String tempCandidats = temp.firstElement() + ",";
		int i = 0;
		Candidat candidat = new Candidat();
		while (tempCandidats.length() > 0) {

			String name = tempCandidats
					.substring(0, tempCandidats.indexOf(","));
			candidat = new Candidat(name, i);
			i++;
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
			Vector<Integer> tempVoteOrder = new Vector<Integer>();
			for (int j = 0; j < s.length(); j++)
				tempVoteOrder.add(Integer.parseInt(Character.toString(s
						.charAt(j))));
			voteOrder.add(tempVoteOrder);
		}
	}

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

	public Candidat getCandidatToEliminate() {

		Candidat candidat = new Candidat();
		Candidat toEliminate = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			if (!Candidats.elementAt(i).isEliminated)
				toEliminate = Candidats.elementAt(i);
		}

		/**
		 * Find the candidat with the lowest vow depending on the round
		 */

		for (int i = 0; i < Candidats.size(); i++) {
			candidat = Candidats.elementAt(i);
			if (!candidat.isEliminated && candidat.vows < toEliminate.vows) {
				toEliminate = candidat;
			}

		}
		

		return toEliminate;
	}

	public Candidat winner() {
		Candidat winner = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			if(!Candidats.elementAt(i).isEliminated)winner = Candidats.elementAt(i);
		}
		return winner;
	}

}

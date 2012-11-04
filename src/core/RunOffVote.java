package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JOptionPane;

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
			Candidats.elementAt(j).setVowsPerRound(Candidats.size());
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

			// System.out.println(count);
			if (count < Candidats.size() && count >= 0) {
				Candidat candidat = Candidats.elementAt(count);

				if (candidat.getId() == count) {
					int vow = candidat.getVows() + 1;
					//candidat.setVows(vow);
					candidat.vowsPerRound.set(round,
							candidat.vowsPerRound.get(round) + 1);
					candidat.calculatePercentage(voteOrder.size());
				}
			}

		}

		// System.out.println("Initial candidats: " + Candidats);
		// proceedElimination();

		// System.out.println("Current candidats: " + Candidats);
		// System.out.println(voteOrder);
		//
		// System.out.println("After eliminations: ");
		// System.out.println(Candidats);

	}

	/**
	 * Eliminate candidat
	 */
	 public void proceedElimination(Vector<Candidat> v, int round) {
		 int k =0;
		for(int i=0; i<v.size(); i++){
			if(v.get(i)==getCandidatToEliminate())v.get(i).isEliminated=true;
		}
	 }

	public Candidat getCandidatToEliminate() {

		// v will contain candidats to eliminate if there is more than one
		Vector<Candidat> v = new Vector<Candidat>();
		Candidat candidat = new Candidat();
		Candidat toEliminate = new Candidat();
		
		for (int i = 0; i < Candidats.size(); i++){
			if(!Candidats.elementAt(i).isEliminated)
		toEliminate = Candidats.elementAt(i);
		}

		/**
		 * Find the candidat with the lowest vow depending on the round
		 */
		for (int i = 0; i < Candidats.size(); i++) {
			candidat = Candidats.elementAt(i);
			if (! candidat.isEliminated && candidat.vows < toEliminate.vows ){
				toEliminate = candidat;
				candidat.isEliminated = true;
			}
			// System.out.println(toEliminate);

		}
		/**
		 * If there is more than one candidat to elimonate
		 * add all of them to the vector v:
		 */
		for (int i = 0; i < Candidats.size(); i++)
			if (Candidats.elementAt(i).vows == toEliminate.vows)
				v.add(Candidats.elementAt(i));
		System.out.println("V= " + v);
			
		/**
		 * Find the most disliked candidat in vector V
		 */
		toEliminate = v.firstElement();
		int k = Candidats.size() -1;
		for(int i = 0; i < v.size(); i++)
			if(v.elementAt(i).vowsPerRound.get(k)>toEliminate.vowsPerRound.get(k))
				toEliminate = v.elementAt(i);
				
		return toEliminate;
	}

	public Candidat winner() {
		Candidat winner = Candidats.firstElement();
		Candidat candidat = new Candidat();

		for (int i = 0; i < Candidats.size(); i++) {
			candidat = Candidats.elementAt(i);
			if (candidat.vows > winner.vows)
				winner = candidat;

		}
		return winner;
	}

}

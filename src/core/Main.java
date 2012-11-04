package core;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunOffVote r = new RunOffVote("run_off.txt");
		
		for(int i = 0; i<r.Candidats.size();i++)
		r.runOff(i);
		
		for(int i = 0; i<r.Candidats.size();i++){
			Candidat c = r.Candidats.elementAt(i);
			if(!c.isEliminated)
				for(int j=0; j<r.Candidats.size(); j++)
					c.setVows(c.getVows() + c.vowsPerRound.get(j));
		}

		System.out.println(r.Candidats);
		//r.getCandidatToEliminate(1);
		System.out.println(r.getCandidatToEliminate());

	}
}
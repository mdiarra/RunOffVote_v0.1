package core;

import java.util.Vector;

public class Candidat {
	int id; //position in the array
	String name;
	int vows=0;
	Vector<Integer>vowsPerRound = new Vector<Integer>();
	int percentage = 0;
	boolean isEliminated = false;
	
	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public Candidat(String name, int id) {
		super();
		this.name = name;
		this.id =id;
	}
	
	public Candidat() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVows() {
		return vows;
	}
	public void setVows(int vows) {
		this.vows = vows;
	}
	
	
	public Vector<Integer> getVowsPerRound() {
		return vowsPerRound;
	}

	public void setVowsPerRound(int candidats) {
		for(int i=0; i<candidats; i++)vowsPerRound.add(0);
	}

	public int getPercentage() {
		
		return this.percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	public void calculatePercentage(int numberOfVoter){
		this.percentage = (vows*100)/(numberOfVoter) ;
	}
	@Override
	public String toString() {
		return name + "==> " + vowsPerRound + " vows: " +vows /*"which is "+percentage+"%"*/;
	}
	
	

}

package core;

<<<<<<< HEAD
=======
import java.util.Vector;

>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
public class Candidat {
	int id; //position in the array
	String name;
	int vows=0;
<<<<<<< HEAD
	//int percentage = 0;
	boolean isEliminated = false;
	
	/**
	 * First Constructor
=======
	Vector<Integer>vowsPerRound = new Vector<Integer>();
	int percentage = 0;
	boolean isEliminated = false;
	
	/**
	 * Constructor
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	 * @param name
	 * @param id
	 */
	public Candidat(String name, int id) {
		super();
		this.name = name;
		this.id =id;
	}
	
<<<<<<< HEAD
	/**
	 * Second Constructor no parameter
	 */
=======
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
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
	
	
<<<<<<< HEAD
	
	@Override
	public String toString() {
		return name + "==> " + " vows: " +vows /*+ " Eleminated: "+ isEliminated*/;
=======
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
		return name + "==> " + " vows: " +vows + " Eleminated: "+isEliminated;
>>>>>>> ca02cd2c50c9f7791695be645d8b3017371f3283
	}
	
	

}

package core;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;


public class VoteSimulator {
	
	public static void main(String[] args) {
		Vector<String> v = generateVotes(6, 100);
		
		PrintWriter output;
		try{
			for(int i = 0; i<v.size(); i++){
			output = new PrintWriter(new FileWriter("voteFile.txt",true));
			output.printf("%s\r\n", v.elementAt(i));
			
			output.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
		System.out.println(generateVotes(6,2));

	}

	public static Vector<String> generateVotes(int candidats, int voters) {
		Vector<String> v = new Vector<String>();
		for (int j = 0; j < voters; j++) {
			String votes = "";
			Random r = new Random();
			int i = 0;
			while (i < candidats) {
				int x = r.nextInt(candidats) + 1;
				String s = Integer.toString(x);
				if (!votes.contains(s)) {
					votes = votes + s + ",";
					i++;
				}
			}

			votes = votes.substring(0, votes.length() - 1);
			v.add(votes);
		}
		return v;
	}
}
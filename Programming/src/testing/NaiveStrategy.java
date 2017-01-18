package testing;

import java.util.ArrayList;
import java.util.HashSet;
import model.*;

public class NaiveStrategy implements Strategy{
	public String getName(){
		return "Naive";
	}
	
	public int[] determineMove(Board b, Mark m){
		ArrayList<int[]> empty = new ArrayList<int[]>();
		for(int x = 0; x<Board.DIM;x++){
			for(int y = 0; y<Board.DIM;y++){
				for(int z = 0; z<Board.DIM;z++){
					if(b.getField(x,y,z)==Mark.EMPTY){
						empty.add(new int[] {x,y});
					}
				}
			}
		}
		int k = (int)(Math.random() * 10)% empty.size();
		for(int[] e : empty){
			if(k==0) return e;
			else k--;
		}
		return null;
	}
}

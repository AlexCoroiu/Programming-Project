package testing;

import model.*;

import controller.Player;
public class ComputerPlayer extends Player {
	Strategy s;
	
	public ComputerPlayer(Mark mark){
		super("Naive-"+mark,mark);
		this.s=new NaiveStrategy();	
	}
	
	public ComputerPlayer(Mark mark, Strategy strategy){
		super(strategy.getName(),mark);
		this.s=strategy;
	}

	public int[] determineMove(Board b){
		return s.determineMove(b, getMark());
	}

}

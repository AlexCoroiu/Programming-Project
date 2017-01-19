package testing;

import model.Mark;
import view.PlayerTui;

public class TuiTesting {
	public static void main(String[] args) {
		PlayerTui tui = new PlayerTui();
		tui.addMark(0, 3, Mark.X);
		tui.addMark(2, 2, Mark.O);
		tui.addMark(2, 2, Mark.X);
		tui.addMark(2, 2, Mark.O);
		System.out.println(tui.toString());
	}
}

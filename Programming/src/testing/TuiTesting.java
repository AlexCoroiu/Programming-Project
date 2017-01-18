package testing;

import model.Mark;
import view.PlayerTui;

public class TuiTesting {
	public static void main(String[] args) {
		PlayerTui tui = new PlayerTui();
		tui.addMark(0, 3, Mark.RED);
		tui.addMark(2, 2, Mark.YELLOW);
		tui.addMark(2, 2, Mark.RED);
		tui.addMark(2, 2, Mark.YELLOW);
		System.out.println(tui.toString());
	}
}

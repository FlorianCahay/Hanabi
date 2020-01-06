package player;

import mvc.ViewTerminal;

public class PlayerViewTerminal extends ViewTerminal implements PlayerView {
	
	public void showPlayer(Player player) {
		separator();
		append(player.getName());
		append(" it is your turn now\n");
		append("Last hint someone gave you : ");
		append(player.readHint());
	}

	@Override
	public void askPlayType(String name) {
		append(name);
		append(" Which play do you want to do write your choice number down :");
	}
}

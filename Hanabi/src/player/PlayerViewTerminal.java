package player;

import mvc.ViewTerminal;

public class PlayerViewTerminal extends ViewTerminal implements PlayerView {

	public void showPlayer(Player player) {
		separator();
		System.out.println(
				player.getName() + " it is your turn now\n" + "Last hint someone gave you : " + player.readHint());
	}

	@Override
	public void askPlayType(String name) {
		System.out.println(name + " Which play do you want to do write your choice number down :");
	}
}

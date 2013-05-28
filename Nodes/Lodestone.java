package mineUsingNode.Nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;

import mineUsingNode.VARS;

public class Lodestone extends Node {

	@Override
	public boolean activate() {
		return Inventory.isFull() 
			&& Inventory.contains(VARS.softClay)
			&& VARS.wellArea.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		Tabs.ABILITY_BOOK.open();
		if (Widgets.get(275, 41).click(true)) {
			sleep(800, 1000);
			if (Widgets.get(275, 46).click(true)) {
				sleep(900, 1000);
				if (Widgets.get(275, 16).getChild(155).click(true)) {
					sleep(1000, 1200);
					if (Widgets.get(1092, 45).click(true)) {
						sleep(2000);
						Timer t = new Timer(8000);
						while (t.isRunning()
								&& Players.getLocal().getAnimation() == 16385) {
							Task.sleep(4000);
						}
					}
				}
			}
		}
	}
}

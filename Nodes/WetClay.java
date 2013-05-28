package mineUsingNode.Nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

import mineUsingNode.VARS;

public class WetClay extends Node {

	@Override
	public boolean activate() {

		return Inventory.isFull() && Inventory.contains(VARS.clay);

	}

	@Override
	public void execute() {
		if (VARS.wellArea.contains(Players.getLocal())) {
			
			SceneObject well = SceneEntities.getNearest(5086);
			
			if (well != null) {
				if (well.isOnScreen()) {
					Inventory.selectItem(VARS.clay);
					well.click(true);
					sleep(1000, 1200);
					if (Widgets.get(1370, 38).click(true)) {
						Timer t = new Timer(34500);
						while (t.isRunning() && Inventory.contains(VARS.clay)) 
						{
							Task.sleep(69);
						}
					}
				}
			}
		} else {
			Walking.walk(VARS.wellTile);
			sleep(1000, 1200);
		}
	}
}

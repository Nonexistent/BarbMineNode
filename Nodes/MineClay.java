package mineUsingNode.Nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

import mineUsingNode.Vars;

public class MineClay extends Node {

	@Override
	public boolean activate() {
		return Vars.MINE_AREA.contains(Players.getLocal()) && !Inventory.isFull();
	}

	@Override
	public void execute() {

		while (Vars.MINE_AREA.contains(Players.getLocal()) && !Inventory.isFull()) {
			SceneObject rock = SceneEntities.getNearest(Vars.ROCKS);
			
			if (rock != null) {
				if (rock.isOnScreen() && Players.getLocal().isIdle()) {
					rock.interact("Mine");
					sleep(1700, 1800); 			/* Takes a bit to change animation */
					Timer t = new Timer(9000);
					while (t.isRunning() && Players.getLocal().getAnimation() == 624) {
						Task.sleep(69, 666);
					}
				}
			}
		}
	}
}

package mineUsingNode.Nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import mineUsingNode.VARS;

public class MineClay extends Node {

	@Override
	public boolean activate() {
		return VARS.mineArea.contains(Players.getLocal())
		   && !Inventory.isFull();
	}

	@Override
	public void execute() {
		// Mines clay

		while (VARS.mineArea.contains(Players.getLocal())
				&& !Inventory.isFull()) {
			SceneObject rock = SceneEntities.getNearest(VARS.rocks);
			if (rock != null) {
				if (rock.isOnScreen() && Players.getLocal().isIdle()) {
					rock.interact("Mine");
					sleep(1100, 1300);
					if (Players.getLocal().getAnimation() == 625) {
						sleep(800);
					}
				}
			}
		}
	}
}

package mineUsingNode.Nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import mineUsingNode.VARS;

public class ToMine extends Node {

	@Override
	public boolean activate() {
		SceneObject booths = SceneEntities.getNearest(VARS.bankBooth);
		return booths != null && !Inventory.isFull();

	}

	@Override
	public void execute() {
		while (!VARS.mineArea.contains(Players.getLocal())) {
			if (!Inventory.isFull()) {
				Walking.walk(VARS.mineTile);
				System.out.println("going to mine");
				sleep(500, 900);
			}
		}

	}

}

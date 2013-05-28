package mineUsingNode.Nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import mineUsingNode.VARS;

public class ToMine extends Node {

	@Override
	public boolean activate() {
		return VARS.bankArea.contains(Players.getLocal())
			&& !Inventory.isFull();

	}

	@Override
	public void execute() {
		while (!VARS.mineArea.contains(Players.getLocal())) {
			if (VARS.bankArea.contains(Players.getLocal())
					&& !Inventory.isFull()) {
				/*Moving to a suitable location for
				 * Walking.walk(VARS.mineTile) to click the furtherest tile minimap
				 * or else it will get stuck running back and forth between the wall
				 * at the place with the coffins (no exist there).
				 */
				Walking.walk(VARS.toMineTile);
				sleep(900, 1000);
			} else if (!Inventory.isFull()) {
				Walking.walk(VARS.mineTile);
				System.out.println("going to mine");
				sleep(500, 900);
			}
		}
	}
}

package mineUsingNode.Nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import mineUsingNode.Vars;

public class ToMine extends Node {

	@Override
	public boolean activate() {
		return Vars.BANK_AREA.contains(Players.getLocal())
			&& !Inventory.isFull();
	}

	@Override
	public void execute() {
		while (!Vars.MINE_AREA.contains(Players.getLocal())) {
			if (Vars.BANK_AREA.contains(Players.getLocal())
					&& !Inventory.isFull()) {
				/*Moving to a suitable location for
				 * Walking.walk(VARS.mineTile) to click the furtherest tile on minimap
				 * or else it will get stuck running back and forth between the wall
				 * at the place with the coffins (no exist there).
				 */
				Walking.walk(Vars.TO_MINE_TILE);
				sleep(900, 1000);
			} else if (!Inventory.isFull()) {
				Walking.walk(Vars.MINE_TILE);
				System.out.println("going to mine");
				sleep(500, 900);
			}
		}
	}
}

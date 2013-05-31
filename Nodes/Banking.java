package mineUsingNode.Nodes;

import mineUsingNode.Vars;
import mineUsingNode.Utilis;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Random;

public class Banking extends Node {

	@Override
	public boolean activate() {
		return Inventory.getCount() > 1 || Inventory.contains(Vars.SOFT_CLAY)
				&& !Vars.WELL_AREA.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		if (Vars.BANK_AREA.contains(Players.getLocal()) && Calculations.distanceTo(Vars.BANK_TILE) <= 3) {
			if (Bank.open()) {
				Utilis.depositExcept(Vars.PICKAXE);
			}
		} else if (!Vars.BANK_AREA.contains(Players.getLocal())) {
			Walking.walk(Vars.BANK_TILE);
			sleep(Random.nextInt(800, 1000));
			System.out.println("Gon bank yo shizz");

		}
	}
}

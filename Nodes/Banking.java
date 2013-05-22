package mineUsingNode.Nodes;

import mineUsingNode.VARS;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.Item;

public class Banking extends Node {

	@Override
	public boolean activate() {
		if (Inventory.isFull()) {
			return Inventory.contains(VARS.softClay);
		}
		return false;
	}

	@Override
	public void execute() {
		if (VARS.bankArea.contains(Players.getLocal())) {
			if (Calculations.distanceTo(VARS.bankTile) < 4) {
				if (Bank.open()) {
					sleep(800);
					int check = 
	  Inventory.getItemAt(0).getName().contains("pickaxe") ? 1 : 2;

					switch (check) {
					case 1:

						for (int x = 0; x < 28; x++) {
							Item item = Inventory.getItemAt(x);
							if (item == null) {
								continue;
							}
							if (item.getName().contains("pickaxe")) {
								continue;
							}
				
							Bank.deposit(item.getId(), 0);
							System.out.println("depositing:      "+ item.getName());
							Timer t = new Timer(1000);
							while (t.isRunning() && item != null) {
								System.out.println("sleeping");
								Task.sleep(1000);
							}
						}

						break;

					case 2:

						if (Bank.depositInventory()) {
							Timer t = new Timer(500);
							while (t.isRunning() && Inventory.isFull()) {
								Task.sleep(69);
							}
						}

						break;

					default:

						if (Bank.depositInventory()) {
							Timer t = new Timer(500);
							while (t.isRunning() && Inventory.isFull()) {
								Task.sleep(69);
							}
						}
						break;
					}
				}
			}
		} else {
			while (!VARS.bankArea.contains(Players.getLocal())) {
				Walking.walk(VARS.bankTile);
				sleep(Random.nextInt(1000, 1200));
				System.out.println("Gon bank yo shizz");
			}
		}
	}

}

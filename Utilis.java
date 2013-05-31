package mineUsingNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.Item;

public class Utilis {

	// Deposit all except for pickaxe
	public static void depositExcept(final int id) {
		if (!Inventory.contains(id)) {
			Bank.depositInventory();
		} else {
			for (Item k : Inventory.getItems()) {
				if (id != k.getId()) {
					Bank.deposit(k.getId(), 0);
					Timer t = new Timer(2000);
					while (t.isRunning() && Inventory.contains(k.getId())) {
						Task.sleep(200, 300);
					}
				}
			}
		}
	}

	// Getting price of clay
	public static int getPrice() {
		final String add = "http://scriptwith.us/api/?return=text&item=1761";
		try (final BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(add).openConnection().getInputStream()))) {
			final String line = in.readLine();
			return Integer.parseInt(line.split("[:]")[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}

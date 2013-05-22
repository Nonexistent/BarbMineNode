package mineUsingNode;

import mineUsingNode.Nodes.Banking;
import mineUsingNode.Nodes.MineClay;
import mineUsingNode.Nodes.ToMine;
import mineUsingNode.Nodes.WetClay;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;

@Manifest(
		authors = { "Nonexistent" }, 
		description = "Rewrite of first script using node system.", 
		name = "Barb Miner Using Nodes"
		 )

public class MineWithNode extends ActiveScript {

	private final Node[] jobs = {new WetClay(), 
								 new Banking(), 
								 new ToMine(),
								 new MineClay(), 
								};

	@Override
	public int loop() {
		for (Node job : jobs) {
			if (job.activate()) {
				System.out.println(job.getClass().getName());
				job.execute();
				
				int rad = Random.nextInt(0, 100);
				if (rad < 7) {
					Camera.setPitch(Random.nextInt(23, 200));
					Camera.setAngle(Random.nextInt(0, 90));
				}
				return 500;
			}
		}
		return Random.nextInt(500, 900);
	}
}

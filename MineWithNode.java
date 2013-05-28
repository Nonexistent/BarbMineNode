package mineUsingNode;

import java.awt.Graphics;

import mineUsingNode.Nodes.Banking;
import mineUsingNode.Nodes.Lodestone;
import mineUsingNode.Nodes.MineClay;
import mineUsingNode.Nodes.ToMine;
import mineUsingNode.Nodes.WetClay;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;

@Manifest( authors = { "Nonexistent" }, 
		   description = "Rewrite of first script using node system.", 
		   name = "Barb Miner Using Nodes"
	 )

public class MineWithNode extends ActiveScript implements PaintListener,
		MessageListener {

	private final Node[] jobs = { new WetClay(), 
				      new Lodestone(),
				      new Banking(), 
				      new ToMine(), 
				      new MineClay(), 
				    };

	@Override
	public int loop() {
		for (Node job : jobs) {
			if (job.activate()) {
				job.execute();

				int rad = Random.nextInt(0, 140);
				if (rad < 7) {
					Camera.setPitch(Random.nextInt(23, 200));
					Camera.setAngle(Random.nextInt(0, 90));
				}
				return 500;
			}
		}
		return Random.nextInt(500, 900);
	}

	@Override
	public void messageReceived(MessageEvent h) {
		String message = h.getMessage().toString().toLowerCase();
		if (message.equals("you mix the clay and water. you now have some soft, workable clay.")) 
		{
			VARS.clayMade++;
		}
	}

	@Override
	public void onRepaint(Graphics g) {
		g.drawString("Clay Softened: " 
					  + Integer.toString(VARS.clayMade), 24,95);
		
		g.drawString("Time ran: " + VARS.timePast.toElapsedString(), 24, 108);
		
		int perHour = (int) ((VARS.clayMade * 3600000d) / VARS.timePast.getElapsed());
		g.drawString("Clays per Hour: " + Integer.toString(perHour), 24, 121);
	}
}

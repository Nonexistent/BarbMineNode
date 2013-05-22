package mineUsingNode;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;


public class VARS {
	// Some IDs
		/* int u = Random.nextInt(0, 3); */
		public static final int[] rocks = { 10577, 10578 };
		public static final int clay = 434;
		public static final int softClay = 1761;
		public static final int bankBooth = 782;

		// Area tiles
		public static final Area mineArea = new Area(new Tile(3078, 3403, 0), 
				new Tile(3086, 3396, 0));
		
		public static final Area bankArea = new Area(new Tile(3182, 3435, 0), 
				new Tile(3189, 3446, 0));
		
		public static final Area wellArea = new Area(new Tile(3072, 3427, 0), 
				new Tile(3078, 3421, 0));

		// Location tiles
		public static final Tile wellTile = new Tile(3075, 3423, 0);

		public static final Tile bankTile = new Tile(3182, 3435, 0);

		public static final Tile mineTile = new Tile(3083, 3399, 0);
}

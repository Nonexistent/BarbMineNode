package mineUsingNode;

import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;


public class Vars {
	// Some variables
		/* int u = Random.nextInt(0, 3); */
		public static final int[] ROCKS = { 10577, 10578 };
		public static final int CLAY = 434;
		public static final int SOFT_CLAY = 1761;
		public static final Timer timePast = new Timer(0);
		public static int clayMade = 0;
		public static int PICKAXE;
		public static int PRICE;
		
		// Area tiles
		public static final Area MINE_AREA = new Area(new Tile(3078, 3403, 0), 
				new Tile(3086, 3396, 0));
		
		public static final Area BANK_AREA = new Area(new Tile(3097, 3499, 0), 
				new Tile(3084, 3485, 0));
		
		public static final Area WELL_AREA = new Area(new Tile(3072, 3427, 0), 
				new Tile(3078, 3421, 0));

		// Location tiles
		public static final Tile WELL_TILE = new Tile(3075, 3423, 0);

		public static final Tile BANK_TILE = new Tile(3093, 3492, 0);
		
		public static final Tile TO_MINE_TILE = new Tile(3079, 3480, 0);

		public static final Tile MINE_TILE = new Tile(3083, 3399, 0);
}

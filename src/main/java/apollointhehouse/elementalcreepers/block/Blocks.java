package apollointhehouse.elementalcreepers.block;

import apollointhehouse.elementalcreepers.Config;

public class Blocks {
	private static int itemID = Config.cfg.getInt("IDs.blockIDStart");
	private static int nextID() {
		return itemID++;
	}

	public static void initializeBlocks() {

	}
}

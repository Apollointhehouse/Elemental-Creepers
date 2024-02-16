package apollointhehouse.elementalcreepers.entity;

import apollointhehouse.elementalcreepers.Config;

public class Entities {
	private static int itemID = Config.cfg.getInt("IDs.entityIDStart");
	private static int nextID() {
		return itemID++;
	}

	public static void initializeEntities() {
	}
}

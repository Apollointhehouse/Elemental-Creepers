package apollointhehouse.elementalcreepers.item;

import apollointhehouse.elementalcreepers.Config;

public class Items {
	private static int itemID = Config.cfg.getInt("IDs.itemIDStart");
	private static int nextID() {
		return itemID++;
	}

	public static void initializeItems() {

	}
}

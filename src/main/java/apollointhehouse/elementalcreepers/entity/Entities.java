package apollointhehouse.elementalcreepers.entity;

import apollointhehouse.elementalcreepers.Config;
import net.minecraft.core.entity.Entity;
import turniplabs.halplibe.helper.EntityHelper;

public class Entities {
	private static int itemID = Config.cfg.getInt("IDs.entityIDStart");
	private static int nextID() {
		return itemID++;
	}

	public static void initializeEntities() {
		createEntity(EntityFireCreeper.class);
		createEntity(EntityEarthCreeper.class);
		createEntity(EntityIceCreeper.class);
		createEntity(EntityElectricCreeper.class);
		createEntity(EntityPsychicCreeper.class);
		createEntity(EntityMagmaCreeper.class);
		createEntity(EntityGhostCreeper.class);
		createEntity(EntityFriendlyCreeper.class);
		createEntity(EntityCookieCreeper.class);
		createEntity(EntityIllusionCreeper.class);
		createEntity(EntityLightCreeper.class);
		createEntity(EntityDarkCreeper.class);
		createEntity(EntityReverseCreeper.class);
		createEntity(EntityWaterCreeper.class);
	}

	private static void createEntity(Class<? extends Entity> clazz) {
		String name = clazz.getName().split("\\.")[3].substring(6);
		EntityHelper.Core.createEntity(clazz, nextID(), name);
	}
}

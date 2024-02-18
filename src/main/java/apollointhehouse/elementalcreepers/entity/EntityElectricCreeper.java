package apollointhehouse.elementalcreepers.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLightningBolt;
import net.minecraft.core.world.World;

import java.util.List;

public class EntityElectricCreeper extends EntityElementalCreeper {
	public EntityElectricCreeper(World world) {
		super(world);
	}

	@Override
	protected void effect(double radius) {
		List<Entity> entities = world.getEntitiesWithinAABB(EntityElectricCreeper.class, bb.expand(radius, radius, radius));

		for (Entity entity : entities) {
			world.weatherEffects.add(new EntityLightningBolt(world, entity.x, entity.y, entity.z));
		}
	}
}

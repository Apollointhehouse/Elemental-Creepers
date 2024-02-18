package apollointhehouse.elementalcreepers.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntityCreeper;
import net.minecraft.core.world.World;
import apollointhehouse.elementalcreepers.Config;

public abstract class EntityElementalCreeper extends EntityCreeper {
	int timeSinceIgnited;
	protected String clazzName = this.getClass().getName().split("\\.")[3];
	protected String name = clazzName.substring(6);
	protected String textureName = name.toLowerCase();
	private int radius;
	public EntityElementalCreeper(World world) {
		super(world);
	}

	protected double getRadius() {
		if (radius == 0) radius = Config.cfg.getInt("ElementalCreepers.Radius");
		return getPowered() ? this.radius * 1.5 : this.radius;
	}

	@Override
	public String getEntityTexture() {
        return "/assets/elementalcreepers/textures/entities/" + textureName + ".png";
	}

	@Override
	protected void attackEntity(Entity entity, float distance) {
		if (this.world.isClientSide) return;

		if (distance >= 3.0F) {
			if (this.timeSinceIgnited > 0) {
				--this.timeSinceIgnited;
			}
			return;
		}

		this.pathToEntity = null;

		if (this.timeSinceIgnited == 0) {
			this.world.playSoundAtEntity(this, "random.fuse", 1.0F, 0.5F);
		}

		++this.timeSinceIgnited;
		if (this.timeSinceIgnited >= 30) {
			this.effect(this.getRadius());
			this.world.playSoundAtEntity(this, "random.explode", 1.0F, 0.5F);
			this.spawnExplosionParticle();

			this.remove();
		}

		this.hasAttacked = true;
	}

	abstract protected void effect(double radius);
}

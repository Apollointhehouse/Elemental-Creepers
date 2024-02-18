package apollointhehouse.elementalcreepers.entity;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pathfinder.Node;

public class EntityWaterCreeper extends EntityElementalCreeper {
	public EntityWaterCreeper(World world) {
		super(world);
	}

	@Override
	protected void effect(double radius) {
		for (int x = (int) -radius - 1; x <= radius; x++) {
			for (int y = (int) -radius - 1; y <= radius; y++) {
				for (int z = (int) -radius - 1; z <= radius; z++) {
					Node blockPos = new Node((int) this.x + x, (int) this.y + y, (int) this.z + z);
					if (world.getBlockId(blockPos.x, blockPos.y, blockPos.z) != 0) continue;
					if (x*x + y*y + z*z > radius * radius) continue;
					world.setBlockWithNotify(blockPos.x, blockPos.y, blockPos.z, Block.fluidWaterFlowing.id);
				}
			}
		}
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
}

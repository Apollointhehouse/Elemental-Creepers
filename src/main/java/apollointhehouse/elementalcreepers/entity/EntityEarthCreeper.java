package apollointhehouse.elementalcreepers.entity;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pathfinder.Node;

import java.util.Random;

public class EntityEarthCreeper extends EntityElementalCreeper {
	public EntityEarthCreeper(World world) {
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
					switch (new Random().nextInt(5)) {
						case 0: world.setBlockWithNotify(blockPos.x, blockPos.y, blockPos.z, Block.dirt.id); break;
						case 1: world.setBlockWithNotify(blockPos.x, blockPos.y, blockPos.z, Block.dirtScorched.id); break;
						default: world.setBlockWithNotify(blockPos.x, blockPos.y, blockPos.z, 0); break;
					}
				}
			}
		}
	}
}

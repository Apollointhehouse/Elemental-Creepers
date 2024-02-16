package apollointhehouse.elementalcreepers;

import apollointhehouse.elementalcreepers.block.Blocks;
import apollointhehouse.elementalcreepers.entity.Entities;
import apollointhehouse.elementalcreepers.item.Items;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class ElementalCreepers implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
    public static final String MOD_ID = "elementalcreepers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("ElementalCreepers initialized.");
    }

	@Override
	public void beforeGameStart() {
		Items.initializeItems();
		Blocks.initializeBlocks();
		Entities.initializeEntities();
	}

	@Override
	public void afterGameStart() {}

	@Override
	public void beforeClientStart() {
		String[] sounds = {};
		for (String sound : sounds) {
			SoundHelper.Client.addSound(MOD_ID, sound);
		}
	}

	@Override
	public void afterClientStart() {}
}

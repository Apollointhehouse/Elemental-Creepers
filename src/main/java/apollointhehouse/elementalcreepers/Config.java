package apollointhehouse.elementalcreepers;

import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import static apollointhehouse.elementalcreepers.ElementalCreepers.MOD_ID;

public class Config {
	private static final Toml properties = new Toml("Elemental Creepers's TOML Config");
	public static TomlConfigHandler cfg;

	static {
		properties.addCategory("IDs")
			.addEntry("blockIDStart", 1679)
			.addEntry("itemIDStart", 16742)
			.addEntry("entityIDStart", 1679);

		cfg = new TomlConfigHandler(MOD_ID, properties);
	}
}

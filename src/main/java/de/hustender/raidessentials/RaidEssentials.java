package de.hustender.raidessentials;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RaidEssentials.MODID)
public class RaidEssentials {

    public static final String MODID = "raidessentials";

    private static final Logger LOGGER = LogUtils.getLogger();

    public RaidEssentials() {
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Raid Glow loading");
    }
}

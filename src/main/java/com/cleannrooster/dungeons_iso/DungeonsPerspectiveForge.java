package com.cleannrooster.dungeons_iso;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DungeonsPerspectiveForge.MOD_ID)
@Mod.EventBusSubscriber(modid = DungeonsPerspectiveForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class DungeonsPerspectiveForge {
    public static final String MOD_ID = "dungeons_iso";
    private static final Logger LOGGER = LogManager.getLogger("Dungeons Perspective");

    public DungeonsPerspectiveForge() {
        LOGGER.info("Forge entrypoint constructed");
    }

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        ClientInit.initialize();
        event.register(ClientInit.toggleBinding);
        event.register(ClientInit.isoBinding);
        event.register(ClientInit.moveCameraBinding);
        event.register(ClientInit.lockOn);
        event.register(ClientInit.clickToMove);
        event.register(ClientInit.zoomInBinding);
        event.register(ClientInit.zoomOutBinding);
        event.register(ClientInit.verticalBinding);
        event.register(ClientInit.rotateClockwase);
        event.register(ClientInit.interact);
        event.register(ClientInit.rotateCounterClockwise);
        event.register(ClientInit.cycleTargetBinding);
        LOGGER.info("Registered Dungeons Perspective key mappings");
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientInit::initialize);
    }
}

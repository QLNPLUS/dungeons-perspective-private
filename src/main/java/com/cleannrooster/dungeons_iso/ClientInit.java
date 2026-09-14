package com.cleannrooster.dungeons_iso;


import com.cleannrooster.dungeons_iso.config.Config;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ClientInit {
    private static final Logger LOGGER = LogManager.getLogger("Dungeons Perspective");
    private static boolean initialized;
    public static ClientInit instance;
    public static KeyBinding toggleBinding;
    public static KeyBinding isoBinding;
    public static KeyBinding lockOn;
    public static KeyBinding clickToMove;

    public static KeyBinding moveCameraBinding;
    public static KeyBinding zoomInBinding;
    public static KeyBinding zoomOutBinding;
    public static KeyBinding cycleTargetBinding;
    public static KeyBinding rotateCounterClockwise;
    public static KeyBinding rotateClockwase;
    public static KeyBinding interact;
    public static KeyBinding verticalBinding;

    public static boolean isInitialized() {
        return initialized;
    }


    public static boolean isConnectedToServer() {
        ClientPlayNetworkHandler clientPlayNetworkHandler = MinecraftClient.getInstance().getNetworkHandler();
        return clientPlayNetworkHandler != null && clientPlayNetworkHandler.getConnection().isOpen();
    }



    public static void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;
        instance = new ClientInit();
        Config.GSON.load();

        toggleBinding = new KeyBinding(
                "dungeons_iso.binds.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F4,
                "dungeons_iso.binds.category"
        );
        isoBinding = new KeyBinding(
                "dungeons_iso.binds.iso",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_HOME,
                "dungeons_iso.binds.category"
        );
        moveCameraBinding = new KeyBinding(
                "dungeons_iso.binds.moveCamera",
                InputUtil.Type.MOUSE,
                GLFW.GLFW_MOUSE_BUTTON_3,
                "dungeons_iso.binds.category"
        );

        lockOn = new KeyBinding(
                "dungeons_iso.binds.lockOn",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "dungeons_iso.binds.category"
        );

        clickToMove = new KeyBinding(
                "dungeons_iso.binds.clickToMove",
                InputUtil.Type.MOUSE,
                InputUtil.UNKNOWN_KEY.getCode(),
                "dungeons_iso.binds.category"
        );
        zoomInBinding = new KeyBinding(
                "dungeons_iso.binds.zoomIn",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UP,
                "dungeons_iso.binds.category"
        );
        zoomOutBinding = new KeyBinding(
                "dungeons_iso.binds.zoomOut",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_DOWN,
                "dungeons_iso.binds.category"
        );
        verticalBinding = new KeyBinding(
                "dungeons_iso.binds.verticalBinding",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_ALT,
                "dungeons_iso.binds.category"
        );
        rotateClockwase = new KeyBinding(
                "dungeons_iso.binds.rotateClockwise",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT,
                "dungeons_iso.binds.category"
        );
        interact = new KeyBinding(
                "dungeons_iso.binds.interact",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "dungeons_iso.binds.category"
        );
        rotateCounterClockwise = new KeyBinding(
                "dungeons_iso.binds.rotateCounterClockwise",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT,
                "dungeons_iso.binds.category"
        );

        cycleTargetBinding = new KeyBinding(
                "dungeons_iso.binds.cycleTarget",
                InputUtil.Type.KEYSYM,
                InputUtil.UNKNOWN_KEY.getCode(),
                "dungeons_iso.binds.category"
        );

        Config.GSON.save();
        LOGGER.info("Client controls initialized; startup={}, clickToMove={}",
                Config.GSON.instance().onStartup, Config.GSON.instance().clickToMove);


        // Client side stuff



       /* WorldRenderEvents.BLOCK_OUTLINE.register(((worldRenderContext, blockOutlineContext) -> {
            if(Mod.enabled && Mod.crosshairTarget  instanceof BlockHitResult && blockOutlineContext.blockPos().equals(((BlockHitResult) Mod.crosshairTarget).getBlockPos())){
                drawCuboidShapeOutline(worldRenderContext.matrixStack(),worldRenderContext.consumers().getBuffer(RenderLayer.getSolid()), VoxelShapes.cuboid(new Box(blockOutlineContext.blockPos()).expand(0.7)), (double)blockOutlineContext.blockPos().getX() - worldRenderContext.camera().getPos().getX(), (double)blockOutlineContext.blockPos().getY() - worldRenderContext.camera().getPos().getY(), (double)blockOutlineContext.blockPos().getZ() - worldRenderContext.camera().getPos().getZ(), 0.0F, 0.0F, 0.0F, 0.4F);
            }
            return true;
        }));*/
    }

}

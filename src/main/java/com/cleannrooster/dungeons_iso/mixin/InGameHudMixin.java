package com.cleannrooster.dungeons_iso.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.cleannrooster.dungeons_iso.mod.Mod;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(
            method = "renderCrosshair", at = @At("HEAD"), cancellable = true
    )
    private void crosshairPreXIV(DrawContext context,  CallbackInfo ci) {
        if (Mod.enabled) {
            ci.cancel();

        }
    }


}

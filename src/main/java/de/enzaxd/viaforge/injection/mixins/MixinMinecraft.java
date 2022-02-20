package de.enzaxd.viaforge.injection.mixins;

import de.enzaxd.viaforge.ViaForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;initStream()V", ordinal = 0, shift = At.Shift.AFTER))
    private void startGame(CallbackInfo callbackInfo) { // load when the window is already pop up
        try {
            ViaForge.getInstance().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

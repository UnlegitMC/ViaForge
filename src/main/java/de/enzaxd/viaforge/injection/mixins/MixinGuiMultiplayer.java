package de.enzaxd.viaforge.injection.mixins;

import de.enzaxd.viaforge.ViaForge;
import de.enzaxd.viaforge.gui.GuiProtocolSelector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMultiplayer.class)
public abstract class MixinGuiMultiplayer extends GuiScreen {

    @Inject(method = "initGui", at = @At("RETURN"))
    public void injectInitGui(CallbackInfo ci) {
        buttonList.add(new GuiButton(1337, 5, 38, 98, 20,
                ViaForge.getInstance().getProtocol().getName()));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    public void injectActionPerformed(GuiButton p_actionPerformed_1_, CallbackInfo ci) {
        if (p_actionPerformed_1_.id == 1337)
            mc.displayGuiScreen(new GuiProtocolSelector(this));
    }

    @Inject(method = "drawScreen", at = @At("RETURN"))
    public void injectDrawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_, CallbackInfo ci) {
        mc.fontRendererObj.drawStringWithShadow("<-- Current Version",
                104, 44, -1);
    }
}

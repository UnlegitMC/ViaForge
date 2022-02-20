package de.enzaxd.viaforge.util;

import de.enzaxd.viaforge.ViaForge;
import net.minecraftforge.fml.client.config.GuiSlider;

public class SliderUtils {

    private static final ViaForge viaForge = ViaForge.getInstance();

    public static GuiSlider newSlider(int yOffset) {
        final GuiSlider slider = new GuiSlider(1337, 5, 6 + yOffset, 98, 20, "", "",
                0.0, viaForge.getProtocols().size() - 1, viaForge.getProtocols().indexOf(viaForge.getProtocol()),
                false, true, guiSlider -> {
            viaForge.setProtocol(viaForge.getProtocols().get(guiSlider.getValueInt()));
            updateSlider(guiSlider);
        });
        updateSlider(slider);
        return slider;
    }

    private static void updateSlider(final GuiSlider slider) {
        slider.displayString = "Version: " + viaForge.getProtocol().getName() + "(" + viaForge.getProtocol().getVersion() + ")";
    }
}

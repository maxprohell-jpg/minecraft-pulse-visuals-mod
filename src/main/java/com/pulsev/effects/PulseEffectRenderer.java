package com.pulsev.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber
public class PulseEffectRenderer {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.world != null && mc.player != null) {
            renderLimeCyanWaves(mc);
        }
    }

    private static void renderLimeCyanWaves(Minecraft mc) {
        // Set up OpenGL
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        // Draw lime cyan waves
        float waveHeight = 5.0F; // Adjust wave height
        float waveFrequency = 0.05F; // Adjust wave frequency
        float waveSpeed = 0.1F; // Adjust wave speed
        float alpha = 0.5F; // Adjust wave alpha

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);

        for (int x = 0; x <= 400; x += 10) {
            float waveY1 = (float) (Math.sin((x + mc.getRenderPartialTicks()) * waveFrequency) * waveHeight);
            float waveY2 = (float) (Math.sin((x + 10 + mc.getRenderPartialTicks()) * waveFrequency) * waveHeight);

            buffer.pos(x, 100 + waveY1, 0).color(0.0F, 1.0F, 1.0F, alpha).endVertex();
            buffer.pos(x + 10, 100 + waveY2, 0).color(1.0F, 1.0F, 0.0F, alpha).endVertex();
        }

        tessellator.draw();

        // Restore OpenGL state
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }
}
package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;

public class TaikoDonParticle extends TextureSheetParticle {

    protected TaikoDonParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }
}

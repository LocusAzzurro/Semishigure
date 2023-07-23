package org.mineplugin.locusazzurro.semishigure.summerfestival;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class TaikoParticle extends TextureSheetParticle {

    protected TaikoParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.xd = 0;
        this.zd = 0;
        this.yd = 0.4;
        this.lifetime = 20;
    }

    @Override
    public void tick(){
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) this.remove();
        else {
            this.move(xd, yd, zd);
            this.yd *= 0.75d;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public Factory(SpriteSet sprite) {
            this.sprites = sprite;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType dataIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TaikoParticle particle = new TaikoParticle(worldIn, x, y, z);
            particle.setSize(1.0f,1.0f);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}

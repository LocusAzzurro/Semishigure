package org.mineplugin.locusazzurro.semishigure.chargerifle;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.apache.commons.lang3.tuple.Pair;
import org.mineplugin.locusazzurro.semishigure.registry.DamageTypeRegistry;
import org.mineplugin.locusazzurro.semishigure.registry.EntityTypeRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public class ChargeRifleTrackerEntity extends Entity {

    private static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(ChargeRifleTrackerEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<OptionalInt> ATTACHED_TO_TARGET = SynchedEntityData.defineId(ChargeRifleTrackerEntity.class, EntityDataSerializers.OPTIONAL_UNSIGNED_INT);
    private int tick = 0;
    private static final int MAX_TICKS = 11;
    private UUID attachedUUID;
    private int attachedNetworkId;

    public ChargeRifleTrackerEntity(EntityType<? extends ChargeRifleTrackerEntity> type, Level world) {
        super(type, world);
    }

    public ChargeRifleTrackerEntity(Level worldIn, Entity holder){
        this(EntityTypeRegistry.CHARGED_RIFLE_TRACKER.get(), worldIn);
        this.setAttachedTo(holder);
        this.moveToAttached();
    }

    @Override
    public void tick(){
        super.tick();
        this.moveToAttached();
        int tick = this.tickLife();
        if (tick <= MAX_TICKS - 1) this.scan();
        if (tick >= MAX_TICKS) burst();
    }

    private void scan(){
        if (this.getAttachedTo() instanceof Player attachedTo) {
            var result = lineTracing(attachedTo);
            Vec3 originPos = attachedTo.getEyePosition().add(0.0, -0.5, 0.0);
            Vec3 endPos = result.getLeft();
            double distance = originPos.distanceTo(endPos);
            int particleCount = (int) (distance / 0.2d);
            if (!this.level().isClientSide()) {
                for (int i = 0; i < particleCount; i++) {
                    Vec3 direction = originPos.vectorTo(endPos).normalize().scale(0.2d);

                    Vec3 particlePos = new Vec3(
                            originPos.x + direction.x * i,
                            originPos.y + direction.y * i,
                            originPos.z + direction.z * i
                    );
                    List<ServerPlayer> players = ((ServerLevel) level()).players();
                    for (ServerPlayer serverplayer : players) {
                        ((ServerLevel) level()).sendParticles(serverplayer, ParticleTypes.ELECTRIC_SPARK, true,  particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                    }
                    //((ServerLevel) level()).sendParticles((ServerPlayer) attachedTo, ParticleTypes.ELECTRIC_SPARK, true,  particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                    //((ServerLevel) level()).sendParticles(ParticleTypes.ELECTRIC_SPARK, particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                }
                DamageSource damagesource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(DamageTypeRegistry.CHARGE_RIFLE), this.getAttachedTo() != null ? this.getAttachedTo() : this);
                result.getRight().ifPresent(target -> target.hurt(damagesource, 1));
            }
            level().playSound(null, originPos.x, originPos.y, originPos.z, SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 2.0f, 1.0f);
        }
    }

    private void burst() {
        if (this.getAttachedTo() instanceof Player attachedTo) {
            var result = lineTracing(attachedTo);
            Vec3 originPos = attachedTo.getEyePosition().add(0.0, -0.5, 0.0);
            Vec3 endPos = result.getLeft();
            double distance = originPos.distanceTo(endPos);
            int particleCount = (int) (distance / 0.1d);
            if (!this.level().isClientSide()) {
                for (int i = 0; i < particleCount; i++) {
                    Vec3 direction = originPos.vectorTo(endPos).normalize().scale(0.1d);

                    Vec3 particlePos = new Vec3(
                            originPos.x + direction.x * i,
                            originPos.y + direction.y * i,
                            originPos.z + direction.z * i
                    );
                    List<ServerPlayer> players = ((ServerLevel) level()).players();
                    for (ServerPlayer serverplayer : players) {
                        ((ServerLevel) level()).sendParticles(serverplayer, ParticleTypes.END_ROD, true, particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                    }
                    //((ServerLevel) level()).sendParticles((ServerPlayer) attachedTo, ParticleTypes.END_ROD, true,  particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                    //((ServerLevel) level()).sendParticles(ParticleTypes.END_ROD, particlePos.x, particlePos.y, particlePos.z, 1, 0.0, 0.0, 0.0, 0.0);
                }
                result.getRight().ifPresent(target -> {
                    DamageSource damagesource = new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(DamageTypeRegistry.CHARGE_RIFLE), this.getAttachedTo() != null ? this.getAttachedTo() : this);
                    target.hurt(damagesource, 10);
                    for (int i = 0; i < 10; i++) {
                        ((ServerLevel) level()).sendParticles(ParticleTypes.SMOKE, target.position().x, target.position().y + 0.5, target.position().z, 1, 0.0, 0.0, 0.0, 0.0);
                    }
                });
            }
            level().playSound(null, originPos.x, originPos.y, originPos.z, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0f, 2.0f);
        }
        this.discard();
    }

    private int tickLife(){
        this.tick = entityData.get(TICK);
        this.tick++;
        this.entityData.set(TICK, tick);
        return this.tick;
    }

    private void moveToAttached(){
        this.entityData.get(ATTACHED_TO_TARGET).ifPresent((e) -> {
            Entity attachedTo = this.level().getEntity(e);
            if (attachedTo != null)
                this.setPos(attachedTo.getX(), attachedTo.getY(), attachedTo.getZ());
        });
    }

    private void setAttachedTo(@Nullable Entity attachedTo){
        if (attachedTo != null) {
            this.attachedUUID = attachedTo.getUUID();
            this.attachedNetworkId = attachedTo.getId();
            this.entityData.set(ATTACHED_TO_TARGET, OptionalInt.of(attachedTo.getId()));
        }
    }

    @Nullable
    public Entity getAttachedTo() {
        if (this.attachedUUID != null && this.level() instanceof ServerLevel) {
            return ((ServerLevel)this.level()).getEntity(this.attachedUUID);
        } else {
            return this.attachedNetworkId != 0 ? this.level().getEntity(this.attachedNetworkId) : null;
        }
    }

    @Override
    public boolean isPickable(){
        return false;
    }


    public static Pair<Vec3, Optional<LivingEntity>> lineTracing(LivingEntity origin){
        Optional<LivingEntity> target = Optional.empty();
        Vec3 eyePos = origin.getEyePosition(1f);
        Vec3 endPos = new Vec3(eyePos.x, eyePos.y, eyePos.z);
        Vec3 lookVec = origin.getViewVector(1f).normalize();
        Level level = origin.level();
        double hS = 0.2d;
        double stepDist = 0.2d;
        int steps = 500;
        AABB aabb = new AABB(eyePos.add(hS, hS, hS), eyePos.add(-hS, -hS, -hS));
        for (int i = 0; i < steps; i++) {
                Vec3 center = aabb.getCenter();
                target = level.getEntitiesOfClass(LivingEntity.class, aabb).stream().filter(entity -> entity != origin).findFirst();
                if (target.isPresent()) {
                    return Pair.of(center, target);
                }
                if (!level.getBlockState(new BlockPos((int) center.x(), (int) center.y(), (int) center.z())).isAir()) {
                    return Pair.of(center, target);
                }
                aabb = aabb.move(lookVec.scale(stepDist));
        }
        return Pair.of(aabb.getCenter(), target);
    }

    @Override
    public void defineSynchedData() {
        this.entityData.define(TICK, 0);
        this.entityData.define(ATTACHED_TO_TARGET, OptionalInt.empty());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        if(nbt.hasUUID("Source")){
            this.attachedUUID = nbt.getUUID("Source");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        if(this.attachedUUID != null){
            nbt.putUUID("Source", this.attachedUUID);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

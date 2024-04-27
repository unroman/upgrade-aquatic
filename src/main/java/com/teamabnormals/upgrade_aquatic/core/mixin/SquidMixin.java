package com.teamabnormals.upgrade_aquatic.core.mixin;

import com.teamabnormals.upgrade_aquatic.core.UAConfig;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Squid.class)
public abstract class SquidMixin extends Entity {

	private SquidMixin(EntityType<?> entityTypeIn, Level worldIn) {
		super(entityTypeIn, worldIn);
	}

	@Inject(at = @At("HEAD"), method = "spawnInk")
	private void spawnInk(CallbackInfo info) {
		boolean squid = UAConfig.COMMON.squidsGiveBlindness.get();
		boolean glowSquid = UAConfig.COMMON.glowSquidsGiveNightVision.get();

		if (!this.level().isClientSide() && (squid || glowSquid)) {
			for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.5F, 2.5F, 2.5F))) {
				if (!(entity instanceof Squid)) {
					if (glowSquid && ((Squid) (Object) this) instanceof GlowSquid) {
						entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100));
					} else if (squid) {
						entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100));
					}
				}
			}
		}
	}
}

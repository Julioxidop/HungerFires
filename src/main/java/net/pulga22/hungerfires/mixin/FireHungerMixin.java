package net.pulga22.hungerfires.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class FireHungerMixin {

    @Shadow protected HungerManager hungerManager;

    @Shadow public abstract void setFireTicks(int fireTicks);

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Inject(at= @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci){
        if (this.hungerManager.getFoodLevel() <= 4) {
            this.setFireTicks(10);
            this.damage(DamageSource.STARVE, 2.0f);
        }
    }
}

package de.hustender.raidessentials.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Mixin(Raid.class)
public class RaidMixin {

    @Final
    @Shadow
    private Map<Integer, Set<Raider>> groupRaiderMap;

    @Inject(method = "tick()V", at = @At(value = "HEAD"))
    public void onUpdateRaiders(CallbackInfo ci) {
        Iterator<Set<Raider>> iterator = this.groupRaiderMap.values().iterator();

        while(iterator.hasNext()) {
            MobEffectInstance effect = new MobEffectInstance(MobEffects.GLOWING, 10);
            effect.setNoCounter(true);
            iterator.next().forEach(raider -> raider.addEffect(effect));
        }
    }

}

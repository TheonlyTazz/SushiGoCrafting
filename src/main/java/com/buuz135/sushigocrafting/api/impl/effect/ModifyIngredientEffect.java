package com.buuz135.sushigocrafting.api.impl.effect;

import com.buuz135.sushigocrafting.api.IIngredientEffect;
import net.minecraft.potion.EffectInstance;

import java.util.ArrayList;
import java.util.List;

public class ModifyIngredientEffect implements IIngredientEffect {

    private final float timeModifier;
    private final int levelModifier;

    public ModifyIngredientEffect(float timeModifier, int levelModifier) {
        this.timeModifier = timeModifier;
        this.levelModifier = levelModifier;
    }

    @Override
    public void accept(List<EffectInstance> effects) {
        List<EffectInstance> old = new ArrayList<>(effects);
        effects.clear();
        old.forEach(effectInstance -> effects.add(new EffectInstance(effectInstance.getPotion(), (int) (effectInstance.getDuration() * timeModifier), effectInstance.getAmplifier() + levelModifier, false, false)));
    }

    @Override
    public int getPriority() {
        return 1;
    }

    public float getTimeModifier() {
        return timeModifier;
    }

    public int getLevelModifier() {
        return levelModifier;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Amano.excalibur.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class ExcaliburWeaponCapability extends WeaponCapability {


    protected final Map<Style, List<StaticAnimation>> heavyAutoAttackMotions;

    public ExcaliburWeaponCapability(WeaponCapability.Builder builder, Builder efbuilder) {
        super(builder);
        this.heavyAutoAttackMotions = efbuilder.heavyAutoAttackMotionMap;
    }

    public static Builder EFbuilder() {
        return new Builder();
    }

    public static class Builder {
        Map<Style, List<StaticAnimation>> heavyAutoAttackMotionMap = Maps.newHashMap();

        public Builder() {
        }

        public Builder newHeavyStyleCombo(Style style, StaticAnimation... animation) {
            this.heavyAutoAttackMotionMap.put(style, Lists.newArrayList(animation));
            return this;
        }
    }
}

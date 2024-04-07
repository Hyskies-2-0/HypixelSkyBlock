package net.swofty.types.generic.item.items.crimson;

import com.mongodb.lang.Nullable;
import net.swofty.types.generic.item.ItemType;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.*;
import net.swofty.types.generic.item.impl.recipes.ShapelessRecipe;
import net.swofty.types.generic.user.SkyBlockPlayer;
import net.swofty.types.generic.user.statistics.ItemStatistics;

public class DiamondMagmafish implements CustomSkyBlockItem, SkullHead {
    @Override
    public ItemStatistics getStatistics() {
        return ItemStatistics.EMPTY;
    }

    @Override
    public String getSkullTexture(@Nullable SkyBlockPlayer player, SkyBlockItem item) {
        return "19b393eb6a5bd65d735aaa3b3cfa993b50f5e536d7a13b535514bd0740d63350";
    }
}
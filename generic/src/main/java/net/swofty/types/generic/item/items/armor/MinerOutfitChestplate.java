package net.swofty.types.generic.item.items.armor;

import net.minestom.server.color.Color;
import net.swofty.types.generic.item.ItemType;
import net.swofty.types.generic.item.MaterialQuantifiable;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.*;
import net.swofty.types.generic.item.impl.recipes.ShapedRecipe;
import net.swofty.types.generic.user.statistics.ItemStatistic;
import net.swofty.types.generic.user.statistics.ItemStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinerOutfitChestplate implements CustomSkyBlockItem, StandardItem, LeatherColour, Sellable, DefaultCraftable {
    @Override
    public SkyBlockRecipe<?> getRecipe() {
        Map<Character, MaterialQuantifiable> ingredientMap = new HashMap<>();
        ingredientMap.put('A', new MaterialQuantifiable(ItemType.ENCHANTED_COBBLESTONE, 1));
        ingredientMap.put(' ', new MaterialQuantifiable(ItemType.AIR, 1));
        List<String> pattern = List.of(
                "A A",
                "AAA",
                "AAA");

        return new ShapedRecipe(SkyBlockRecipe.RecipeType.FORAGING, new SkyBlockItem(ItemType.MINERS_OUTFIT_CHESTPLATE), ingredientMap, pattern);
    }

    @Override
    public ItemStatistics getStatistics() {
        return ItemStatistics.builder()
                .with(ItemStatistic.DEFENSE, 40D)
                .build();
    }

    @Override
    public Color getLeatherColour() {
        return new Color(0x2DE35E);
    }

    @Override
    public double getSellValue() {
        return 1920;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.CHESTPLATE;
    }
}

package net.swofty.item.items.enchanted;

import net.swofty.item.ItemType;
import net.swofty.item.impl.Enchanted;

public class EnchantedAcaciaWood implements Enchanted {
    @Override
    public ItemType getCraftingMaterial() {
        return ItemType.ACACIA_WOOD;
    }
}
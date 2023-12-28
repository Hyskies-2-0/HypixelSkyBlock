package net.swofty.item.items.enchanted;


import net.swofty.item.ItemType;
import net.swofty.item.impl.Enchanted;

public class EnchantedGoldBlock implements Enchanted {
    @Override
    public ItemType getCraftingMaterial() {
        return ItemType.GOLD_BLOCK;
    }
}
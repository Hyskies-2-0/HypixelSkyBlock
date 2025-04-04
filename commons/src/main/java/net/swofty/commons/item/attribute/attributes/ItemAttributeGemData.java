package net.swofty.commons.item.attribute.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.swofty.commons.item.ItemType;
import net.swofty.commons.item.attribute.ItemAttribute;
import net.swofty.commons.statistics.ItemStatistics;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemAttributeGemData extends ItemAttribute<ItemAttributeGemData.GemData> {

    @Override
    public String getKey() {
        return "gems";
    }

    @Override
    public GemData getDefaultValue(@Nullable ItemStatistics defaultStatistics) {
        return new GemData(new ArrayList<>());
    }

    @Override
    public GemData loadFromString(String string) {
        GemData gemData = new GemData(new ArrayList<>());

        if (string.isEmpty()) {
            return gemData;
        }

        String[] split = string.split(",");
        for (String gem : split) {
            String[] gemSplit = gem.split(":");
            int index = Integer.parseInt(gemSplit[0]);
            ItemType filledWith = null;

            if (!gemSplit[1].equals("null")) {
                filledWith = ItemType.valueOf(gemSplit[1]);
            }

            gemData.putGem(new GemData.GemSlots(index, filledWith));
        }

        return gemData;
    }

    @Override
    public String saveIntoString() {
        List<String> serializedGems = new ArrayList<>();

        this.value.slots.forEach(gem -> {
            if (gem.filledWith == null) {
                serializedGems.add(gem.index + ":null");
            } else {
                serializedGems.add(gem.index + ":" + gem.filledWith.name());
            }
        });

        return String.join(",", serializedGems);
    }

    public static class GemData {
        public List<GemSlots> slots;

        public GemData(List<GemSlots> slots) {
            this.slots = slots;
        }

        public void putGem(GemSlots slot) {
            slots.add(slot);
        }

        public boolean hasGem(int index) {
            boolean hasGem = false;
            for (GemSlots slot : slots) {
                if (slot.index == index) {
                    hasGem = true;
                    break;
                }
            }
            return hasGem;
        }

        public GemSlots getGem(int index) {
            for (GemSlots slot : slots) {
                if (slot.index == index) {
                    return slot;
                }
            }
            return null;
        }

        @AllArgsConstructor
        @Getter
        @Setter
        public static class GemSlots {
            public int index;
            public @Nullable ItemType filledWith;
        }
    }
}

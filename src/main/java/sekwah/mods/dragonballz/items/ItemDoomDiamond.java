package sekwah.mods.dragonballz.items;

import sekwah.mods.dragonballz.DragonBallZMod;
import net.minecraft.item.Item;

public class ItemDoomDiamond extends Item {
    public ItemDoomDiamond() {
        this.setCreativeTab(DragonBallZMod.dbTab);
        this.setTextureName(DragonBallZMod.modid + ":" + "itemDoomDiamond");
    }
}

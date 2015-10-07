package sekwah.mods.dragonballz.blocks;

import sekwah.mods.dragonballz.DragonBallZMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNamekianIronOre extends Block {
    public BlockNamekianIronOre() {
        super(Material.rock);
        this.setHardness(1.3F);
        this.setResistance(10F);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianIronOre");
    }
}

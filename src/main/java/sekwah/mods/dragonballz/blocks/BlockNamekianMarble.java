package sekwah.mods.dragonballz.blocks;

import sekwah.mods.dragonballz.DragonBallZMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNamekianMarble extends Block {
    public BlockNamekianMarble() {
        super(Material.rock);
        setHardness(1.3F);
        setResistance(10F);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianMarble");

    }
}

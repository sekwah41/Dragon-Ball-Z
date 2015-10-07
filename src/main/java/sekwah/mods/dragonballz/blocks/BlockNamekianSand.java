package sekwah.mods.dragonballz.blocks;

import sekwah.mods.dragonballz.DragonBallZMod;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BlockNamekianSand extends BlockFalling {
    public BlockNamekianSand() {
        super(Material.sand);
        this.setStepSound(soundTypeSand);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianSand");
    }
}

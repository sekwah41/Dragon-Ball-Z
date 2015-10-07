package sekwah.mods.dragonballz.blocks;


import sekwah.mods.dragonballz.DragonBallZMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNamekianWoodPlanks extends Block
{
    public BlockNamekianWoodPlanks() {
        super(Material.wood);
        this.setStepSound(soundTypeWood);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianWoodPlanks");
    }
}

package sekwah.mods.dragonballz.blocks.renderers;


import sekwah.mods.dragonballz.model.parts.thinTreeModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityThinTreeRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation texture = new ResourceLocation("dragonballz:textures/blocks/model/blockThinTree.png");

    private thinTreeModel model;

    public TileEntityThinTreeRenderer()
    {
        this.model = new thinTreeModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity p_147500_1_, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        this.bindTexture(texture);
        GL11.glPushMatrix();
        this.model.render();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}

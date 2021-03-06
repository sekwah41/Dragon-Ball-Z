package sekwah.mods.dragonballz.client;


import sekwah.mods.dragonballz.blocks.DragonBallZBlocks;
import sekwah.mods.dragonballz.blocks.itemrenderers.ItemRendererDragonBall;
import sekwah.mods.dragonballz.blocks.renderers.TileEntityDragonBallRenderer;
import sekwah.mods.dragonballz.blocks.tileentity.TileEntityDragonBall;
import sekwah.mods.dragonballz.client.gui.GuiChiBar;
import sekwah.mods.dragonballz.common.CommonProxy;
import sekwah.mods.dragonballz.entity.EntityFlyingNimbus;
import sekwah.mods.dragonballz.player.RenderDBZPlayer;
import sekwah.mods.dragonballz.render.RenderFlyingNimbus;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    public void registerEveryThing()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNimbus.class, new RenderFlyingNimbus());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderDBZPlayer());
        FMLCommonHandler.instance().bus().register(new PlayerRenderTickEvent());
        FMLCommonHandler.instance().bus().register(new PlayerClientTickEvent());

        MinecraftForge.EVENT_BUS.register(new EventHook());
    }

    public void registerCustomBlocks()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDragonBall.class, new TileEntityDragonBallRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall1), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall2), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall3), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall4), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall5), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall6), new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall7), new ItemRendererDragonBall());

        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockThinTree), new ItemRendererThinTree());
    }

    public void addInGameGUIs()
    {
        MinecraftForge.EVENT_BUS.register(new GuiChiBar(Minecraft.getMinecraft()));
    }
}

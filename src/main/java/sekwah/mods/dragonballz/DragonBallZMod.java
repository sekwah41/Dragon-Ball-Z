package sekwah.mods.dragonballz;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sekwah.mods.dragonballz.animation.DBZAnimator;
import sekwah.mods.dragonballz.animation.Pose;
import sekwah.mods.dragonballz.animation.dynamicplayerposes.FlyingPose;
import sekwah.mods.dragonballz.blocks.DragonBallZBlocks;
import sekwah.mods.dragonballz.commands.SetRace;
import sekwah.mods.dragonballz.common.CommonProxy;
import sekwah.mods.dragonballz.entity.DragonBallZEntitys;
import sekwah.mods.dragonballz.events.EventHook;
import sekwah.mods.dragonballz.items.DragonBallZItems;
import sekwah.mods.dragonballz.packets.clientbound.ClientAbilityPacket;
import sekwah.mods.dragonballz.packets.clientbound.ClientAnimationPacket;
import sekwah.mods.dragonballz.packets.clientbound.ClientParticleEffectPacket;
import sekwah.mods.dragonballz.packets.clientbound.ClientSoundPacket;
import sekwah.mods.dragonballz.packets.serverbound.ServerAbilityPacket;
import sekwah.mods.dragonballz.packets.serverbound.ServerAnimationPacket;
import sekwah.mods.dragonballz.packets.serverbound.ServerParticleEffectPacket;
import sekwah.mods.dragonballz.packets.serverbound.ServerSoundPacket;

import java.io.InputStream;


@Mod(modid = DragonBallZMod.modid, version = DragonBallZMod.version)
public class DragonBallZMod {

    public static final String modid = "dragonballz";
    public static final String version = "0.0.1";

    public static SimpleNetworkWrapper packetNetwork;

    public static final Logger LOGGER = LogManager.getLogger("DragonBallZ");

    //Proxy:
    @SidedProxy(clientSide = "sekwah.mods.client.ClientProxy", serverSide = "sekwah.mods.common.CommonProxy")
    public static CommonProxy proxy;


    public static CreativeTabs dbTab = new CreativeTabs("dragonBallZModTab") {
        public Item getTabIconItem() {
            return Items.apple;
        }
    };

    public static DBZAnimator entityAnimator;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        this.packetNetwork();

        //DragonBallZBlocks.addBlocks();
        //DragonBallZItems.addItems();
        //DragonBallZEntitys.addEntitys(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        entityAnimator = new DBZAnimator();

        DBZAnimator.playerPoses = new Pose[2];
        DBZAnimator.playerPoses[0] = new Pose("default");
        DBZAnimator.playerPoses[1] = new FlyingPose();

        InputStream fileStreamJson = DragonBallZMod.class.getResourceAsStream("/assets/dragonballz/mod/poseData.json");
        entityAnimator.playerPoses = entityAnimator.addPoses(fileStreamJson, entityAnimator.playerPoses);

        MinecraftForge.EVENT_BUS.register(new EventHook());
        DragonBallZBlocks.addBlocks();
        DragonBallZItems.addItems();
        DragonBallZEntitys.addEntitys(this);



        proxy.registerEveryThing();
        proxy.registerCustomBlocks();

    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new SetRace());
    }

    private void packetNetwork() {
        // Stands for DragonBall Z
        packetNetwork = NetworkRegistry.INSTANCE.newSimpleChannel("DBZ");
        packetNetwork.registerMessage(ClientParticleEffectPacket.class, ClientParticleEffectPacket.class, 0, Side.CLIENT);
        packetNetwork.registerMessage(ClientAbilityPacket.class, ClientAbilityPacket.class, 1, Side.CLIENT);
        packetNetwork.registerMessage(ClientSoundPacket.class, ClientSoundPacket.class, 2, Side.CLIENT);
        packetNetwork.registerMessage(ClientAnimationPacket.class, ClientAnimationPacket.class, 3, Side.CLIENT);

        packetNetwork.registerMessage(ServerParticleEffectPacket.class, ServerParticleEffectPacket.class, 4, Side.SERVER);
        packetNetwork.registerMessage(ServerAbilityPacket.class, ServerAbilityPacket.class, 5, Side.SERVER);
        packetNetwork.registerMessage(ServerAnimationPacket.class, ServerAnimationPacket.class, 6, Side.SERVER);
        packetNetwork.registerMessage(ServerSoundPacket.class, ServerSoundPacket.class, 7, Side.SERVER);

    }
}

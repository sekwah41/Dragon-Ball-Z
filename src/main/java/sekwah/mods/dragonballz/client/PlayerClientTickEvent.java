package sekwah.mods.dragonballz.client;

import sekwah.mods.dragonballz.packets.PacketAnimationUpdate;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.DataWatcher;

import java.util.ArrayList;

public class PlayerClientTickEvent {
    // to do with the keypress data for jutsus
    public static String JutsuCombo = "";

    public static int JutsuKeyDelay = 0;

    public static float chi = 100;
    public static float maxChi = 100;
    public static int ChiCooldown;
    public static boolean isChiFocus;
    public static String jutsuPoseID = "default"; // finish this so it is set by the different jutsu, for chakra charge it when its turned off and on. and for other jutsus set a delay untill its changed back
    private static boolean ChiCharge = false;
    private static int ChiChargeDelay = 20;
    private static double lastX;
    private static double lastY;
    private static double lastZ;
    private static boolean playerMoved;

    public static ArrayList<String> defaultAnims = new ArrayList<String>();

    public static String defaultPose = "default";

    public int animationUpdate; // use at some point to update animations after they have been set.
    private boolean hasSentUpdatePacket = false;

    // TODO add it so that the default animation is also stored so it changes it to that before the other poses are executed.
    public PlayerClientTickEvent(){
        defaultAnims.add("default");
        defaultAnims.add("flying");
    }

    public static String getJutsuPoseID() {
        return jutsuPoseID;
    }

    @SubscribeEvent
    public void tick(ClientTickEvent event) {
        GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
        if (guiscreen == null || guiscreen instanceof GuiInventory || guiscreen instanceof GuiChat) {


            boolean ChiFocus = false;

            EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;

            if(playerMP.capabilities.isFlying){
                defaultPose = "flying";
            }
            else{
                defaultPose = "default";
            }

            // TODO change stuff and get this all working to change animations
            // System.out.println(defaultPose);

            // tell it to send if the animation was default but has changed

            DataWatcher dw = playerMP.getDataWatcher();

            //System.out.println(dw.getWatchableObjectString(20));

            // TODO set hasSentUpdatePacket to false when the animation is not in the list or is equal to the current one.

            if(dw.getWatchableObjectString(20).equals(defaultPose)){
                hasSentUpdatePacket = false;
            }

            if(defaultAnims.contains(dw.getWatchableObjectString(20)) && !dw.getWatchableObjectString(20).equals(defaultPose) && !hasSentUpdatePacket){
                hasSentUpdatePacket = true;
                PacketAnimationUpdate.animationUpdate(defaultPose, playerMP);
            }

            if (lastX == playerMP.posX && lastY == playerMP.posY && lastZ == playerMP.posZ) {
                playerMoved = false;
            } else {
                playerMoved = true;
            }


            lastX = playerMP.posX;
            lastY = playerMP.posY;
            lastZ = playerMP.posZ;

        }
    }
}

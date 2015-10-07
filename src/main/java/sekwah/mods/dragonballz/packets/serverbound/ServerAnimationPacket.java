package sekwah.mods.dragonballz.packets.serverbound;

import sekwah.mods.dragonballz.packets.DragonBallZMessage;
import sekwah.mods.dragonballz.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerAnimationPacket extends DragonBallZMessage implements IMessageHandler<ServerAnimationPacket, IMessage> {
    public ServerAnimationPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerAnimationPacket() {
    }

    public IMessage onMessage(ServerAnimationPacket message, MessageContext ctx) {
        ServerPacketHandler.handleAnimationPacket(message.packet, ctx.getServerHandler().playerEntity);
        return null;
    }
}
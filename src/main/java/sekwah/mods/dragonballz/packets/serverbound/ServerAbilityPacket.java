package sekwah.mods.dragonballz.packets.serverbound;

import sekwah.mods.dragonballz.packets.DragonBallZMessage;
import sekwah.mods.dragonballz.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerAbilityPacket extends DragonBallZMessage implements IMessageHandler<ServerAbilityPacket, IMessage> {
    public ServerAbilityPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerAbilityPacket() {
    }

    public IMessage onMessage(ServerAbilityPacket message, MessageContext ctx) {
        ServerPacketHandler.handleJutsuPacket(message.packet, ctx.getServerHandler().playerEntity);
        return null;
    }
}
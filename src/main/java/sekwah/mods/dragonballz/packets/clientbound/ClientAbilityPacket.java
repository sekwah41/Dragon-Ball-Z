package sekwah.mods.dragonballz.packets.clientbound;

import sekwah.mods.dragonballz.packets.ClientPacketHandler;
import sekwah.mods.dragonballz.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientAbilityPacket extends DragonBallZMessage implements IMessageHandler<ClientAbilityPacket, IMessage> {
    public ClientAbilityPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientAbilityPacket() {
    }

    public IMessage onMessage(ClientAbilityPacket message, MessageContext ctx) {
        ClientPacketHandler.handleJutsuData(message.packet);
        return null;
    }
}
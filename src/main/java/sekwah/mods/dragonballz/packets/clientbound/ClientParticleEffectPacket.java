package sekwah.mods.dragonballz.packets.clientbound;

import sekwah.mods.dragonballz.packets.ClientPacketHandler;
import sekwah.mods.dragonballz.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientParticleEffectPacket extends DragonBallZMessage implements IMessageHandler<ClientParticleEffectPacket, IMessage> {
    public ClientParticleEffectPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientParticleEffectPacket() {
    }

    public IMessage onMessage(ClientParticleEffectPacket message, MessageContext ctx) {
        ClientPacketHandler.handleParticleEffect(message.packet);
        return null;
    }
}
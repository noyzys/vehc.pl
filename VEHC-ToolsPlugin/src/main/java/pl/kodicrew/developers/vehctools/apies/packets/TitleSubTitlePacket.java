package pl.kodicrew.developers.vehctools.apies.packets;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class TitleSubTitlePacket {

    public static void sendTitle(Player player, String up, String down, int fadein, int in, int fadeout) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColorUtil.colored(up) + "\"}");
        IChatBaseComponent chatSubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColorUtil.colored(down) + "\"}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(fadein, in, fadeout);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(subtitle);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(length);
    }
}

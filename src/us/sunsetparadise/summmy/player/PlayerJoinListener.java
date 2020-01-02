package us.sunsetparadise.summmy.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import us.sunsetparadise.summmy.Blob;
import us.sunsetparadise.summmy.info.ChatFormat;

public class PlayerJoinListener extends ChatFormat implements Listener {

    private Blob pl;
    public PlayerJoinListener(Blob pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (pl.getConfig().getBoolean(".joinboolean", true)) {
            event.setJoinMessage(event.getPlayer().getName() + " Joined the game");
        } else if (pl.getConfig().getBoolean(".joinboolean", false)) {
            event.setJoinMessage(null);
        }

        Player player = event.getPlayer();
        sendCenteredMessage(player, "");
        sendCenteredMessage(player, "" + pl.getConfig().get(""));
        sendCenteredMessage(player, "");
        sendCenteredMessage(player, "");
    }
}

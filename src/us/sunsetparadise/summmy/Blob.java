package us.sunsetparadise.summmy;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Blob extends JavaPlugin {

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void onEnable() {
        loadConfiguration();

        if (getConfig().getBoolean(".time", true)) {
            for (World world : Bukkit.getWorlds()){
                world.setTime(150);
                world.setStorm(false);
                world.setGameRuleValue("doDaylightCycle", "false");
                world.setDifficulty(Difficulty.EASY);
            }
        }


        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    ActionBarAPI.sendActionBar(player, "" + getConfig().get(".actionbar"));
                }
            }
        }, 0, 20);
    }

}

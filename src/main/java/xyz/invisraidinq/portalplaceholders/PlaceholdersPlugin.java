package xyz.invisraidinq.portalplaceholders;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaceholdersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();
        this.getLogger().info("Enabling plugin PortalPlaceholders by InvisRaidinq");

        if (Bukkit.getPluginManager().getPlugin("Portal") == null) {
            this.getLogger().severe("Portal not found, PLEASE INSTALL IT");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            this.getLogger().severe("PlaceholderAPI not found, PLEASE INSTALL IT");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        new PortalPlaceholderExpansion().register();
        this.getLogger().info("Enabled PortalPlaceholders in " + (System.currentTimeMillis() - start) + "ms");

    }
}

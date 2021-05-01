package xyz.invisraidinq.portalplaceholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.joeleoli.portal.shared.queue.Queue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PortalPlaceholderExpansion extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "portal";
    }

    @Override
    public String getAuthor() {
        return "InvisRaidinq";
    }

    @Override
    public String getVersion() {
        return "0.0.1-SNAPSHOT";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (identifier.equalsIgnoreCase("position")) {
            Queue queue = Queue.getByPlayer(player.getUniqueId());
            if (queue != null) {
                return String.valueOf(queue.getPosition(player.getUniqueId()));
            }

            return "0";
        }

        if (identifier.equalsIgnoreCase("queueSize")) {
            Queue queue = Queue.getByPlayer(player.getUniqueId());
            if (queue != null) {
                return String.valueOf(queue.getPlayers().size());
            }

            return "0";
        }

        if (identifier.equalsIgnoreCase("queueName")) {
            Queue queue = Queue.getByPlayer(player.getUniqueId());
            if (queue != null) {
                return queue.getName();
            }

            return "None";
        }

        return "[Portal] Invalid Placeholder";
    }
}

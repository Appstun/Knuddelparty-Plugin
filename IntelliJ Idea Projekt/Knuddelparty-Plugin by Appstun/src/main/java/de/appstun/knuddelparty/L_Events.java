package de.appstun.knuddelparty;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class L_Events implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if(_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if(_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if(_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if(_Main.IsKnuddelparty) {
            if(_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if(_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                _Main.KnuddelnpartyMemberQuit.add(p.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(_Main.KnuddelnpartyMemberQuit.contains(p.getUniqueId())) {
            _Main.KnuddelnpartyMemberQuit.remove(p.getUniqueId());
            if(!_Main.IsKnuddelparty) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.sendMessage(_Main.prefix + "§cLeider hast du den Server verlassen, während du bei einer Knuddelparty mit gemacht hast. Die Knuddelparty ist vorbei und weil du offline warst, konntest du nicht zurück teleportiert werden. §aDu bekommst nun deshalb 2 kurze Effekte.");
                        p.setNoDamageTicks(20 * 15);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20 * 15, 255));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 30, 255));
                    }
                }.runTaskLater(_Main.getPlugin(_Main.class), 20);
            }
        }
    }
}

package de.appstun.knuddelparty;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockFromToEvent;
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
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(_Main.IsKnuddelparty) {
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setDropItems(false);
            }
        }
    }

    @EventHandler
    public void blockFromToEvent(BlockFromToEvent e) {
        if(_Main.IsKnuddelparty) {
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

        @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if((e.getBlock().getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && e.getBlock().getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (e.getBlock().getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && e.getBlock().getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (e.getBlock().getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && e.getBlock().getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent e) {
        Player p = e.getPlayer();
        if(_Main.IsKnuddelparty) {
            if((p.getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && p.getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (p.getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && p.getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (p.getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && p.getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntityType() == EntityType.PLAYER) {
            Player p = (Player) e.getEntity();
            if (_Main.IsKnuddelparty) {
                if ((p.getLocation().getX() >= _Main.PlayerLocation.getX() - 15 && p.getLocation().getX() <= _Main.PlayerLocation.getX() + 15) && (p.getLocation().getY() >= _Main.PlayerLocation.getY() - 15 && p.getLocation().getY() <= _Main.PlayerLocation.getY() + 15) && (p.getLocation().getZ() >= _Main.PlayerLocation.getZ() - 15 && p.getLocation().getZ() <= _Main.PlayerLocation.getZ() + 15)) {
                    e.setCancelled(true);
                }
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

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(e.getMessage().equals("%debug")) {
            if(p.isOp()) {
                e.setCancelled(true);
                if(_Main.debug) {
                    _Main.debug = false;
                    p.sendMessage("§7§oDebug deaktiviert!");
                } else {
                    _Main.debug = true;
                    p.sendMessage("§7§oDebug aktiviert!");
                }
            }
        }
    }
}

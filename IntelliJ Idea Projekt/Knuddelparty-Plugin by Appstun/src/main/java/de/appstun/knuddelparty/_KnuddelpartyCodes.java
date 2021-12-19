package de.appstun.knuddelparty;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;

public class _KnuddelpartyCodes {
    public static void Maincode (Player p) {
        UUID p_uudíd = p.getUniqueId();
        _Main.PlayerLocation.setWorld(p.getWorld());
        _Main.PlayerLocation.setX(p.getLocation().getX());
        _Main.PlayerLocation.setY(200);
        _Main.PlayerLocation.setZ(p.getLocation().getZ());
        _Main.PlayerLocation.setPitch(0);
        _Main.PlayerLocation.setYaw(0);
        BossBar Title = Bukkit.createBossBar("§eKnuddelparty von " + p.getName(), BarColor.BLUE, BarStyle.SOLID);
        Title.setVisible(true);
        Title.setProgress(1.0);
        BossBar Status = Bukkit.createBossBar("§eKnuddelparty - Status" + p.getName(), BarColor.BLUE, BarStyle.SOLID);
        Status.setVisible(true);
        Status.setProgress(1.0);

        for (Player po : Bukkit.getOnlinePlayers()) {
            if(_Main.KnuddelpartyMember.contains(po.getUniqueId())) {
                Title.addPlayer(po);
                Status.addPlayer(po);
                Location po_loc = po.getLocation();
                GameMode gm = po.getGameMode();
                String PlayerListName = po.getPlayerListName();
                _Main.WhenEnd = Bukkit.getScheduler().scheduleSyncRepeatingTask(_Main.getPlugin(), () -> {
                    if (_Main.Time == 0 && _Main.KnuddelpartyMember.contains(po.getUniqueId())) {
                        _Main.KnuddelpartyMember.remove(po.getUniqueId());
                        po.teleport(po_loc);
                        po.setGameMode(gm);
                        po.setPlayerListName(PlayerListName);
                        if(po.getPlayerListName().equals(_Main.name + " §7|| §e" + po.getName())) {
                            po.setPlayerListName(po.getName());
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                po.teleport(po_loc);
                                po.setGameMode(gm);
                            }
                        }.runTaskLater(_Main.getPlugin(_Main.class), 20);
                    }
                }, 0, 10);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        po.teleport(_Main.PlayerLocation);
                        po.setGameMode(GameMode.SURVIVAL);
                        po.setPlayerListName(_Main.name + " §7|| §e" + po.getName());
                    }
                }.runTaskLater(_Main.getPlugin(_Main.class), 5);
            }
        }

        _Main.KnuddelpartyTimer = Bukkit.getScheduler().scheduleSyncRepeatingTask(_Main.getPlugin(), new Runnable() {
            int time = 301;
            @Override
            public void run() {
                time -= 1;
                _Main.Time = time;
                if (_Main.EndKnuddelparty || _Main.EndOpKnuddelparty) {
                    time = 5;
                    _Main.Time = 5;
                    _Main.EndKnuddelparty = false;
                    _Main.EndOpKnuddelparty = false;
                }
                if (time == 0) {
                    Bukkit.broadcastMessage(_Main.prefix + "§c§lKnuddelparty beendet!");
                }
                if (!p.isOnline() && time > 5) {
                    _Main.EndKnuddelparty = true;
                    for (Player po : Bukkit.getOnlinePlayers()) {
                        if (_Main.KnuddelpartyMember.contains(po.getUniqueId())) {
                            po.sendMessage(_Main.prefix + "§c" + p.getName() + " ist offline gegangen. Die Knuddelparty wird in 5 Sekunden beendet. §4:(" );
                        }
                    }
                }
                if(time <= 0) {
                    _Main.IsKnuddelparty = false;
                    Title.removeAll();
                    Status.removeAll();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            _Main.KnuddelpartyMember.clear();
                            Bukkit.getScheduler().cancelTask(_Main.KnuddelpartyTimer);
                            Bukkit.getScheduler().cancelTask(_Main.WhenEnd);
                            for (int x = 0; x < 21; x++) {
                                for (int z = 0; z < 21; z++) {
                                    for (int y = 0; y <= 21; y++) {
                                        Location loc = new Location(_Main.PlayerLocation.getWorld(), _Main.PlayerLocation.getX() - 10 + x, _Main.PlayerLocation.getY() + 16 - y, _Main.PlayerLocation.getZ() - 10 + z);
                                        loc.getBlock().setType(Material.AIR);
                                    }
                                }
                            }
                        }
                    }.runTaskLater(_Main.getPlugin(_Main.class), 60);
                }
                if(time > 5) {
                    Status.setTitle("§6Knuddelparty läuft noch " + time + " Sekunden.");
                } else {
                    if(Status.getProgress() > 0.2) {
                        Status.setProgress(Status.getProgress() - 0.2);
                    }
                    Status.setColor(BarColor.RED);
                    Status.setTitle("§6Knuddelparty endet in " + time + " Sekunden.");
                }
            }
        }, 0, 20);

        for (int x = 0; x < 21; x++) {
            for (int z = 0; z < 21; z++) {
                for (int y = 0; y <= 21; y++) {
                    Location loc = new Location(_Main.PlayerLocation.getWorld(), _Main.PlayerLocation.getX() - 10 + x, _Main.PlayerLocation.getY() + 16 - y, _Main.PlayerLocation.getZ() - 10 + z);
                    loc.getBlock().setType(Material.AIR);
                }
            }
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = 0; x < 21; x++) {
                    for (int z = 0; z < 21; z++) {
                        for (int y = 0; y <= 21; y++) {
                            Location loc = new Location(_Main.PlayerLocation.getWorld(), _Main.PlayerLocation.getX() - 10 + x, _Main.PlayerLocation.getY() - 5 + y, _Main.PlayerLocation.getZ() - 10 + z);
                            if (y != 21 && y != 0) {
                                if ((x >= 0 && z == 0) || (x >= 0 && z == 20) || (x == 0 && z >= 0) || (x == 20 && z >= 0)) {
                                    Random rmd = new Random();
                                    int zufall = rmd.nextInt(8);
                                    switch (zufall) {
                                        case 0:
                                            loc.getBlock().setType(Material.RED_STAINED_GLASS);
                                            break;
                                        case 1:
                                            loc.getBlock().setType(Material.GREEN_STAINED_GLASS);
                                            break;
                                        case 2:
                                            loc.getBlock().setType(Material.BLUE_STAINED_GLASS);
                                            break;
                                        case 3:
                                            loc.getBlock().setType(Material.YELLOW_STAINED_GLASS);
                                            break;
                                        case 4:
                                            loc.getBlock().setType(Material.BROWN_STAINED_GLASS);
                                            break;
                                        case 5:
                                            loc.getBlock().setType(Material.PURPLE_STAINED_GLASS);
                                            break;
                                        case 6:
                                            loc.getBlock().setType(Material.WHITE_STAINED_GLASS);
                                            break;
                                        case 7:
                                            loc.getBlock().setType(Material.GLASS);
                                            break;

                                    }
                                }
                            } else {
                                Random rmd = new Random();
                                int zufall = rmd.nextInt(8);
                                switch (zufall) {
                                    case 0:
                                        loc.getBlock().setType(Material.RED_STAINED_GLASS);
                                        break;
                                    case 1:
                                        loc.getBlock().setType(Material.GREEN_STAINED_GLASS);
                                        break;
                                    case 2:
                                        loc.getBlock().setType(Material.BLUE_STAINED_GLASS);
                                        break;
                                    case 3:
                                        loc.getBlock().setType(Material.YELLOW_STAINED_GLASS);
                                        break;
                                    case 4:
                                        loc.getBlock().setType(Material.BROWN_STAINED_GLASS);
                                        break;
                                    case 5:
                                        loc.getBlock().setType(Material.PURPLE_STAINED_GLASS);
                                        break;
                                    case 6:
                                        loc.getBlock().setType(Material.WHITE_STAINED_GLASS);
                                        break;
                                    case 7:
                                        loc.getBlock().setType(Material.GLASS);
                                        break;

                                }
                            }
                        }
                    }
                }
                for (int x = 0; x < 15; x++) {
                    for (int z = 0; z <= 15; z++) {
                        Location loc = new Location(_Main.PlayerLocation.getWorld(), _Main.PlayerLocation.getX() - 7 + x, _Main.PlayerLocation.getY() - 4, _Main.PlayerLocation.getZ() - 7 + z);
                        Random rmd = new Random();
                        int zufall = rmd.nextInt(20);
                        switch (zufall) {
                            case 0:
                                loc.getBlock().setType(Material.RED_CARPET);
                                break;
                            case 1:
                                loc.getBlock().setType(Material.GREEN_CARPET);
                                break;
                            case 2:
                                loc.getBlock().setType(Material.BLUE_CARPET);
                                break;
                            case 3:
                                loc.getBlock().setType(Material.YELLOW_CARPET);
                                break;
                            case 4:
                                loc.getBlock().setType(Material.BROWN_CARPET);
                                break;
                            case 5:
                                loc.getBlock().setType(Material.PURPLE_CARPET);
                                break;
                            case 6:
                                loc.getBlock().setType(Material.WHITE_CARPET);
                                break;
                            case 7:
                                loc.getBlock().setType(Material.RED_CANDLE);
                                break;
                            case 8:
                                loc.getBlock().setType(Material.GREEN_CANDLE);
                                break;
                            case 9:
                                loc.getBlock().setType(Material.BLUE_CANDLE);
                                break;
                            case 10:
                                loc.getBlock().setType(Material.YELLOW_CANDLE);
                                break;
                            case 11:
                                loc.getBlock().setType(Material.BROWN_CANDLE);
                                break;
                            case 12:
                                loc.getBlock().setType(Material.PURPLE_CANDLE);
                                break;
                            case 13:
                                loc.getBlock().setType(Material.WHITE_CANDLE);
                                break;
                            case 14:
                                loc.getBlock().setType(Material.CAKE);
                                break;
                        }
                    }
                }
            }
        }.runTaskLater(_Main.getPlugin(_Main.class), 5);
    }

    public static void EinladungCounter (Player p) {
        BossBar Title = Bukkit.createBossBar("§3Einladung zur Knuddelparty von " + p.getName() + " §r- §3§l/join", BarColor.GREEN, BarStyle.SOLID);
        Title.setVisible(true);
        Title.setProgress(1.0);
        BossBar Status = Bukkit.createBossBar("Knuddelparty - Einladung - Status", BarColor.GREEN, BarStyle.SOLID);
        Status.setVisible(true);
        Status.setProgress(1.0);
        for (Player po : Bukkit.getOnlinePlayers()) {
            Title.addPlayer(po);
            Status.addPlayer(po);
        }
        
        C_Knuddelparty.Counter = Bukkit.getScheduler().scheduleSyncRepeatingTask(_Main.getPlugin(), new Runnable() {
            int countdown = 61;

            @Override
            public void run() {
                countdown -= 1;
                C_Knuddelparty.size = _Main.KnuddelpartyMember.size();
                if(_Main.StartKnuddelparty) {
                    countdown = 5;
                }
                if(countdown <= 5) {
                    _Main.StartKnuddelparty = false;
                    _Main.IsStartKnuddelparty = true;
                }
                if (countdown <= 0) {
                    Bukkit.getScheduler().cancelTask(C_Knuddelparty.Counter);
                    if (C_Knuddelparty.size >= 2) {
                        Bukkit.broadcastMessage(_Main.prefix + "§a§lEinladung zur Knuddelparty beendet!");
                        Bukkit.broadcastMessage(_Main.prefix + "§5Es machen §f" + C_Knuddelparty.size + " §5Spieler mit.");
                        for (Player po : Bukkit.getOnlinePlayers()) {
                            if (_Main.KnuddelpartyMember.contains(po.getUniqueId())) {
                                po.sendMessage(_Main.prefix + "§aKnuddelparty wird nun für 5 Minuten gestartet! :D");
                                po.sendMessage(_Main.prefix + "§7Wenn du den Server während der Knuddelparty verlässt, kannst du danach nicht mehr auf dein Spielstand zurück gesetzt werden!");
                            } else {
                                po.sendMessage(_Main.prefix + "§7Schade, dass du nicht mit machst :(");
                            }
                        }
                        p.sendMessage(_Main.prefix + "§8§o Nutze §8§l§o/end§r§8§o, um die Knuddelparty zu beenden.");
                        _KnuddelpartyCodes.Maincode(p);
                        _Main.IsKnuddelparty = true;
                        _Main.IsKnuddelpartyEinladung = false;
                        _Main.EndKnuddelparty = false;
                        _Main.EndOpKnuddelparty= false;
                        _Main.EndKnuddelpartyEinladung = false;
                        _Main.EndOpKnuddelpartyEinladung = false;
                        _Main.StartKnuddelparty = false;
                        _Main.IsStartKnuddelparty = false;
                        Title.removeAll();
                        Status.removeAll();
                    } else {
                        Bukkit.broadcastMessage(_Main.prefix + "§c§lEinladung zur Knuddelparty beendet!");
                        if(C_Knuddelparty.size == 1) {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es macht nur §f" + C_Knuddelparty.size + " §5Spieler mit.");
                        } else {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es machen nur §f" + C_Knuddelparty.size + " §5Spieler mit.");
                        }
                        Bukkit.broadcastMessage(_Main.prefix + "§eKnuddelparty wird nicht gestartet. :(");
                        _Main.KnuddelpartyMember.clear();
                        _Main.KnuddelnpartyMemberQuit.clear();
                        _Main.IsKnuddelparty = false;
                        _Main.IsKnuddelpartyEinladung = false;
                        _Main.EndKnuddelparty = false;
                        _Main.EndOpKnuddelparty= false;
                        _Main.EndKnuddelpartyEinladung = false;
                        _Main.EndOpKnuddelpartyEinladung = false;
                        _Main.StartKnuddelparty = false;
                        _Main.IsStartKnuddelparty = false;
                    }
                } else {
                    if (!p.isOnline()) {
                        Bukkit.getScheduler().cancelTask(C_Knuddelparty.Counter);
                        Bukkit.broadcastMessage(_Main.prefix + "§c§lEinladung zur Knuddelparty frühzeitig beendet!");
                        Bukkit.broadcastMessage(_Main.prefix + "§eEinladung beendet, da " + p.getName() + " offline gegangen ist. :(");
                        if(C_Knuddelparty.size == 1) {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätte §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        } else {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätten §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        }
                        _Main.KnuddelpartyMember.clear();
                        _Main.KnuddelnpartyMemberQuit.clear();
                        _Main.IsKnuddelparty = false;
                        _Main.IsKnuddelpartyEinladung = false;
                        _Main.EndKnuddelparty = false;
                        _Main.EndOpKnuddelparty= false;
                        _Main.EndKnuddelpartyEinladung = false;
                        _Main.EndOpKnuddelpartyEinladung = false;
                        _Main.StartKnuddelparty = false;
                        _Main.IsStartKnuddelparty = false;
                        Title.removeAll();
                        Status.removeAll();
                        return;
                    }
                    if(_Main.EndKnuddelpartyEinladung) {
                        Bukkit.getScheduler().cancelTask(C_Knuddelparty.Counter);
                        Bukkit.broadcastMessage(_Main.prefix + "§c§lEinladung zur Knuddelparty frühzeitig beendet!");
                        Bukkit.broadcastMessage(_Main.prefix + "§eEinladung beendet, da " + p.getName() + " nicht mehr möchte. :(");
                        if(C_Knuddelparty.size == 1) {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätte §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        } else {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätten §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        }
                        _Main.KnuddelpartyMember.clear();
                        _Main.KnuddelnpartyMemberQuit.clear();
                        _Main.IsKnuddelparty = false;
                        _Main.IsKnuddelpartyEinladung = false;
                        _Main.EndKnuddelparty = false;
                        _Main.EndOpKnuddelparty= false;
                        _Main.EndKnuddelpartyEinladung = false;
                        _Main.EndOpKnuddelpartyEinladung = false;
                        _Main.StartKnuddelparty = false;
                        _Main.IsStartKnuddelparty = false;
                        Title.removeAll();
                        Status.removeAll();
                        return;
                    }
                    if(_Main.EndOpKnuddelpartyEinladung) {
                        Bukkit.getScheduler().cancelTask(C_Knuddelparty.Counter);
                        Bukkit.broadcastMessage(_Main.prefix + "§c§lEinladung zur Knuddelparty frühzeitig beendet!");
                        Bukkit.broadcastMessage(_Main.prefix + "§eEinladung durch " + p.getName() + " beendet. :(");
                        if(C_Knuddelparty.size == 1) {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätte §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        } else {
                            Bukkit.broadcastMessage(_Main.prefix + "§5Es hätten §f" + C_Knuddelparty.size + " §5Spieler mitgemacht.");
                        }
                        _Main.KnuddelpartyMember.clear();
                        _Main.KnuddelnpartyMemberQuit.clear();
                        _Main.IsKnuddelparty = false;
                        _Main.IsKnuddelpartyEinladung = false;
                        _Main.EndKnuddelparty = false;
                        _Main.EndOpKnuddelparty= false;
                        _Main.EndKnuddelpartyEinladung = false;
                        _Main.EndOpKnuddelpartyEinladung = false;
                        _Main.StartKnuddelparty = false;
                        _Main.IsStartKnuddelparty = false;
                        Title.removeAll();
                        Status.removeAll();
                        return;
                    }
                    if (countdown == 15) {
                        Bukkit.broadcastMessage(_Main.prefix + "§7Die Einladung zur Knuddelparty läuft in 15 Sekunden aus!");
                    }
                    if(C_Knuddelparty.size == 1) {
                        Status.setTitle("§9Noch " + countdown + " Sekunden §7| §b" + C_Knuddelparty.size + " Spieler macht mit");
                    } else {
                        Status.setTitle("§9Noch " + countdown + " Sekunden §7| §b" + C_Knuddelparty.size + " Spieler machen mit");
                    }
                    for (Player po : Bukkit.getOnlinePlayers()) {
                        Title.addPlayer(po);
                        Status.addPlayer(po);
                    }
                }
            }
        }, 0, 20);
    }
}

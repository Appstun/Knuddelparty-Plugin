package de.appstun.knuddelparty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C_Knuddelparty implements CommandExecutor {

    public static int Counter;
    public static int Timer;
    public static int size;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(_Main.KnuddelpartyMember.isEmpty()) {
                _Main.IsKnuddelparty = false;
                _Main.IsKnuddelpartyEinladung = false;
                _Main.EndKnuddelparty = false;
                _Main.EndOpKnuddelparty= false;
                _Main.EndKnuddelpartyEinladung = false;
                _Main.EndOpKnuddelpartyEinladung = false;
            }
            if(args.length > 0) {
                p.sendMessage(_Main.use_command + "/knuddelparty");
            } else {
                if (!_Main.IsKnuddelpartyEinladung) {
                    if (!_Main.IsKnuddelparty) {
                        _Main.IsKnuddelpartyEinladung = true;
                        _Main.KnuddelpartyMember.add(p.getUniqueId());
                        _Main.KnuddelpartyStarter = p.getUniqueId();

                        Bukkit.broadcastMessage(_Main.prefix + "§a§lNeue Einladung zur Knuddelparty!");
                        Bukkit.broadcastMessage(_Main.prefix + "§eVon " + p.getName());
                        Bukkit.broadcastMessage(_Main.prefix + "§1Um mitzumachen, benutze §3§l/join§r§1.");
                        Bukkit.broadcastMessage(_Main.prefix + "§7Die Einladung läuft ab jetzt. Nach 60 Sekunden wird die Knuddelparty für 5 Minuten gestartet!");
                        p.sendMessage(_Main.prefix + "§8§o Nutze §8§l§o/end§r§8§o, um die Einladung zur Knuddelparty zu beenden.");
                        p.sendMessage(_Main.prefix + "§8§o Nutze §8§l§o/start§r§8§o, um die Knuddelparty direkt zu starten.");
                        _KnuddelpartyCodes.EinladungCounter(p);
                    } else {
                        p.sendMessage(_Main.prefix + "§cDu kannst keine Einladung zu einer neuen Knuddelparty starten, da aktuell schon eine Knuddelparty läuft!");
                    }
                } else {
                    p.sendMessage(_Main.prefix + "§cEs wurde schon eine Einladung zu einer Knuddelparty gestartet! §2Um mitzumachen, benutze §l/join§r§2.");
                }
            }
        } else {
            sender.sendMessage(_Main.is_console);
        }
        return false;
    }
}

package de.appstun.knuddelparty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C_Start implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length > 0) {
                p.sendMessage(_Main.use_command + "/end");
            } else {
                if(_Main.IsKnuddelpartyEinladung) {
                    if(p.getUniqueId() == _Main.KnuddelpartyStarter || p.isOp()) {
                        if(!_Main.IsStartKnuddelparty) {
                            _Main.StartKnuddelparty = true;
                            Bukkit.broadcastMessage(_Main.prefix + "§7Die Einladung zur Knuddelparty läuft in 5 Sekunden aus!");
                        } else {
                            p.sendMessage(_Main.prefix + "§cDie Einladung zur Knuddelparty läuft gleich aus!");
                        }
                    } else {
                        p.sendMessage(_Main.prefix + "§cDu hast die Einladung zur Knuddelparty nicht gestartet!");
                    }
                } else {
                    p.sendMessage(_Main.prefix + "§cEs läuft aktuell keine Einladung zu einer Knuddelparty!");
                }
            }
        } else {
            sender.sendMessage(_Main.is_console);
        }
        return false;
    }
}

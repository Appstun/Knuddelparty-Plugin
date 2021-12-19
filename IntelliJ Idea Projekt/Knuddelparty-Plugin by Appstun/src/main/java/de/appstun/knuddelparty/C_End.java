package de.appstun.knuddelparty;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C_End implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length > 0) {
                p.sendMessage(_Main.use_command + "/end");
            } else {
                if (_Main.IsKnuddelparty) {
                    if(p.getUniqueId() == _Main.KnuddelpartyStarter) {
                        Bukkit.broadcastMessage(_Main.prefix + "§c§l" + p.getName() + " beendet nun die Knuddelparty. §75 Sekunden bis diese zu Ende ist. §4:(");
                        _Main.EndKnuddelparty = true;
                    } else {
                        if(p.isOp()) {
                            Bukkit.broadcastMessage(_Main.prefix + "§c§l" + p.getName() + " beendet nun die Knuddelparty. §75 Sekunden bis diese zu Ende ist. §4:(");
                            _Main.EndOpKnuddelparty = true;
                        } else {
                            p.sendMessage(_Main.prefix + "§cDu hast die Knuddelparty nicht gestartet!");
                        }
                    }
                }
                if(_Main.IsKnuddelpartyEinladung) {
                    if(p.getUniqueId() == _Main.KnuddelpartyStarter) {
                        _Main.EndKnuddelpartyEinladung = true;
                    } else {
                        if(p.isOp()) {
                            _Main.EndOpKnuddelpartyEinladung = true;
                        } else {
                            p.sendMessage(_Main.prefix + "§cDu hast die Einladung zur Knuddelparty nicht gestartet!");
                        }
                    }
                }
                if(!_Main.IsKnuddelpartyEinladung && !_Main.IsKnuddelparty) {
                    p.sendMessage(_Main.prefix + "§cEs läuft aktuell keine Knuddelparty und auch keine Einladung zu einer Knuddelparty!");
                }
            }
        } else {
            sender.sendMessage(_Main.is_console);
        }
        return false;
    }
}

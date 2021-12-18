package de.appstun.knuddelparty;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class C_Join implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 0) {
                if (_Main.IsKnuddelpartyEinladung) {
                    if(!_Main.IsKnuddelparty) {
                        if (_Main.KnuddelpartyMember.contains(p.getUniqueId())) {
                            p.sendMessage(_Main.prefix + "§cDu machst schon bei der Knuddelparty mit!");
                        } else {
                            _Main.KnuddelpartyMember.add(p.getUniqueId());
                            p.sendMessage(_Main.prefix + "§aDu machst nun bei der Knuddelparty mit.");
                        }
                    } else {
                        p.sendMessage(_Main.prefix + "§cEs läuft aktuell gerade schon eine Knuddekparty. Du hast die Einladung verpasst!");
                    }
                } else {
                    p.sendMessage(_Main.prefix + "§cEs gibt aktuell keine Einladung zu einer Knuddelparty.");
                }
            } else {
                p.sendMessage(_Main.use_command + "/join");
            }
        } else {
            sender.sendMessage(_Main.is_console);
        }
        return false;
    }
}

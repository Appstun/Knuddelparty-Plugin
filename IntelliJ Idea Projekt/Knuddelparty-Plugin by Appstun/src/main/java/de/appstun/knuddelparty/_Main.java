package de.appstun.knuddelparty;

import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public final class _Main extends JavaPlugin {

    private static _Main plugin;
    public static String name = "§6Knuddelparty§r";
    public static String prefix = _Main.name + " §8>> §r";
    public static String is_console = _Main.name + " §8>> §cDu bist kein Spieler!!!";
    public static String use_command = _Main.name + " §8>> §3Benutze: §r";
    public static String no_perm = _Main.name + " §8>> §cDu hast dafür keine Rechte!";
    public static String target_no_found = _Main.name + " §8>> §cAngegebener Spieler nicht gefunden.";

    //Knuddelparty-Variablen
    public static int Time = -5;
    public static int WhenEnd;
    public static int KnuddelpartyTimer;
    public static UUID KnuddelpartyStarter;
    public static boolean IsKnuddelpartyEinladung = false;
    public static boolean IsKnuddelparty = false;
    public static boolean EndKnuddelparty = false;
    public static boolean EndKnuddelpartyEinladung = false;
    public static boolean EndOpKnuddelparty = false;
    public static boolean EndOpKnuddelpartyEinladung = false;
    public static boolean StartKnuddelparty = false;
    public static boolean IsStartKnuddelparty = false;
    public static ArrayList<UUID> KnuddelpartyMember = new ArrayList<>();
    public static ArrayList<UUID> KnuddelnpartyMemberQuit = new ArrayList<>();
    public static Location PlayerLocation = new Location(Bukkit.getWorld("world"), 0,0,0,0,0);

    public static boolean debug = false;

    @Override
    public void onEnable() {
        plugin = this;
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new L_Events(), this);
        Objects.requireNonNull(getCommand("join")).setExecutor(new C_Join());
        Objects.requireNonNull(getCommand("knuddelparty")).setExecutor(new C_Knuddelparty());
        Objects.requireNonNull(getCommand("end")).setExecutor(new C_End());
        Objects.requireNonNull(getCommand("start")).setExecutor(new C_Start());
    }

    @Override
    public void onDisable() {
        KnuddelpartyMember.clear();
        KnuddelnpartyMemberQuit.clear();
    }

    public static _Main getPlugin(){
        return plugin;
    }
}

package mc.Sh4nx.staffparty.main;

import mc.Sh4nx.staffparty.commands.*;
import mc.Sh4nx.staffparty.events.blockBreakLavaChange;
import mc.Sh4nx.staffparty.events.explosiveDiamondBlockBreak;
import mc.Sh4nx.staffparty.events.explosiveEggThrowEvent;
import mc.Sh4nx.staffparty.events.warningOnLogin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public void registerCommands() {

        getCommand("kaboom").setExecutor(new kaboom());
        getCommand("chargedcreeper").setExecutor(new chargedCreeper());
        getCommand("IWANTDIAMONDS").setExecutor(new diamonds());
        getCommand("tomanyfish").setExecutor(new tomanyfish());
        getCommand("birthday").setExecutor(new birthday());
        getCommand("superjump").setExecutor(new superjump());
        getCommand("spam").setExecutor(new spam());
        getCommand("grief").setExecutor(new grief());
        getCommand("randomjoke").setExecutor(new randomJoke());
        getCommand("randomitem").setExecutor(new randomblocks());
        getCommand("chickenplz").setExecutor(new chickenPlz());
        getCommand("keepmealive").setExecutor(new keepmealive());
        getCommand("alltrolls").setExecutor(new alltrolls());
        getCommand("explosivediamond").setExecutor(new explosivediamond());
        getCommand("oof").setExecutor(new oof());
        getCommand("nuke").setExecutor(new Nuke());
        getCommand("eggtroll").setExecutor(new eggtroll());
        getCommand("lavatroll").setExecutor(new lavatroll());
        getCommand("testblockreplace").setExecutor(new testcobblebreak());
        getCommand("starve").setExecutor(new starve());
        getCommand("burn").setExecutor(new burn());
        getCommand("testuuid").setExecutor(new testuuid());
        getCommand("scare").setExecutor(new scare());
    }
    
    
    
    public void registerEvents() {
    	Bukkit.getServer().getPluginManager().registerEvents(new explosiveDiamondBlockBreak(), this);
    	Bukkit.getServer().getPluginManager().registerEvents(new explosiveEggThrowEvent(), this);
    	Bukkit.getServer().getPluginManager().registerEvents(new blockBreakLavaChange(), this);
    	Bukkit.getServer().getPluginManager().registerEvents(new warningOnLogin(), this);
    }

    public void onEnable() {
        getServer().getLogger().info("StaffParty enabled!");

        registerCommands();
        registerEvents();
    }

    public void onDisable() {
        getServer().getLogger().info("StaffParty disabled!");
    }

}

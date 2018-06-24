package mc.Sh4nx.staffparty.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class randomJoke implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("randomjoke")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {


                    String jokePrefix = ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Joke " + ChatColor.DARK_GRAY + "| " + ChatColor.YELLOW;

                    int max = 12;
                    int min = 1;

                    Random randomizer = new Random();
                    int funnyJoke = min + randomizer.nextInt(max);

                    if (funnyJoke == 1) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Can a kangaroo jump higher than a house? Of course, a house dosen't jump at all.");

                    } else if (funnyJoke == 2) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Hey do people tell you that you sound like Justin Bieber? No they don't they tell me I sound like Andrew. Whos that? Me bitch.");

                    } else if (funnyJoke == 3) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Where should a 500 pound alien go? On a diet.");

                    } else if (funnyJoke == 4) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "What goes up and down but does not move? Stairs");

                    } else if (funnyJoke == 5) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Why do bicycles fall over? Because they are two-tired!");

                    } else if (funnyJoke == 6) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Why was the broom late? It over swept!");

                    } else if (funnyJoke == 7) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "What part of a car is the laziest? The wheels because they are always tired!");

                    } else if (funnyJoke == 8) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Why don't traffic lights go swimming? Because they take to long to change!");

                    } else if (funnyJoke == 9) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Why did the policeman smell bad? He was on DUTY!!!!");

                    } else if (funnyJoke == 10) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "Why can't you hear a pterodactyl in the bathroom? Because it has a silent pee!");

                    } else if (funnyJoke == 11) {

                        Bukkit.getServer().broadcastMessage(jokePrefix + "What kind of bees make milk instead of honey? Boobies!");

                    } else {
                        Bukkit.getServer().broadcastMessage(jokePrefix + "What dog keeps the best time? A watch dog!");
                    }


                } else {
                    p.sendMessage(ChatColor.RED + "You must be admin or higher!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player!");
            }
        }
        return false;
    }

}

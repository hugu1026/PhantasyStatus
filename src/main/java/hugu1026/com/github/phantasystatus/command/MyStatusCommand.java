package hugu1026.com.github.phantasystatus.command;

import hugu1026.com.github.phantasystatus.PhantasyStatus;
import hugu1026.com.github.phantasystatus.util.PlayerDataUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MyStatusCommand implements CommandExecutor{
    private final PhantasyStatus plg;

    public MyStatusCommand(PhantasyStatus plg) {
        this.plg = plg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(cmd.getName().equalsIgnoreCase("myst")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                FileConfiguration playerData = PlayerDataUtil.getPlayerData(player);

                int level = playerData.getInt("status.level");
                int totalExp = playerData.getInt("status.totalExp");
                int reqExp = playerData.getInt("status.reqExp");
                int HP = playerData.getInt("status.HP");
                int maxHP = playerData.getInt("point.health") * 2 + 20;
                int attack = playerData.getInt("status.attack");
                int defend = playerData.getInt("status.defend");
                int magic = playerData.getInt("status.magic");

                player.sendMessage(ChatColor.GOLD + "----------ステータス----------");
                player.sendMessage(ChatColor.GOLD + "レベル: " + level);
                player.sendMessage(ChatColor.GOLD + "累計経験値: " + totalExp);
                player.sendMessage(ChatColor.GOLD + "次のレベルまで: " + reqExp);
                player.sendMessage(ChatColor.GOLD + "体力: " + HP + "/" + maxHP);
                player.sendMessage(ChatColor.GOLD + "攻撃力: " + attack);
                player.sendMessage(ChatColor.GOLD + "防御力: " + defend);
                player.sendMessage(ChatColor.GOLD + "魔力: " + magic);
            }
        }
        return false;
    }
}
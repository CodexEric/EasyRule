package com.ekedata.easyrule;
/**
 * Description: Manage game rules easily
 * Author: EkeData，XiaoXing365
 * Date: 2023/7/26
 * 免费开源插件请严格遵守Apache协议
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ekedata.easyrule.cmds.MainCmd;
import com.ekedata.easyrule.cmds.Tab;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyRule extends JavaPlugin implements CommandExecutor, TabCompleter {

    private EasyRule instance;

    public EasyRule getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // 注册指令执行器和TAB补全
        Objects.requireNonNull(getCommand("easyrule")).setExecutor(new MainCmd());
        Objects.requireNonNull(getCommand("easyrule")).setTabCompleter(new Tab());

        String newTextColorTest = NamedTextColor.AQUA+"新颜色组件测试";
        Bukkit.getConsoleSender().sendMessage(newTextColorTest);

        // 插件成功加载提示信息
        Bukkit.getConsoleSender().sendMessage("§a插件加载成功！");
        Bukkit.getConsoleSender().sendMessage("§b作者: EkeData，XiaoXing365");
        //getLogger().info();
    }

    @Override
    //关闭服务器时输出的内容或者命令
    public void onDisable() {

        // 发送卸载的提示消息（红色）
        Bukkit.getConsoleSender().sendMessage("§a插件已卸载！");
        //getLogger().info("§c插件已卸载！");
    }

}

package xyz._404_labs.subcommand;

import org.bukkit.plugin.java.JavaPlugin;
import xyz._404_labs.subcommand.command.TestCommand;

public class SubCommandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new TestCommand());
    }

}

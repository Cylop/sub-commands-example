package xyz._404_labs.subcommand.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

abstract class AbstractCommand {

    protected AbstractCommand() {
        this.commands = new HashMap<>();
    }

    private CommandSender commandSender;
    private Command command;
    private String label;
    private String[] args;
    private HashMap<String, CommandExecutor> commands;

    protected void initialize(CommandSender commandSender, Command command, String label, String[] args) {
        this.commandSender = commandSender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    protected void registerSubExecutor(String name, CommandExecutor commandInterface) {
        this.commands.put(name, commandInterface);
    }

    protected boolean matchSubCommand() {
        CommandExecutor subCommand = this.commands.get(args[0]);
        if (null != subCommand) {
            List<String> list = new ArrayList<>(Arrays.asList(this.args));
            list.remove(0);

            return subCommand.onCommand(this.commandSender, this.command, this.label, list.toArray(this.args));
        }

        return false;
    }

}

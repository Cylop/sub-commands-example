package xyz._404_labs.subcommand.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz._404_labs.subcommand.command.sub.TestEchoCommand;
import xyz._404_labs.subcommand.command.sub.TestWriteCommand;

public class TestCommand extends AbstractCommand implements CommandExecutor {

    public TestCommand() {
        this.registerSubExecutor("write", new TestWriteCommand());
        this.registerSubExecutor("echo", new TestEchoCommand());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length > 0) {
            this.initialize(commandSender, command, label, args);

            return this.matchSubCommand();
        } else {
            // execute default command
            commandSender.sendMessage("TestCommand");
        }

        return true;
    }

}

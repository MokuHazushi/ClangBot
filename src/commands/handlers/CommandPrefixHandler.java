package commands.handlers;

import commands.CommandListener;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Bastien Rigault
 */
public class CommandPrefixHandler extends Handler {
    
    private final CommandListener cmdListener;

    public CommandPrefixHandler(CommandListener cmdListener) {
        this.cmdListener = cmdListener;
    }

    @Override
    public void handleCommand(MessageReceivedEvent event, String cmd) {
        String args[] = cmd.split(" ");
        String prefix;
        
        if (args.length != 2)
            return; //TODO FALSE RETURN
        
        prefix = args[1];        
        cmdListener.setCommandPrefix(prefix);
        
        //Send feedback
        MessageChannel channel = event.getChannel();
        channel.sendMessage("New prefix is set to "+cmdListener.getCommandPrefix()).complete();
    }

    @Override
    public String commandPrefix() {
        return "prefix";
    }

}

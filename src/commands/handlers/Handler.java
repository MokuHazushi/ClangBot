package commands.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Bastien Rigault
 */
public abstract class Handler {
     
    public boolean isHandledCommand(String cmd) {
        return cmd.startsWith(commandPrefix());
    }
    
    public abstract void handleCommand(MessageReceivedEvent event, String cmd);
    public abstract String commandPrefix();
    
}

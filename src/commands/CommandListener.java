package commands;

import commands.handlers.CommandPrefixHandler;
import commands.handlers.Handler;
import commands.handlers.WaifuHandler;
import java.util.ArrayList;
import java.util.List;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author Bastien Rigault
 */
public class CommandListener extends ListenerAdapter {
    
    private List<Handler> handlers;
    private String commandPrefix = "!clang ";
    
    public CommandListener() {
        handlers = new ArrayList<>();
        handlers.add(new WaifuHandler());
        handlers.add(new CommandPrefixHandler(this));
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String rawContent = event.getMessage().getRawContent();
        String command;
        
        
        if (!rawContent.startsWith(commandPrefix))
            return;
        
        command = rawContent.substring(commandPrefix.length());
        for (Handler handler : handlers) {
            if (handler.isHandledCommand(command))
                handler.handleCommand(event, command);
        }
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }  

}

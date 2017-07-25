package commands.handlers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Bastien Rigault
 */
public class WaifuHandler extends Handler {

    @Override
    public void handleCommand(MessageReceivedEvent event, String cmd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String commandPrefix() {
        return "waifu";
    }

}

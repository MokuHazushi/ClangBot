package main;

import javax.security.auth.login.LoginException;
import commands.CommandListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 * @author Bastien Rigault
 */
public class Starter {
    
    public static JDA jda;
    
    //BOT ATTRIBUTES
    private static final String BOT_TOKEN = "MjQ4MTE3NTMxMDk1NzI4MTI5.Cw3O3w.SVRCiGJe6V2RnwdZ4rKGF3fFSqo";
    public static final String BOT_ID = "248117531095728129";
    public static final String BOT_NAME = "Clang-bot";
    
    //LISTENERS
    
    public static void main(String[] args) {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(BOT_TOKEN)
                    .addEventListener(new CommandListener())
                    .buildBlocking();
        }
        catch (LoginException le) {
            le.printStackTrace();
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        catch (RateLimitedException rle) {
            rle.printStackTrace();
        }
    }

}

package main;

import javax.security.auth.login.LoginException;
import commands.CommandListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private static String BOT_TOKEN;
    private static String BOT_ID;
    private static String BOT_NAME;
    private final String CONFIG_FILE = "config/bot.config";

    public Starter() {
        loadBotConfig();
        System.out.println("Bot configuration loaded"
                + "\nBOT_TOKEN="+BOT_TOKEN
                + "\nBOT_ID="+BOT_ID
                + "\nBOT_NAME="+BOT_NAME);
    }
    
    private void loadBotConfig() {
        File configFile = new File(CONFIG_FILE);
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(configFile));
            
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("token=")) 
                    BOT_TOKEN = line.substring(line.indexOf('=')+1);
                
                if (line.startsWith("id="))
                    BOT_ID = line.substring(line.indexOf('=')+1);
                
                if (line.startsWith("name="))
                    BOT_NAME = line.substring(line.indexOf('=')+1);
            }
            br.close();
        }
        catch (FileNotFoundException ffe) {
            System.err.println("Error while loading bot configuration file "+CONFIG_FILE);
            ffe.printStackTrace();
        }
        catch (IOException ioe) {
            System.err.println("Error while reading bot configuration file "+CONFIG_FILE);
            ioe.printStackTrace();
        }
    }

    public static String getBOT_ID() {
        return BOT_ID;
    }

    public static String getBOT_NAME() {
        return BOT_NAME;
    }
    
    public static void main(String[] args) {
        new Starter();
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

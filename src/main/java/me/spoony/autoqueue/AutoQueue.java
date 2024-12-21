package me.spoony.autoqueue;

import cc.polyfrost.oneconfig.events.EventManager;
import me.spoony.autoqueue.command.ConfigCommand;
import me.spoony.autoqueue.command.QueueTrigger;
import me.spoony.autoqueue.config.ModConfig;
import me.spoony.autoqueue.listener.ChatListener;
import me.spoony.autoqueue.retrievers.LocrawGamesHandler;
import me.spoony.autoqueue.retrievers.LocrawRetriever;
import me.spoony.autoqueue.retrievers.trigger.TriggersRetriever;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = AutoQueue.MODID, name = AutoQueue.NAME, version = AutoQueue.VERSION)
public class AutoQueue {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static AutoQueue INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static ModConfig config;
    public static final Logger LOGGER = LogManager.getLogger(AutoQueue.class);

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ModConfig();
        CommandManager.INSTANCE.registerCommand(new ConfigCommand());
        CommandManager.INSTANCE.registerCommand(new QueueTrigger());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ChatListener());
        new Thread(new TriggersRetriever()).start();
        EventManager.INSTANCE.register(new LocrawRetriever());
        LocrawGamesHandler.INSTANCE.initialize();
    }
}

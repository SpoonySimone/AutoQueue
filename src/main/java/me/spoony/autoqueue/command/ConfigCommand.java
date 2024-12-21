package me.spoony.autoqueue.command;

import me.spoony.autoqueue.AutoQueue;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = AutoQueue.MODID, description = "Access the " + AutoQueue.NAME + " GUI.")
public class ConfigCommand {
    @Main
    private void handle() {
        AutoQueue.config.openGui();
    }
}
package me.spoony.command;

import me.spoony.AutoQueue;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = AutoQueue.MODID, description = "Access the " + AutoQueue.NAME + " GUI.")
public class ConfigCommand {
    @Main
    private void handle() {
        AutoQueue.config.openGui();
    }
}
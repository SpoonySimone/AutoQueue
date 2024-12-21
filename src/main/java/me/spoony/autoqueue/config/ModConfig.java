package me.spoony.autoqueue.config;

import cc.polyfrost.oneconfig.config.annotations.Info;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.data.InfoType;
import me.spoony.autoqueue.AutoQueue;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class ModConfig extends Config {

    @Info(
            text = "The mod will only work if you're actually playing",
            subcategory = "General",
            size = 2,
            type = InfoType.WARNING // Types are: INFO, WARNING, ERROR, SUCCESS
    )
    public static boolean ignored;

    @Switch(
            name = "Enable",
            subcategory = "General",
            description = "Enable/disable the mod"
    )
    public static boolean ModEnabled = true;

    @Info(
            text = "When set to 0, Hypixel won't count progress towards quests. Enable quests progress fix to use a workaround.",
            subcategory = "Delay",
            size = 2,
            type = InfoType.ERROR // Types are: INFO, WARNING, ERROR, SUCCESS
    )
    public static boolean noProgressWarning;

    @Slider(
            name = "Delay",
            subcategory = "Delay",
            description = "What should the delay before queuing be?",
            min = 0, max = 10,
            step = 1
    )
    public static int delay = 1;

    @Info(
            text = "The switch below will make it so that if delay is set to 0, it'll actually wait for 250ms so that Hypixel can register progress.",
            subcategory = "Delay",
            size = 2,
            type = InfoType.INFO // Types are: INFO, WARNING, ERROR, SUCCESS
    )
    public static boolean questsFixWarning;

    @Switch(
            name = "Quests progress fix",
            subcategory = "Delay",
            description = "Whether enable the quests workaround or not."
    )
    public static boolean questsFix = true;

    @Switch(
            name = "Debug",
            subcategory = "Utilities",
            description = "Enable/disable mod debugging features. Leave off unless you know what you're doing."
    )
    public static boolean debug = true;

    public ModConfig() {
        super(new Mod(AutoQueue.NAME, ModType.UTIL_QOL), AutoQueue.MODID + ".json");
        initialize();
    }
}


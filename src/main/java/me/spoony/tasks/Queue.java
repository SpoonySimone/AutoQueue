package me.spoony.tasks;

import me.spoony.config.ModConfig;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

import java.util.Timer;
import java.util.TimerTask;

public class Queue {
    private static final Minecraft mc = Minecraft.getMinecraft();
    public static int zeroDelay = 0;

    public Queue(String locraw, int delay) {
        if (Display.isActive() && ModConfig.ModEnabled) {
            if (ModConfig.questsFix) {
                if (ModConfig.delay == 0) {
                    zeroDelay = 250;
                } else {
                    zeroDelay = 0;
                }
            }
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mc.thePlayer.sendChatMessage("/play " + locraw);
                }
            }, delay * 1000L + zeroDelay);
        }
    }
}

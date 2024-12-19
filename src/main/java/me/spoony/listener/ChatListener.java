package me.spoony.listener;

import me.spoony.AutoQueue;
import me.spoony.config.ModConfig;
import me.spoony.retrievers.LocrawRetriever;
import me.spoony.retrievers.trigger.TriggersRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.spoony.tasks.Queue;
import org.lwjgl.opengl.Display;

import java.util.List;
import java.util.regex.Pattern;

public class ChatListener {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        if (ModConfig.debug || Display.isActive()) {
            AutoQueue.LOGGER.info("Current location: " + LocrawRetriever.game);
            mc.thePlayer.addChatMessage(new ChatComponentText("Current location: " + LocrawRetriever.game));
        }

        if (event.type == 2) return; // no action bar

        String strippedMessage = EnumChatFormatting.getTextWithoutFormattingCodes(event.message.getUnformattedText());
        List<Pattern> patterns = TriggersRetriever.getCompiledPatterns();
        for (Pattern pattern : patterns) {
            if (pattern.matcher(strippedMessage).matches()) { //check if pattern matches
                new Queue(LocrawRetriever.game, ModConfig.delay);
                return;
            }
        }
    }
}

package me.spoony.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import me.spoony.retrievers.LocrawRetriever;
import me.spoony.tasks.Queue;

@Command(value = "queue", description = "Queue")
public class QueueTrigger {
    @Main
    private void queue() {
        new Queue(LocrawRetriever.game, 0);
    }
}

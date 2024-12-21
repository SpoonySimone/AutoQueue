package me.spoony.autoqueue.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import me.spoony.autoqueue.retrievers.LocrawRetriever;
import me.spoony.autoqueue.tasks.Queue;

@Command(value = "queue", description = "Queue")
public class QueueTrigger {
    @Main
    private void queue() {
        new Queue(LocrawRetriever.game, 0);
    }
}

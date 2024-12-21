package me.spoony.autoqueue.retrievers;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.LocrawEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawInfo;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawUtil;

public class LocrawRetriever {
    public static String game = "";

    public LocrawRetriever() {
        EventManager.INSTANCE.register(this);
    }

    @Subscribe
    private void onLocraw(LocrawEvent event) {
        LocrawInfo locraw = LocrawUtil.INSTANCE.getLocrawInfo();
        LocrawInfo lastLocraw = LocrawUtil.INSTANCE.getLastLocrawInfo();

        if (!HypixelUtils.INSTANCE.isHypixel() || locraw == null) {
            return;
        }

        if (LocrawUtil.INSTANCE.isInGame()) {
            game = locraw.getGameMode();
            switch (locraw.getGameType()) {
                case SKYBLOCK:
                case HOUSING:
                case REPLAY:
                    return;
            }
        } else if (!LocrawUtil.INSTANCE.isInGame() && locraw.getGameMode().equals("lobby") && lastLocraw != null) {
            game = lastLocraw.getGameMode();
            switch (lastLocraw.getGameType()) {
                case SKYBLOCK:
                case HOUSING:
                case REPLAY:
                    return;
            }
        } else {
            return;
        }

        String value = LocrawGamesHandler.locrawGames.get(locraw.getRawGameType().toLowerCase() + "_" + game.toLowerCase());
        if (value != null) {
            game = value;
        }
    }
}
package me.spoony.autoqueue.retrievers;

import cc.polyfrost.oneconfig.utils.Multithreading;
import cc.polyfrost.oneconfig.utils.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import me.spoony.autoqueue.AutoQueue;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

//code taken from Hytils Reborn https://github.com/Polyfrost/Hytils-Reborn/blob/master/src/main/java/org/polyfrost/hytils/command/RequeueCommand.java
public class LocrawGamesHandler {
    public static LocrawGamesHandler INSTANCE = new LocrawGamesHandler();
    public static Map<String, String> locrawGames = new HashMap<>();

    public void initialize() {
        Multithreading.runAsync(() -> {
            try {
                String url = "https://data.woverflow.cc/locraw_games.json";
                String content = NetworkUtils.getString(url);
                Type stringStringMap = new TypeToken<HashMap<String, String>>() {
                }.getType();
                locrawGames = new Gson().fromJson(content, stringStringMap);
                AutoQueue.LOGGER.info("locrawGames map populated: " + locrawGames);
            } catch (JsonSyntaxException e) {
                AutoQueue.LOGGER.error("Failed to fetch locraw_games list.", e);
            }
        });
    }
}

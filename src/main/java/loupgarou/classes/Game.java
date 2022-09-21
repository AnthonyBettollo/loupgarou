package loupgarou.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;
import loupgarou.classes.roles.LGRole;
import loupgarou.classes.roles.RolesConfig;

public class Game {
    @Getter
    private static ArrayList<LGPlayer> lgPlayers = new ArrayList<>();

    @Getter
    private static ArrayList<LGRole> roles = new ArrayList<>();

    @Getter
    private static boolean started;
    @Getter
    private static int night = 0;
    @Getter
    private static boolean day;

    public static void start(List<Player> players, List<Location> spawnList, List<RolesConfig> roles) {
        Collections.shuffle(roles);
        int indexRole = 0;
        for (Player player : players) {
            lgPlayers.add(new LGPlayer(player, roles.get(indexRole)));
            player.teleport(spawnList.get(indexRole));
            indexRole++;
        }
        started = true;
    }
}

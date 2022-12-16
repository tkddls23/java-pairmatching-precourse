package pairmatching.domain;

import pairmatching.constant.Level;
import pairmatching.constant.Mission;

import java.util.*;
import java.util.stream.Collectors;

public class Missions {
    private static Map<Level, List<Mission>> missions;

    public Missions() {
        missions = new HashMap<>();
        init();
    }

    private void init() {
        Level.getList().stream()
                .forEach(level -> missions.put(level, new ArrayList<>()));
        addInfo();
    }

    private void addInfo() {
        missions.get(Level.LEVEL1).add(Mission.CAR_RACE);
        missions.get(Level.LEVEL1).add(Mission.LOTTO);
        missions.get(Level.LEVEL1).add(Mission.BASEBALL);

        missions.get(Level.LEVEL2).add(Mission.BASCKET);
        missions.get(Level.LEVEL2).add(Mission.PAY);
        missions.get(Level.LEVEL2).add(Mission.SUBWAY);

        missions.get(Level.LEVEL4).add(Mission.IMPROVE_PERFORMANCE);
        missions.get(Level.LEVEL4).add(Mission.DEPLOYMENT);
    }

    public List<String> getMissionsByLevel(Level level) {
        return Collections.unmodifiableList(missions.get(level).stream()
                .map(Mission::getName)
                .collect(Collectors.toList()));
    }

    public boolean isExist(String level, String mission) {
        if (missions.get(Level.getEnumLevel(level))
                .contains(Mission.getEnumMission(mission))) {
            return true;
        }
        return false;
    }
}

package pairmatching.constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Mission {
    CAR_RACE("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASCKET("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    IMPROVE_PERFORMANCE("성능개선"),
    DEPLOYMENT("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Mission getEnumMission(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }

}
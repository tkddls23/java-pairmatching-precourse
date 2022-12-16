package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Course;

import java.util.ArrayList;
import java.util.List;

public class PairMatching {

    private List<String> shuffledCrew;
    private Crew crew;
    private List<List<String>> pair;
    private List<List<List<String>>> matchInfoList = new ArrayList<>();

    public PairMatching(List<String> matchingInfo) {
        init();
    }

    public void init() {
        shuffledCrew = new ArrayList<>();
    }

    public void addMatchInfo(List<String> matchingInfo) {
        matchInfoList.add(matchPair(matchingInfo));
    }

    public List<List<String>> matchPair(List<String> matchingInfo) {
        pair = new ArrayList<>();
        Course course = Course.getEnumCourse(matchingInfo.get(0));
        shuffledCrew = Randoms.shuffle(crew.getCrew(course));
        int index = 0;
        while (shuffledCrew.size() != index) {
            List<String> onePair = new ArrayList<>();
            onePair.add(shuffledCrew.get(index++));
            onePair.add(shuffledCrew.get(index++));
            if (index == shuffledCrew.size() - 1) {
                onePair.add(shuffledCrew.get(index++));
            }
            pair.add(onePair);
        }
        return pair;
    }
}

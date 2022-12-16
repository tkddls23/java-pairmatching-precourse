package pairmatching.validation;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Missions;
import pairmatching.constant.Pair;

import java.util.Arrays;
import java.util.List;

import static pairmatching.constant.ErrorConstant.*;
import static pairmatching.constant.MessageConstant.*;

public class InputViewValidation {

    public static void checkOptionValid(String option) {
        if (!option.equals(Pair.MATCHING.getType()) && !option.equals(Pair.LOOKUP.getType()) && !option.equals(Pair.INIT.getType()) && !option.equals(Pair.EXIT.getType())) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_INPUT);
        }
    }

    public static void checkReMatchCommandValid(String reMatchCommand) {
        if (!reMatchCommand.equals(MESSAGE_YES) && !reMatchCommand.equals(MESSAGE_NO)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_INPUT);
        }
    }

    public static List<String> checkMatchingInputValid(String matchingInput) {
        String[] matchingInfo = matchingInput.split(",");
        checkMatchingInfoCount(matchingInfo);
        return checkEachMatchingInfo(matchingInfo);
    }

    private static void checkMatchingInfoCount(String[] matchingInfo) {
        if (matchingInfo.length != 3) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_INPUT_COUNT);
        }
    }

    private static List<String> checkEachMatchingInfo(String[] matchingInfo) {
        String course = checkCourseInfo(matchingInfo[0]);
        String level = checkLevelInfo(matchingInfo[1]);
        String mission = checkMissionInfo(matchingInfo[1], matchingInfo[2]);
        return Arrays.asList(course, level, mission);
    }
    private static String checkCourseInfo(String courseInfo) {
        if (!Course.isExist(courseInfo)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COURSE);
        }
        return courseInfo;
    }
    private static String checkLevelInfo(String levelInfo) {
        checkFrontBlank(levelInfo.charAt(0));
        String levelValue = levelInfo.substring(1);
        if (!Level.isExist(levelValue)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_LEVEL);
        }
        return levelValue;
    }
    private static String checkMissionInfo(String levelInfo, String missionInfo) {
        checkFrontBlank(missionInfo.charAt(0));
        Missions missions = new Missions();
        if (!missions.isExist(levelInfo.substring(1), missionInfo.substring(1))) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MISSION);
        }
        return missionInfo.substring(1);
    }

    private static void checkFrontBlank(char infoValue) {
        if (infoValue != BLANK) {
            throw new IllegalArgumentException(ERROR_NON_BLANK);
        }
    }

}

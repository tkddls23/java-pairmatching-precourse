package pairmatching.validation;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Missions;
import pairmatching.constant.Pair;

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

    public static void checkMatchingInputValid(String matchingInput) {
        String[] matchingInfo = matchingInput.split(",");
        checkMatchingInfoCount(matchingInfo);
        checkEachMatchingInfo(matchingInfo);
    }

    private static void checkMatchingInfoCount(String[] matchingInfo) {
        if (matchingInfo.length != 3) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_INPUT_COUNT);
        }
    }

    private static void checkEachMatchingInfo(String[] matchingInfo) {
        checkCourseInfo(matchingInfo[0]);
        checkLevelInfo(matchingInfo[1]);
        checkMissionInfo(matchingInfo[1], matchingInfo[2]);
    }
    private static void checkCourseInfo(String courseInfo) {
        if (!Course.isExist(courseInfo)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COURSE);
        }
    }
    private static void checkLevelInfo(String levelInfo) {
        checkFrontBlank(levelInfo.charAt(0));
        if (!Level.isExist(levelInfo.substring(1))) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_LEVEL);
        }
    }
    private static void checkMissionInfo(String levelInfo, String missionInfo) {
        checkFrontBlank(missionInfo.charAt(0));
        Missions missions = new Missions();
        if (missions.isExist(levelInfo.substring(1), missionInfo.substring(1))) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MISSION);
        }
    }

    private static void checkFrontBlank(char infoValue) {
        if (infoValue != BLANK) {
            throw new IllegalArgumentException(ERROR_NON_BLANK);
        }
    }

}

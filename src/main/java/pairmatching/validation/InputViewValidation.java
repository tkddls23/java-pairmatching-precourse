package pairmatching.validation;

import pairmatching.constant.Pair;

import static pairmatching.constant.ErrorConstant.ERROR_NOT_VALID_INPUT;
import static pairmatching.constant.MessageConstant.MESSAGE_NO;
import static pairmatching.constant.MessageConstant.MESSAGE_YES;

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

}

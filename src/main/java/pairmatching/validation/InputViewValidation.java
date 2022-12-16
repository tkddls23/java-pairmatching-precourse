package pairmatching.validation;

import pairmatching.constant.Pair;

import static pairmatching.constant.ErrorConstant.ERROR_NOT_VALID_INPUT;

public class InputViewValidation {

    public static void checkInputValid(String input) {
        if (input.equals(Pair.MATCHING.getType()) && input.equals(Pair.LOOKUP.getType()) && input.equals(Pair.INIT.getType()) && input.equals(Pair.EXIT.getType())) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_INPUT);
        }
    }
}

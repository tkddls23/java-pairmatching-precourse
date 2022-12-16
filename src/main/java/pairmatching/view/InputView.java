package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validation.InputViewValidation;

import static pairmatching.constant.MessageConstant.*;

public class InputView {

    /**
     * 기능을 입력받는다.
     */
    public String readOption() {
        System.out.println(MESSAGE_INPUT_FUNCTION);

        String option = Console.readLine();
        InputViewValidation.checkOptionValid(option);
        return option;
    }

    /**
     * 과정,레벨,미션을 입력받는다.
     */
    public String readMatchingInfo() {
        System.out.println(MESSAGE_INPUT_INFO);
        String matchingInfo = Console.readLine();
//        InputViewValidation.checkMatchingInfoValid(matchingInfo);
        return matchingInfo;
    }

    /**
     * 사용자가 매칭을 다시 시도할지 안할지 여부를 입력받는다.
     */
    public String readReMatchCommand() {
        System.out.println(MESSAGE_INPUT_REMATCH);
        String reMatchCommand = Console.readLine();
        InputViewValidation.checkReMatchCommandValid(reMatchCommand);
        return reMatchCommand;
    }
}

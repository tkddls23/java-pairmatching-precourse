package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.constant.MessageConstant.MESSAGE_INPUT_FUNCTION;

public class InputView {

    /**
     * 기능을 입력받는다.
     */
    public String readOption() {
        System.out.println(MESSAGE_INPUT_FUNCTION);

        String input = Console.readLine();

        return input;
    }
}

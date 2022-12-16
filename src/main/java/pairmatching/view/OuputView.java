package pairmatching.view;

import static pairmatching.constant.MessageConstant.MESSAGE_OUTPUT_INIT;
import static pairmatching.constant.MessageConstant.MESSAGE_OUTPUT_RESULT;

public class OuputView {

    /**
     * 페어 매칭 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printPairResult() {
        System.out.println(MESSAGE_OUTPUT_RESULT);
    }


    /**
     * 페어 매칭 초기화를 출력한다.
     */
    public void printPairInit() {
        System.out.println(MESSAGE_OUTPUT_INIT);
    }

}

package pairmatching.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static pairmatching.constant.ErrorConstant.ERROR_NOT_VALID_INPUT;

class InputViewValidationTest {

    @DisplayName("예외 처리 : 기능입력값이 올바르지 않을때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","h","4", "", " "})
    void checkInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkOptionValid(input))
                .withMessageStartingWith(ERROR_NOT_VALID_INPUT);
    }

    @DisplayName("예외 처리 : 재매칭 여부 입력값이 올바르지 않을때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","네니오","", " "})
    void checkReMatchCommandValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkReMatchCommandValid(input))
                .withMessageStartingWith(ERROR_NOT_VALID_INPUT);
    }

    @DisplayName("예외 처리 : 매칭 정보 입력값이 올바르지 않을때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"백엔드, 레벨1, 자동차경주 ","백엔드, 레벨1","", " ", "프론트, 레벨3, 자동차경주"})
    void checkMatchingInfoValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkMatchingInputValid(input));
    }

}
package pairmatching.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static pairmatching.constant.ErrorConstant.ERROR_NOT_VALID_INPUT;

class InputViewValidationTest {

    @DisplayName("예외 처리 : 입력값이 올바르지 않을때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","h","4", "", " "})
    void checkNotValidDigitInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkInputValid(input))
                .withMessageStartingWith(ERROR_NOT_VALID_INPUT);
    }
}
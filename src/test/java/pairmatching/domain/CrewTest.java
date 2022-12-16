package pairmatching.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewTest {

    @DisplayName("예외 처리 : 크루정보를 잘 받아오는지 검증")
    @Test
    void checkReaderCrews() {
        Crew crew = new Crew();
        List<String> backendCrews = crew.getCrew(Course.BACKEND);
        List<String> frontendCrews = crew.getCrew(Course.FRONTEND);

        assertThat(backendCrews).isEqualTo(Arrays.asList("백호",
                "태웅",
                "치수",
                "태섭",
                "대만",
                "준호",
                "대협",
                "덕규",
                "태산",
                "경태",
                "수겸",
                "현준",
                "준섭",
                "한나",
                "소연",
                "호열",
                "대남",
                "용팔",
                "구식",
                "달재"));
    }
}
package pairmatching.constant;

public enum Pair {
    MATCHING("1"),
    LOOKUP("2"),
    INIT("3"),
    EXIT("Q");

    private String type;

    Pair(String type) {
        this.type = type;
    }

    // 추가 기능 구현

    public String getType() {
        return type;
    }
}

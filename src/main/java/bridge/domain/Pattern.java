package bridge.domain;

public enum Pattern {
  O("O"),
  X("X"),
  None(" ");

  private final String value;

  Pattern(final String value) {
    this.value = value;
  }

  public static Pattern of(final String value) {
    if ("O".equals(value)) {
      return O;
    }
    if ("X".equals(value)) {
      return X;
    }
    throw new IllegalArgumentException("Pattern은 반드시 O | X 중 하나를 입력해야 합니다.");
  }

  public String getValue() {
    return value;
  }
}

package bridge.domain;

public enum Position {
  UP("U"),
  DOWN("D");

  private final String value;

  Position(final String value) {
    this.value = value;
  }

  public static Position of(final String value) {
    if ("U".equals(value)) {
      return UP;
    }
    if ("D".equals(value)) {
      return DOWN;
    }
    throw new IllegalArgumentException("Position은 반드시 U | D 중 하나를 입력해야 합니다.");
  }

  public String getValue() {
    return value;
  }
}

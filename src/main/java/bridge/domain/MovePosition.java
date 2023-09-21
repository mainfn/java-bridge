package bridge.domain;

public enum MovePosition {
  UP("U"),
  DOWN("D");

  private final String value;

  MovePosition(final String value) {
    this.value = value;
  }

  public static MovePosition of(final String value) {
    if ("U".equals(value)) {
      return UP;
    }
    if ("D".equals(value)) {
      return DOWN;
    }

    throw new IllegalArgumentException("U | D 중 하나만 선택 가능합니다.");
  }
}

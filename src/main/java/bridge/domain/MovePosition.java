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
      return MovePosition.UP;
    }
    if ("D".equals(value)) {
      return MovePosition.DOWN;
    }
    throw new IllegalArgumentException("MovePosition only can accept `U` or `D`");
  }

  public String getValue() {
    return value;
  }

}
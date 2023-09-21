package bridge.domain;

public enum GameCommand {
  R("R"),
  Q("Q");

  private final String command;

  GameCommand(final String command) {
    this.command = command;
  }

  public static GameCommand of(final String command) {
    if ("R".equals(command)) {
      return R;
    }
    if ("Q".equals(command)) {
      return Q;
    }
    throw new IllegalArgumentException("유효하지 않은 명령어를 입력하셨습니다.");
  }
}

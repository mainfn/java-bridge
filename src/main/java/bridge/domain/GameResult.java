package bridge.domain;

public final class GameResult {

  private final MoveRecords moveRecords;
  private final GameStatus status;
  private final int attemptCount;

  private GameResult(
      final MoveRecords moveRecords,
      final int attemptCount,
      final GameStatus status
  ) {
    this.moveRecords = moveRecords;
    this.attemptCount = attemptCount;
    this.status = status;
  }

  public static GameResult of(
      final MoveRecords moveRecords,
      final int attemptCount,
      final GameStatus status
  ) {
    return new GameResult(
        moveRecords,
        attemptCount,
        status);
  }

  @Override
  public String toString() {
    return "최종 게임 결과\n"
        + moveRecords.toString()
        + "\n"
        + "게임 성공 여부: " + status.getStatus() + "\n"
        + "총 시도한 횟수: " + attemptCount;
  }
}

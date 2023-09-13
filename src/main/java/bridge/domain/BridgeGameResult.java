package bridge.domain;

public final class BridgeGameResult {

  private final int attemptCount;
  private final boolean isFailed;
  private final MoveRecords moveRecords;

  private BridgeGameResult(
      final int attemptCount,
      final boolean isFailed,
      final MoveRecords moveRecords
  ) {
    this.attemptCount = attemptCount;
    this.isFailed = isFailed;
    this.moveRecords = moveRecords;
  }

  public static BridgeGameResult of(
      final int count,
      final boolean isFailed,
      final MoveRecords moveRecords
  ) {
    return new BridgeGameResult(count, isFailed, moveRecords);
  }

  @Override
  public String toString() {

    return "최종 게임 결과\n"
        + moveRecords.toString()
        + "\n\n"
        + "게임 성공 여부: " + getResultState() + "\n"
        + "총 시도한 횟수: " + attemptCount;
  }

  private String getResultState() {
    if (isFailed) {
      return "실패";
    }
    return "성공";
  }


}
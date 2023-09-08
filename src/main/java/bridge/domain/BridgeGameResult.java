package bridge.domain;

public final class BridgeGameResult {

  private final int tryCount;
  private final String renderedString;
  private final String succeedString;

  public BridgeGameResult(
      final int tryCount,
      final String renderedString,
      final boolean hasError
  ) {
    this.tryCount = tryCount;
    this.renderedString = renderedString;
    this.succeedString = makeSucceedString(hasError);
  }

  private String makeSucceedString(final boolean hasError) {
    if (hasError) {
      return "실패";
    }
    return "성공";
  }

  @Override
  public String toString() {
    return "최종 게임 결과\n"
        + renderedString + "\n"
        + "게임 성공 여부: " + succeedString + "\n"
        + "총 시도한 횟수: " + tryCount;
  }
}

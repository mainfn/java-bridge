package bridge.domain;

public final class BridgeGame {

  // 다리 상의 모든 칸의 이동할 수 있는 MovePosition 저장
  private final BridgeMap bridgeMap;

  // 이동 기록을 MoveRecord("O", "X", " ") List로 저장
  private MoveRecords moveRecords;

  // 시도 횟수
  private int attemptCount = 1;

  private int nextIndexAtBridge = 0;

  private BridgeGameStatus status = BridgeGameStatus.PLAYING;

  // 생성자
  private BridgeGame(final BridgeMap bridgeMap) {
    this.bridgeMap = bridgeMap;
    this.moveRecords = MoveRecords.create();
  }

  // 정적 팩토리 메소드
  public static BridgeGame of(final BridgeMap bridgeMap) {
    return new BridgeGame(bridgeMap);
  }

  public boolean isPlaying() {
    return status.equals(BridgeGameStatus.PLAYING);
  }

  public MoveRecords getMoveRecords() {
    return moveRecords;
  }

  public boolean isFailed() {
    return status.equals(BridgeGameStatus.FAILURE);
  }

  private MoveRecord getNextMoveRecord(final MovePosition movePosition) {
    if (bridgeMap.isSameMovePositionAt(nextIndexAtBridge, movePosition)) {
      return MoveRecord.O;
    }
    return MoveRecord.X;
  }

  public void move(final MovePosition movePosition) {
    final MoveRecord nextMoveRecord = getNextMoveRecord(movePosition);

    if (bridgeMap.isEndOfBridge(nextIndexAtBridge++)) {
      status = BridgeGameStatus.CLEAR;
    }

    if (MoveRecord.X.equals(nextMoveRecord)) {
      status = BridgeGameStatus.FAILURE;
    }

    moveRecords.record(movePosition, nextMoveRecord);
  }

  public void retry() {
    moveRecords = MoveRecords.create();
    nextIndexAtBridge = 0;
    status = BridgeGameStatus.PLAYING;
    attemptCount++;
  }

  public BridgeGameResult getGameResult() {
    return BridgeGameResult.of(
        attemptCount,
        isFailed(),
        moveRecords
    );
  }


}
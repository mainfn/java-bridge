package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public final class BridgeGame {

  // Move
  // 맞는 움직임인지 확인 -> BridgeMap
  // 결과 기록         -> GameResult
  private final BridgeMap bridgeMap;
  private MoveRecords moveRecords;
  private GameStatus status = GameStatus.PROGRESS;

  private int attemptCount = 1;


  private BridgeGame(
      final BridgeMap bridgeMap,
      final MoveRecords moveRecords
  ) {
    this.bridgeMap = bridgeMap;
    this.moveRecords = moveRecords;
  }

  public static BridgeGame of(final BridgeMap bridgeMap) {
    return new BridgeGame(bridgeMap, MoveRecords.empty());
  }

  public MoveRecords getMoveRecords() {
    return moveRecords;
  }

  /**
   * 사용자가 칸을 이동할 때 사용하는 메서드
   * <p>
   * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void move(final MovePosition movePosition) {

    final int nextIndex = moveRecords.getNextIndex();

    // 비교 및 결과 반환
    final MoveResult moveResult = bridgeMap.comparesAt(nextIndex, movePosition);

    // 결과 기록
    moveRecords.recordMove(moveResult);

    // 상태 변경
    status = getNextGameStatus(moveResult, nextIndex);
  }

  private GameStatus getNextGameStatus(
      final MoveResult moveResult,
      final int index
  ) {
    if (!moveResult.hasCorrectPosition()) {
      return GameStatus.FAILURE;
    }
    if (bridgeMap.isEndOfBridge(index)) {
      return GameStatus.SUCCESS;
    }
    return GameStatus.PROGRESS;
  }


  /**
   * 사용자가 게임을 다시 시도할 때 사용하는 메서드
   * <p>
   * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void retry() {
    status = GameStatus.PROGRESS;
    moveRecords = MoveRecords.empty();
    attemptCount++;
  }

  public GameStatus getStatus() {
    return status;
  }

  public boolean isPlaying() {
    return GameStatus.PROGRESS.equals(status);
  }

  public GameResult getResult() {
    return GameResult.of(moveRecords, attemptCount, status);
  }
}

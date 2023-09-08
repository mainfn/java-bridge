package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

  private final Bridge bridge;
  private final int tryCount;
  private BridgeRecord bridgeRecord;
  private int nextIndex;
  private Pattern lastPattern;
  private boolean isPlaying;

  private BridgeGame(final Bridge bridge) {
    this.bridge = bridge;
    this.bridgeRecord = BridgeRecord.withSize(bridge.getMaxSize());
    this.isPlaying = true;
    this.nextIndex = 0;
    this.tryCount = 1;
  }

  public static BridgeGame of(final Bridge bridge) {
    return new BridgeGame(bridge);
  }

  /**
   * 사용자가 칸을 이동할 때 사용하는 메서드
   * <p>
   * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void move(final Position position) {
    // bridge map의 nextIndex에 위치한 positin과 입력한 position 일치 여부 비교
    lastPattern = bridge.comparesAt(nextIndex++, position);

    // 비교 결과가 X일 경우 게임 중지
    if (Pattern.X.equals(lastPattern)) {
      isPlaying = false;
    }

    // 변경 사항 Record에 반영
    bridgeRecord.update(position, lastPattern);

    // 모든 index 순회 시 게임 종료
    if (nextIndex == bridge.getMaxSize()) {
      isPlaying = false;
    }
  }

  /**
   * 사용자가 게임을 다시 시도할 때 사용하는 메서드
   * <p>
   * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void retry() {
    bridgeRecord = BridgeRecord.withSize(bridge.getMaxSize());
    nextIndex = 0;
    isPlaying = true;
  }

  public boolean hasError() {
    return Pattern.X.equals(lastPattern);
  }

  public boolean isPlaying() {
    return isPlaying;
  }

  public String renderRecord() {
    return bridgeRecord.toString();
  }

  public BridgeGameResult getResult() {
    return new BridgeGameResult(
        tryCount,
        renderRecord(),
        hasError()
    );
  }
}

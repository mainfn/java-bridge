package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class MoveResults {

  private final List<MoveResult> patterns = new ArrayList<>();
  private final int maxPatternsLength;
  private int attemptCount = 1;

  public MoveResults(final int maxPatternsLength) {
    this.maxPatternsLength = maxPatternsLength;
  }

  // 1. 패턴 추가
  public void add(final MoveResult moveResult) {
    patterns.add(moveResult);
  }

  // 2. 재설정
  public MoveResults cloneNext() {
    final MoveResults moveResults = new MoveResults(maxPatternsLength);
    moveResults.attemptCount++;

    return moveResults;
  }

  // TODO:
  @Override
  public String toString() {
    return "MoveResult{" +
        "patterns=" + patterns +
        '}';
  }
}

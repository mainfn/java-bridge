package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class BridgeMap {

  private final List<MovePosition> positions;

  private BridgeMap(final List<MovePosition> positions) {
    this.positions = positions;
  }

  public static BridgeMap of(final List<String> bridge) {
    validateBridgeMapSize(bridge.size());

    final List<MovePosition> positions = new ArrayList<>();
    for (final String patternString : bridge) {
      positions.add(MovePosition.of(patternString));
    }

    return new BridgeMap(positions);
  }

  private static void validateBridgeMapSize(final int size) {
    if (size < 3 || size > 20) {
      throw new IllegalArgumentException("Bridge 길이는 3 이상 20 이하만 가능");
    }
  }

  // 1. 유효한 위치인지
  public MoveResult comparesAt(
      final int index,
      final MovePosition movePosition
  ) {
    final boolean isCorrectPosition = positions.get(index).equals(movePosition);
    return MoveResult.of(movePosition, isCorrectPosition);
  }

  public int getLastIndex() {
    return positions.size() - 1;
  }

  public boolean isEndOfBridge(final int index) {
    return index == positions.size() - 1;
  }

  public int getSize() {
    return positions.size();
  }
}

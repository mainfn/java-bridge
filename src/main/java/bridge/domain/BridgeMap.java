package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public final class BridgeMap {

  private final List<MovePosition> movePositions;

  private BridgeMap(final List<MovePosition> movePositions) {
    this.movePositions = movePositions;
  }

  // List<String>을 정적 팩토리 메소드의 인자로 받아서
  // List<MovePosition>으로 저장
  public static BridgeMap from(final List<String> values) {
    final List<MovePosition> movePositions = new ArrayList<>();

    for (final String value : values) {
      final MovePosition movePosition = MovePosition.of(value);
      movePositions.add(movePosition);
    }

    return new BridgeMap(movePositions);
  }

}
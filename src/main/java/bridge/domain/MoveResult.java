package bridge.domain;

import java.util.Map;

public enum MoveResult {

  // pattern, position
  UPSIDE_O("O", MovePosition.UP),
  DOWNSIDE_O("O", MovePosition.DOWN),
  UPSIDE_X("X", MovePosition.UP),
  DOWNSIDE_X("X", MovePosition.DOWN);

  private static final Map<MovePosition, Map<Boolean, MoveResult>> mp
      = Map.of(
      MovePosition.UP, Map.of(
          true, UPSIDE_O,
          false, UPSIDE_X
      ),
      MovePosition.DOWN, Map.of(
          true, DOWNSIDE_O,
          false, DOWNSIDE_X
      )
  );


  private final String pattern;
  private final MovePosition position;

  MoveResult(final String pattern, final MovePosition position) {
    this.pattern = pattern;
    this.position = position;
  }

  public static MoveResult of(
      final MovePosition position,
      final boolean isCorrectPosition
  ) {
    return mp.get(position).get(isCorrectPosition);
  }
}

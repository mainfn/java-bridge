package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class MoveRecords {

  private final List<MoveResult> records = new ArrayList<>();

  private int nextIndex = 0;

  public static MoveRecords empty() {
    return new MoveRecords();
  }

  public void recordMove(
      final MoveResult moveResult
  ) {
    records.add(moveResult);
    nextIndex++;
  }

  public int getNextIndex() {
    return nextIndex;
  }

  @Override
  public String toString() {
    final String upside = toStr(MovePosition.UP);
    final String downside = toStr(MovePosition.DOWN);

    return upside + "\n" + downside;
  }

  public String toStr(final MovePosition movePosition) {
    return "[ " + records.stream()
        .map(r -> {
          final boolean isOtherPosition = !r.getPosition().equals(movePosition);
          if (isOtherPosition) {
            return " ";
          }
          return r.getPattern();
        })
        .collect(Collectors.joining(" | "))
        + " ]";
  }
}

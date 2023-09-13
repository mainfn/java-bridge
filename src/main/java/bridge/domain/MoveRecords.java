package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class MoveRecords {

  private final Map<MovePosition, List<MoveRecord>> moveRecordsMap;

  private MoveRecords(final Map<MovePosition, List<MoveRecord>> moveRecordsMap) {
    this.moveRecordsMap = moveRecordsMap;
  }

  public static MoveRecords create() {
    final Map<MovePosition, List<MoveRecord>> movePositionsMap = new HashMap<>();
    movePositionsMap.put(MovePosition.UP, new ArrayList<>());
    movePositionsMap.put(MovePosition.DOWN, new ArrayList<>());

    return new MoveRecords(movePositionsMap);
  }

  // 이동 경로 기록
  public void record(
      final MovePosition movePosition,
      final MoveRecord moveRecord
  ) {
    // 사용자가 입력한 MovePosition에 입력된 MoveRecord 기록
    final List<MoveRecord> moveRecordsAtSamePosition = moveRecordsMap.get(movePosition);
    moveRecordsAtSamePosition.add(moveRecord);

    // 사용자가 입력한 MovePosition 반대에 NONE(" ") 기록
    final List<MoveRecord> moveRecordsAtOtherPosition = moveRecordsMap.get(
        movePosition.getOpposite());
    moveRecordsAtOtherPosition.add(MoveRecord.NONE);
  }

  @Override
  public String toString() {
    return String.format("%s\n%s",
        renderByMovePosition(MovePosition.UP),
        renderByMovePosition(MovePosition.DOWN)
    );
  }

  private String renderByMovePosition(final MovePosition movePosition) {
    return String.format("[ %s ]", moveRecordsMap.get(movePosition).stream()
        .map(MoveRecord::getValue)
        .collect(Collectors.joining(" | "))
    );
  }
}

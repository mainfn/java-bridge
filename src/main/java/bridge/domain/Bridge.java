package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Bridge {

  private final List<Position> positions;

  public Bridge(final List<Position> positions) {
    validateBridgeSize(positions.size());
    this.positions = positions;
  }

  // 다리 길이 검증
  private static void validateBridgeSize(final int size) {
    if (size < 3 || size > 20) {
      throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
  }

  // static factory constructor
  public static Bridge from(final List<String> strs) {
    final List<Position> positions = strs.stream()
        .map(Position::of)
        .collect(Collectors.toList());

    return new Bridge(positions);
  }

  // 비교 후 결과 Pattern으로 반환
  public Pattern comparesAt(
      final int index,
      final Position other
  ) {
    final Position position = positions.get(index);
    if (position.equals(other)) {
      return Pattern.O;
    }
    return Pattern.X;
  }

  public int getMaxSize() {
    return positions.size();
  }
}

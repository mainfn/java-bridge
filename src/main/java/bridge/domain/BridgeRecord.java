package bridge.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BridgeRecord {

  private final Map<Position, List<Pattern>> bridgeMap;
  private int nextIndex = 0;

  private BridgeRecord(final int size) {
    bridgeMap = new LinkedHashMap<>();
    bridgeMap.put(Position.UP, createPatterns(size));
    bridgeMap.put(Position.DOWN, createPatterns(size));
  }

  public static BridgeRecord withSize(final int size) {
    return new BridgeRecord(size);
  }

  private List<Pattern> createPatterns(final int size) {
    return Stream
        .generate(() -> Pattern.None)
        .limit(size)
        .collect(Collectors.toList());
  }

  // 칸 추가
  public void update(final Position position, final Pattern pattern) {
    bridgeMap.get(position).set(nextIndex, pattern);
    nextIndex++;
  }

  // render

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (final List<Pattern> patterns : bridgeMap.values()) {
      final String line = String.format("[ %s ]",
          patterns.stream()
              .limit(nextIndex)
              .map(Pattern::getValue)
              .collect(Collectors.joining(" | "))
      );
      sb.append(line);
      sb.append("\n");
    }
    return sb.toString();
  }
}

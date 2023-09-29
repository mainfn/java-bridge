package bridge.domain;

import bridge.utils.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public final class BridgeMaker {

  private final BridgeNumberGenerator bridgeNumberGenerator;

  public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
    this.bridgeNumberGenerator = bridgeNumberGenerator;
  }

  /**
   * @param size 다리의 길이
   * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
   */
  public List<String> makeBridge(final int size) {
    final List<String> bridge = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      bridge.add(nextPatternString());
    }
    return bridge;
  }

  private String nextPatternString() {
    if (bridgeNumberGenerator.generate() == 1) {
      return "U";
    }

    return "D";
  }
}

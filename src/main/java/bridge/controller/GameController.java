package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public final class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final BridgeMaker bridgeMaker;

  public GameController(
      final InputView inputView,
      final OutputView outputView,
      final BridgeMaker bridgeMaker
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.bridgeMaker = bridgeMaker;
  }

  public void start() {
    final int bridgeSize = inputView.readBridgeSize();
    final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    final BridgeMap bridgeMap = BridgeMap.from(bridge);
  }
}

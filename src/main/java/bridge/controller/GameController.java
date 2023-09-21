package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final BridgeGame bridgeGame;

  public GameController(
      final InputView inputView,
      final OutputView outputView,
      final BridgeGame bridgeGame
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.bridgeGame = bridgeGame;
  }

  // TODO:
  public void run() {

  }
}

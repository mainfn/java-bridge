package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final BridgeGame bridgeGame = new BridgeGame();
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final GameController gameController = new GameController(inputView, outputView, bridgeGame);

    gameController.run();
  }
}

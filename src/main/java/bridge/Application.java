package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    final GameController gameController = new GameController(inputView, outputView, bridgeMaker);

    try {
      gameController.start();
    } catch (final Exception e) {
      System.out.printf("[ERROR] %s\n", e.getMessage());
    }
  }
}

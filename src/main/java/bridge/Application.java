package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final GameController gameController = new GameController(inputView, outputView, bridgeMaker);

    gameController.run();
  }
}

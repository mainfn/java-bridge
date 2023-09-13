package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

  public static void main(String[] args) {
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView();
    final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    final GameController gameController = new GameController(inputView, outputView, bridgeMaker);
    gameController.start();
  }
}

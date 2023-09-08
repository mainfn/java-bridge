package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Position;
import bridge.view.InputView;
import bridge.view.OutputView;

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
    // 게임 생성
    final BridgeGame bridgeGame = getBridgeGame();

    // 실행
    play(bridgeGame);

    // 결과 출력
    outputView.printResult(bridgeGame.getResult());
  }

  private void play(final BridgeGame bridgeGame) {
    while (bridgeGame.isPlaying()) {
      final Position nextPosition = Position.of(inputView.readMoving());
      bridgeGame.move(nextPosition);
      outputView.printMap(bridgeGame);
    }

    retryIfHasError(bridgeGame);
  }

  private void retryIfHasError(final BridgeGame bridgeGame) {
    if (bridgeGame.hasError()) {
      final String command = inputView.readGameCommand();
      if ("R".equals(command)) {
        bridgeGame.retry();
        play(bridgeGame);
      }
    }
  }

  private BridgeGame getBridgeGame() {
    final int bridgeSize = inputView.readBridgeSize();
    final Bridge bridge = Bridge.from(bridgeMaker.makeBridge(bridgeSize));

    return BridgeGame.of(bridge);
  }
}

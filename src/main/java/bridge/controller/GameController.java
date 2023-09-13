package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.MovePosition;
import bridge.domain.MoveRecords;
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
    // 1. 사용자로부터 입력 받은 데이터로 BridgeGame 생성
    final BridgeGame bridgeGame = makeBridgeGame();

    // 2. 게임 실행(입력을 받은 위치로 이동, 다리 끝까지 or 이동이 실패할 때까지)
    final BridgeGameResult bridgeGameResult = play(bridgeGame);

    // 3. 결과 출력
    outputView.printResult(bridgeGameResult);
  }

  private BridgeGameResult play(final BridgeGame bridgeGame) {

    while (bridgeGame.isPlaying()) {
      final String movePositionString = inputView.readMoving();
      final MovePosition movePosition = MovePosition.of(movePositionString);
      bridgeGame.move(movePosition);

      final MoveRecords moveRecords = bridgeGame.getMoveRecords();
      outputView.printMap(moveRecords);
    }
    if (bridgeGame.isFailed()) {
      final String command = inputView.readGameCommand();
      if ("R".equals(command)) {
        bridgeGame.retry();
        play(bridgeGame);
      }
    }

    return bridgeGame.getGameResult();
  }

  private BridgeGame makeBridgeGame() {
    final int bridgeSize = inputView.readBridgeSize();
    final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    final BridgeMap bridgeMap = BridgeMap.from(bridge);
    return BridgeGame.of(bridgeMap);
  }
}

package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.GameCommand;
import bridge.domain.GameResult;
import bridge.domain.GameStatus;
import bridge.domain.MovePosition;
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

  // TODO:
  public void run() {
    // 1. 게임 생성
    final BridgeGame bridgeGame = createBridgeGame();

    // 2. 게임 실행
    GameResult result = play(bridgeGame);

    // 3. 결과 출력
    outputView.printResult(result);
  }


  private BridgeGame createBridgeGame() {
    final int bridgeSize = inputView.readBridgeSize();

    final List<String> patternStrings = bridgeMaker.makeBridge(bridgeSize);
    final BridgeMap bridgeMap = BridgeMap.of(patternStrings);
    return BridgeGame.of(bridgeMap);
  }

  private GameResult play(final BridgeGame game) {
    // 실패 or 성공 시까지 이동
    while (game.isPlaying()) {

      final MovePosition movePosition = inputView.readMoving();
      game.move(movePosition);

      outputView.printMap(game.getMoveRecords());
    }

    // 실패 시, 재시작 하여 결과 재생성
    if (willReplay(game.getStatus())) {
      game.retry();
      return play(game);
    }

    // 성공 시, 결과 반환
    return game.getResult();
  }

  private boolean willReplay(final GameStatus gameStatus) {
    if (GameStatus.FAILURE.equals(gameStatus)) {
      final GameCommand gameCommand = inputView.readGameCommand();
      // 재실행 시,
      return GameCommand.R.equals(gameCommand);
    }
    return false;
  }

}

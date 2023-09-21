package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.MovePosition;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public final class InputView {

  /**
   * 다리의 길이를 입력받는다.
   */
  public int readBridgeSize() {
    System.out.println(Message.READ_BRIDGE_SIZE);
    return Integer.parseInt(readLine());
  }

  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  public MovePosition readMoving() {
    System.out.println(Message.READ_MOVE_POSITION);
    return MovePosition.of(readLine());
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public GameCommand readGameCommand() {
    System.out.println(Message.READ_GAME_COMMAND);
    return GameCommand.of(readLine());
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public final class InputView {

  /**
   * 다리의 길이를 입력받는다.
   */
  public int readBridgeSize() {
    System.out.println("다리 건너기 게임을 시작합니다.");
    System.out.println();
    System.out.println("다리의 길이를 입력해주세요.");
    return Integer.parseInt(readLine());
  }


  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  public String readMoving() {
    System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    final String input = readLine();
    if ("U".equals(input) || "D".equals(input)) {
      return input;
    }
    throw new IllegalArgumentException("이동 시 U, D만 입력 가능합니다.");
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public String readGameCommand() {
    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    final String command = readLine();

    if ("R".equals(command) || "Q".equals(command)) {
      return command;
    }
    throw new IllegalArgumentException("R, Q 중 하나를 입력해주세요.");
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}

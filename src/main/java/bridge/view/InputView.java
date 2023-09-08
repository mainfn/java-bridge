package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

  /**
   * 다리의 길이를 입력받는다.
   */
  public int readBridgeSize() {
    System.out.println("다리 건너기 게임을 시작합니다.");
    System.out.println();
    System.out.println("다리의 길이를 입력해주세요.");

    try {
      return Integer.parseInt(readLine());
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
  }

  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  public String readMoving() {
    System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    final String str = readLine();
    if (!"U".equals(str) && !"D".equals(str)) {
      throw new IllegalArgumentException("이동할 칸은 U | D 중 입력");
    }
    return str;
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public String readGameCommand() {
    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    final String str = readLine();
    if (!"R".equals(str) && !"Q".equals(str)) {
      throw new IllegalArgumentException("R | Q 중 입력");
    }
    return str;
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}

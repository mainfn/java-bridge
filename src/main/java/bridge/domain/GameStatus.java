package bridge.domain;

public enum GameStatus {
  SUCCESS("성공"),
  FAILURE("실패"),
  PROGRESS("");

  private final String status;

  GameStatus(final String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}

package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  @DisplayName("레스토랑에 17시 이전엔 들어갈 수 없다.")
  void cannotEnterBeforeFivePm() {
    Restaurant restaurant = new Restaurant();
    boolean r = restaurant.canEnter(LocalTime.of(16, 59));
//    boolean r = restaurant.canEnter(LocalTime.now());

    assertThat(r).isFalse();
  }

  @Test
  @DisplayName("레스토랑에 17시 이후엔 들어갈 수 있다.")
  void canEnterAfterFivePm() {
    Restaurant restaurant = new Restaurant();
    boolean r = restaurant.canEnter(LocalTime.of(17, 0));
//    boolean r = restaurant.canEnter(LocalTime.now());

    assertThat(r).isTrue();
  }

  @Test
  @DisplayName("레스토랑에 22시 까진 들어갈 수 없다.")
  void canEnterUntil22Pm() {
    Restaurant restaurant = new Restaurant();
    boolean r = restaurant.canEnter(LocalTime.of(22, 0));

    assertThat(r).isTrue();
  }

  @Test
  @DisplayName("레스토랑에 22시 이후엔 들어갈 수 없다.")
  void cannotEnterAfter22Pm() {
    Restaurant restaurant = new Restaurant();
    boolean r = restaurant.canEnter(LocalTime.of(22, 1));

    assertThat(r).isFalse();
  }

  static class Restaurant {

    // 이 레스토랑에 출입 가능한 시간은 17시부터 22시까지다.
    public boolean canEnter(LocalTime now) {
//      LocalTime now = LocalTime.now();
      if (now.isBefore(LocalTime.of(17, 0))) {
        return false;
      }
      return !now.isAfter(LocalTime.of(22, 0));
    }
  }

  static class User {

    String name;
    LocalDateTime createdDateTime; // createdAt, createdDt, createdDateTime

    public User(String name, LocalDateTime createdDateTime) {
      this.name = name;
      this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", createdDateTime=" + createdDateTime +
          '}';
    }
  }

}

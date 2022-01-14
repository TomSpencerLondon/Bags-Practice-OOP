package com.codurance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AdventurerTest {
  @Test
  void zeroItems5BagsAreEmpty() {
    // Given
    final Adventurer adventurer = new Adventurer();

    // When
    final List<Bag> inventory = adventurer.viewInventory();

    // Then

    assertThat(inventory)
        .hasSize(5);

    assertThat(inventory.get(0))
        .isInstanceOf(Backpack.class);
    assertThat(inventory.get(1))
        .isInstanceOf(MetalsBag.class);
    assertThat(inventory.get(2))
        .isInstanceOf(NoCategoryBag.class);
    assertThat(inventory.get(3))
        .isInstanceOf(WeaponsBag.class);
    assertThat(inventory.get(4))
        .isInstanceOf(NoCategoryBag.class);
  }
}

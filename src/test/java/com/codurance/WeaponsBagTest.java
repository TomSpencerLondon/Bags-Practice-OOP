package com.codurance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WeaponsBagTest {

  @Test
  void disallowIncorrectItems() {
    String item = "Cherry Blossom";

    final WeaponsBag weaponsBag = new WeaponsBag(Position.FOURTH);
    final boolean result = weaponsBag.include(item);

    assertThat(result)
        .isFalse();
  }

  @Test
  void allowIncludedItems() {
    String item = "Axe";

    final WeaponsBag weaponsBag = new WeaponsBag(Position.FOURTH);
    final boolean result = weaponsBag.include(item);

    assertThat(result)
        .isTrue();
  }

  @Test
  void sortInAlphabeticOrder() {
    final WeaponsBag weaponsBag = new WeaponsBag(Position.FOURTH);
    weaponsBag.add("Axe");
    weaponsBag.add("Dagger");
    weaponsBag.add("Mace");
    weaponsBag.add("Sword");

    weaponsBag.sort();

    assertThat(weaponsBag.items())
        .containsExactly("Axe", "Dagger", "Mace", "Sword");
  }
}
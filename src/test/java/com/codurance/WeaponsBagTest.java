package com.codurance;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeaponsBagTest {

  @Test
  void disallowIncorrectItems() {
    String item = "Cherry Blossom";

    final MetalsBag metalsBag = new MetalsBag();
    final boolean result = metalsBag.include(item);

    assertThat(result)
        .isFalse();
  }

  @Test
  void allowIncludedItems() {
    String item = "Iron";

    final MetalsBag metalsBag = new MetalsBag();
    final boolean result = metalsBag.include(item);

    assertThat(result)
        .isTrue();
  }
}
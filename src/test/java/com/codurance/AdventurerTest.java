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

  @Test
  void addedItemIsIncludedInBackpack() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add("Leather");

    // When
    final List<Bag> inventory = adventurer.viewInventory();
    assertThat(inventory.get(0).items().get(0))
        .isEqualTo("Leather");
  }

  @Test
  void addNineItemsIncludesTenInBackpackAndTwoInMetalsBag() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add("Leather", "Iron", "Copper", "Marigold", "Wool", "Gold", "Silk", "Copper", "Copper", "Cherry Blossom");

    final Backpack backpack = new Backpack();
    backpack.add("Leather");
    backpack.add("Iron");
    backpack.add("Copper");
    backpack.add("Marigold");
    backpack.add("Wool");
    backpack.add("Gold");
    backpack.add("Silk");
    backpack.add("Copper");

    final MetalsBag metalsBag = new MetalsBag();
    metalsBag.add("Copper");
    metalsBag.add("Cherry Blossom");

    List<Bag> result = List.of(backpack, metalsBag, new NoCategoryBag(), new WeaponsBag(), new NoCategoryBag());

    // When
    final List<Bag> inventory = adventurer.viewInventory();
    assertThat(inventory)
        .containsAll(result);
  }
}

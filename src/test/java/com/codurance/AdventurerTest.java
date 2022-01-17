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
  void addTenItemsIncludesEightInBackpackAndTwoInMetalsBag() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add("Leather", "Iron", "Copper", "Marigold", "Wool", "Gold", "Silk", "Copper", "Copper", "Cherry Blossom");

    final Backpack backpack = createBackPack();

    final MetalsBag metalsBag = new MetalsBag(Position.SECOND);
    metalsBag.add("Copper");
    metalsBag.add("Cherry Blossom");

    List<Bag> result = List.of(backpack, metalsBag, new NoCategoryBag(Position.THIRD), new WeaponsBag(Position.FOURTH), new NoCategoryBag(Position.FIFTH));

    // When
    final List<Bag> inventory = adventurer.viewInventory();

    // Then
    assertThat(inventory)
        .containsAll(result);
  }

  @Test
  void ThirteenItemsIncludesEightInBackpackFourInMetalsBagAndOneInBagWithNoCategory() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add(
        "Leather", "Iron", "Copper",
        "Marigold", "Wool", "Gold",
        "Silk", "Copper", "Copper",
        "Cherry Blossom", "Marigold", "Rose",
        "Seaweed");

    final Backpack backpack = createBackPack();

    final MetalsBag metalsBag = new MetalsBag(Position.SECOND);
    metalsBag.add("Copper");
    metalsBag.add("Cherry Blossom");
    metalsBag.add("Marigold");
    metalsBag.add("Rose");

    final NoCategoryBag noCategoryBag = new NoCategoryBag(Position.THIRD);
    noCategoryBag.add("Seaweed");

    List<Bag> result = List.of(
        backpack, metalsBag,
        noCategoryBag, new WeaponsBag(Position.FOURTH),
        new NoCategoryBag(Position.FIFTH));

    // When
    final List<Bag> inventory = adventurer.viewInventory();

    // Then
    assertThat(inventory)
        .containsAll(result);

  }

  @Test
  void organizeSpellSortsItemsWithMetalsInCorrectBags() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add(
        "Leather", "Iron", "Copper",
        "Marigold", "Wool", "Gold",
        "Silk", "Copper", "Copper",
        "Cherry Blossom");

    
    final Backpack backpack = new Backpack(Position.FIRST);
    backpack.add("Cherry Blossom");
    backpack.add("Iron");
    backpack.add("Leather");
    backpack.add("Marigold");
    backpack.add("Silk");
    backpack.add("Wool");

    final MetalsBag metalsBag = new MetalsBag(Position.SECOND);
    metalsBag.add("Copper");
    metalsBag.add("Copper");
    metalsBag.add("Copper");
    metalsBag.add("Gold");


    Organizer.organizeSpell(adventurer);


    assertThat(adventurer.viewInventory())
        .containsExactly(
            backpack,
            metalsBag,
            new NoCategoryBag(Position.THIRD),
            new WeaponsBag(Position.FOURTH),
            new NoCategoryBag(Position.FIFTH));
  }

  @Test
  void organizeSpellWithMetalsAndWeaponsSortsItemsInCorrectOrder() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add(
        "Leather", "Iron", "Copper",
        "Marigold", "Mace", "Sword", "Wool", "Gold",
        "Silk", "Copper", "Copper",
        "Cherry Blossom",
        "Axe", "Dagger");


    final Backpack backpack = new Backpack(Position.FIRST);
    backpack.add("Cherry Blossom");
    backpack.add("Iron");
    backpack.add("Leather");
    backpack.add("Marigold");
    backpack.add("Silk");
    backpack.add("Wool");

    final MetalsBag metalsBag = new MetalsBag(Position.SECOND);
    metalsBag.add("Copper");
    metalsBag.add("Copper");
    metalsBag.add("Copper");
    metalsBag.add("Gold");

    final WeaponsBag weaponsBag = new WeaponsBag(Position.FOURTH);
    weaponsBag.add("Axe");
    weaponsBag.add("Dagger");
    weaponsBag.add("Mace");
    weaponsBag.add("Sword");

    Organizer.organizeSpell(adventurer);


    assertThat(adventurer.viewInventory())
        .containsExactly(
            backpack,
            metalsBag,
            new NoCategoryBag(Position.THIRD),
            weaponsBag,
            new NoCategoryBag(Position.FIFTH));
  }

  private Backpack createBackPack() {
    final Backpack backpack = new Backpack(Position.FIRST);
    backpack.add("Leather");
    backpack.add("Iron");
    backpack.add("Copper");
    backpack.add("Marigold");
    backpack.add("Wool");
    backpack.add("Gold");
    backpack.add("Silk");
    backpack.add("Copper");
    return backpack;
  }
}

package com.codurance;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AcceptanceTest {

  @Test
  void addTenItemsThenOrganiseReturnsOrderedInventory() {
    // Given
    final Adventurer adventurer = new Adventurer();
    adventurer.add(
        "Leather", "Iron", "Copper",
        "Marigold", "Wool", "Gold",
        "Silk", "Copper", "Copper",
        "Cherry Blossom");

    adventurer.organiseSpell();

    // Then
    final String displayInventory = adventurer.displayInventory();
    final String expectedResult = expectedResult();

    assertThat(displayInventory)
        .isEqualTo(expectedResult);
  }

  private String expectedResult() {
    Gson gsonObj = new Gson();
    final List<String> items1 = List.of("Cherry Blossom", "Iron", "Leather", "Marigold", "Silk",
        "Wool");

    final List<String> items2 = List.of("Copper", "Copper", "Copper", "Gold");
    Map<String, List<String>> result = new HashMap<>();
    result.put("backpack", items1);
    result.put("bag_with_metals_category", items2);
    result.put("bag_with_no_category", List.of());
    result.put("bag_with_weapons_category", List.of());
    result.put("second_bag_with_no_category", List.of());
    // convert map to JSON String
    return gsonObj.toJson(result);
  }
}

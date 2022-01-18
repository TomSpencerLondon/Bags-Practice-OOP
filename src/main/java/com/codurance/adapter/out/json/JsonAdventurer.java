package com.codurance.adapter.out.json;

import com.codurance.domain.bags.Adventurer;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonAdventurer {

  public static String displayInventory(Adventurer adventurer) {
    Gson gsonObj = new Gson();
    Map<String, List<String>> result = new HashMap<>();
    result.put("backpack", adventurer.backpack().items());
    result.put("bag_with_metals_category", adventurer.metalsBag().items());
    result.put("bag_with_no_category", adventurer.noCategoryBag1().items());
    result.put("bag_with_weapons_category", adventurer.weaponsBag().items());
    result.put("second_bag_with_no_category", adventurer.noCategoryBag2().items());

    return gsonObj.toJson(result);
  }
}

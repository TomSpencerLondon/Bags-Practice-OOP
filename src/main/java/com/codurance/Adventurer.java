package com.codurance;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Adventurer {

  private final TreeMap<Bag, Integer> bags;
  private Backpack backpack;
  private MetalsBag metalsBag;
  private NoCategoryBag noCategoryBag1;
  private WeaponsBag weaponsBag;
  private NoCategoryBag2 noCategoryBag2;

  public Adventurer() {
    this.backpack = new Backpack();
    this.metalsBag = new MetalsBag();
    this.noCategoryBag1 = new NoCategoryBag();
    this.noCategoryBag2 = new NoCategoryBag2();
    this.weaponsBag = new WeaponsBag();
    this.bags = new TreeMap<>();
    bags.put(backpack, 8);
    bags.put(metalsBag, 4);
    bags.put(noCategoryBag1, 4);
    bags.put(weaponsBag, 4);
    bags.put(noCategoryBag2, 4);
  }

  public List<Bag> viewInventory() {
    return List.of(
        backpack,
        metalsBag,
        noCategoryBag1,
        weaponsBag,
        noCategoryBag2
    );
  }

  public String displayInventory() {
    Gson gsonObj = new Gson();
    Map<String, List<String>> result = new HashMap<>();
    result.put("backpack", backpack.items());
    result.put("bag_with_metals_category", metalsBag.items());
    result.put("bag_with_no_category", noCategoryBag1.items());
    result.put("bag_with_weapons_category", weaponsBag.items());
    result.put("second_bag_with_no_category", noCategoryBag2.items());

    return gsonObj.toJson(result);
  }

  public void add(String... items) {
    final Iterator<String> iterator = Arrays.stream(items).iterator();
    for (Entry<Bag, Integer> entry : bags.entrySet()) {
      while (entry.getKey().countOfItemsWithin(entry.getValue()) && iterator.hasNext()) {
        entry.getKey().add(iterator.next());
      }
    }
  }

  public void organizeSpell() {
    List<String> reversedItems = reversedItems();
    sortWeaponsAndMetals(reversedItems);
    add(reversedItems.toArray(new String[0]));
    sortItems();
  }

  private void sortWeaponsAndMetals(List<String> reversedItems) {
    for (Bag bag : bags.keySet()) {
      bag.emptyBag();
      for (int i = 0; i < reversedItems.size(); i++) {
        String item = reversedItems.get(i);
        if (bag.include(item) && bag.countOfItemsWithin(4)) {
          bag.add(item);
          reversedItems.remove(i);
          i--;
        }
      }
    }
  }

  private void sortItems() {
    for (Entry<Bag, Integer> entry : bags.entrySet()) {
      entry.getKey().sort();
    }
  }

  private List<String> reversedItems() {
    List<Bag> allBags = bags
        .keySet()
        .stream().toList();

    List<String> allItems = new ArrayList<>();
    for (Bag b : allBags) {
      List<String> items = b.items();
      allItems.addAll(items);
    }

    Collections.reverse(allItems);
    return allItems;
  }
}

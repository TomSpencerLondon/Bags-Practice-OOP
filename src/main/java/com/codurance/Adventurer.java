package com.codurance;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Adventurer {

  private TreeMap<Bag, Integer> bags;
  private Backpack backpack;
  private MetalsBag metalsBag;
  private NoCategoryBag noCategoryBag1;
  private WeaponsBag weaponsBag;
  private NoCategoryBag noCategoryBag2;

  public Adventurer() {
    this.backpack = BagFactory.createBackpack();
    this.metalsBag = BagFactory.createMetalsBag();
    this.noCategoryBag1 = BagFactory.createNoCategoryBag();
    this.weaponsBag = BagFactory.createWeaponsBag();
    this.noCategoryBag2 = BagFactory.createNoCategoryBag2();
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
      while (isWithinCountOfItemsFor(entry) && iterator.hasNext()) {
        entry.getKey().add(iterator.next());
      }
    }
  }

  private boolean isWithinCountOfItemsFor(Entry<Bag, Integer> entry) {
    return entry.getKey().countOfItemsWithin(entry.getValue());
  }

  public void organizeSpell() {
    final SortSpell sortSpell = new SortSpell(bags);
    List<String> reversedItems = sortSpell.reversedItems();
    sortSpell.sortWeaponsAndMetals(reversedItems);
    add(reversedItems.toArray(new String[0]));
    bags = sortSpell.sortItems();
  }

}

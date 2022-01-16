package com.codurance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    throw new UnsupportedOperationException("Implement me!");
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
    List<Bag> allBags = bags
        .keySet()
        .stream().toList();

    List<String> allItems = new ArrayList<>();
    for (Bag b : allBags) {
      List<String> items = b.items();
      allItems.addAll(items);
    }

    Collections.reverse(allItems);

    for (Bag bag : bags.keySet()) {
      bag.emptyBag();
      for (int i = 0; i < allItems.size(); i++) {
        String item = allItems.get(i);
        if (bag.include(item) && bag.countOfItemsWithin(4)) {
          bag.add(item);
          allItems.remove(i);
          i--;
        }
      }
    }

    add(allItems.toArray(new String[0]));

    for (Entry<Bag, Integer> entry : bags.entrySet()) {
      entry.getKey().sort();
    }
  }
}

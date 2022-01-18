package com.codurance;

import com.codurance.bags.Bag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortSpell {

  private TreeMap<Bag, Integer> bags;
  public SortSpell(TreeMap<Bag, Integer> bags) {
    this.bags = bags;
  }

  public void sortWeaponsAndMetals(List<String> reversedItems) {
    for (Bag bag : bags.keySet()) {
      sort(reversedItems, bag);
    }
  }

  private void sort(List<String> reversedItems, Bag bag) {
    bag.emptyBag();
    sortItemsInBags(reversedItems, bag);
  }

  private void sortItemsInBags(List<String> reversedItems, Bag bag) {
    for (int i = 0; i < reversedItems.size(); i++) {
      String item = reversedItems.get(i);
      if (bag.include(item) && bag.countOfItemsWithin(4)) {
        bag.add(item);
        reversedItems.remove(i);
        i--;
      }
    }
  }

  public TreeMap<Bag, Integer> sortItems() {
    for (Entry<Bag, Integer> entry : bags.entrySet()) {
      entry.getKey().sort();
    }

    return bags;
  }

  public List<String> reversedItems() {
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

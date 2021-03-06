package com.codurance.domain.bags;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Organizer {
  private static TreeMap<Bag, Integer> organization;

  public Organizer(Adventurer adventurer) {
    this.organization = createOrganization(adventurer);
  }

  public static void organizeSpell(Adventurer adventurer) {
    final SortSpell sortSpell = new SortSpell(organization);
    List<String> reversedItems = sortSpell.reversedItems();
    sortSpell.sortWeaponsAndMetals(reversedItems);
    adventurer.add(reversedItems.toArray(new String[0]));
    organization = sortSpell.sortItems();
  }

  private TreeMap<Bag, Integer> createOrganization(Adventurer adventurer) {
    TreeMap<Bag, Integer> map = new TreeMap<>();
    map.put(adventurer.backpack(), 8);
    map.put(adventurer.metalsBag(), 4);
    map.put(adventurer.noCategoryBag1(), 4);
    map.put(adventurer.weaponsBag(), 4);
    map.put(adventurer.noCategoryBag2(), 4);

    return map;
  }

  public static void organize(Iterator<String> iterator, Adventurer adventurer) {
    for (Entry<Bag, Integer> entry : organization.entrySet()) {
      while (adventurer.isWithinCountOfItemsFor(entry) && iterator.hasNext()) {
        entry.getKey().add(iterator.next());
      }
    }
  }
}

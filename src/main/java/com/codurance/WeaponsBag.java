package com.codurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponsBag implements Bag {
  List<String> items = new ArrayList<>();
  private int position = 4;
  List<String> weaponItems = List.of("Axe", "Dagger", "Mace", "Sword");

  @Override
  public List<String> items() {
    return items;
  }

  @Override
  public void add(String item) {
    items.add(item);
  }

  public boolean countOfItemsWithin(int count) {
    return items.size() < count;
  }

  @Override
  public int position() {
    return this.position;
  }

  @Override
  public boolean include(String item) {
    return weaponItems.contains(item);
  }

  @Override
  public void emptyBag() {
    items = new ArrayList<>();
  }

  @Override
  public int compareTo(Bag bag) {
    return this.position - bag.position();
  }


  public void sort() {
    Collections.sort(items);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WeaponsBag that = (WeaponsBag) o;

    if (position != that.position) {
      return false;
    }
    if (!items.equals(that.items)) {
      return false;
    }
    return weaponItems.equals(that.weaponItems);
  }

  @Override
  public int hashCode() {
    int result = items.hashCode();
    result = 31 * result + position;
    result = 31 * result + weaponItems.hashCode();
    return result;
  }
}

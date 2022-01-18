package com.codurance.domain.bags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponsBag implements Bag {
  List<String> items = new ArrayList<>();
  private Position position;
  List<String> weaponItems = List.of("Axe", "Dagger", "Mace", "Sword");

  public WeaponsBag(Position position) {
    this.position = position;
  }

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
    return this.position.ordinal();
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
    return this.position.ordinal() - bag.position();
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

    if (!items.equals(that.items)) {
      return false;
    }
    if (position != that.position) {
      return false;
    }
    return weaponItems.equals(that.weaponItems);
  }

  @Override
  public int hashCode() {
    int result = items.hashCode();
    result = 31 * result + position.hashCode();
    result = 31 * result + weaponItems.hashCode();
    return result;
  }
}

package com.codurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetalsBag implements Bag {
  private Position position;
  List<String> items = new ArrayList<>();
  List<String> metalItems = List.of("Copper", "Gold", "Iron", "Silver");

  public MetalsBag(Position position) {
    this.position = position;
  }

  public int position() {
    return position.ordinal();
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
  public int compareTo(Bag bag) {
    return this.position.ordinal() - bag.position();
  }

  public boolean include(String item) {
    return metalItems.contains(item);
  }

  @Override
  public void emptyBag() {
    items = new ArrayList<>();
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

    MetalsBag metalsBag = (MetalsBag) o;

    if (position != metalsBag.position) {
      return false;
    }
    if (!items.equals(metalsBag.items)) {
      return false;
    }
    return metalItems.equals(metalsBag.metalItems);
  }

  @Override
  public int hashCode() {
    int result = position.hashCode();
    result = 31 * result + items.hashCode();
    result = 31 * result + metalItems.hashCode();
    return result;
  }
}

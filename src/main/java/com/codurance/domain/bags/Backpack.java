package com.codurance.domain.bags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backpack implements Bag {
  List<String> items = new ArrayList<>();
  public void add(String item) {
    items.add(item);
  }
  private Position position;

  public Backpack(Position position) {
    this.position = position;
  }

  @Override
  public List<String> items() {
    return items;
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
    return false;
  }

  @Override
  public void emptyBag() {
    items = new ArrayList<>();
  }

  @Override
  public void sort() {
    Collections.sort(items);
  }

  @Override
  public int compareTo(Bag bag) {
    return this.position.ordinal() - bag.position();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Backpack backpack = (Backpack) o;

    if (!items.equals(backpack.items)) {
      return false;
    }
    return position == backpack.position;
  }

  @Override
  public int hashCode() {
    int result = items.hashCode();
    result = 31 * result + position.hashCode();
    return result;
  }
}

package com.codurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoCategoryBag2 implements Bag {
  private int position = 5;

  List<String> items = new ArrayList<>();

  public int position() {
    return position;
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
    return this.position - bag.position();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    NoCategoryBag2 that = (NoCategoryBag2) o;

    if (position != that.position) {
      return false;
    }
    return items.equals(that.items);
  }

  @Override
  public int hashCode() {
    int result = position;
    result = 31 * result + items.hashCode();
    return result;
  }
}

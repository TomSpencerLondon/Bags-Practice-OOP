package com.codurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoCategoryBag implements Bag {

  List<String> items = new ArrayList<>();
  private int position = 3;

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

    NoCategoryBag that = (NoCategoryBag) o;

    if (position != that.position) {
      return false;
    }
    return items.equals(that.items);
  }

  @Override
  public int hashCode() {
    int result = items.hashCode();
    result = 31 * result + position;
    return result;
  }
}

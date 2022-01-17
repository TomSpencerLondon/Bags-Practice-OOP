package com.codurance.bags;

import com.codurance.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoCategoryBag implements Bag {

  List<String> items = new ArrayList<>();
  private Position position;

  public NoCategoryBag(Position position) {
    this.position = position;
  }

  public int position() {
    return position.ordinal();
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

    NoCategoryBag that = (NoCategoryBag) o;

    if (!items.equals(that.items)) {
      return false;
    }
    return position == that.position;
  }

  @Override
  public int hashCode() {
    int result = items.hashCode();
    result = 31 * result + position.hashCode();
    return result;
  }
}

package com.codurance;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.ArrayList;
import java.util.List;

public class Backpack implements Bag {
  List<String> items = new ArrayList<>();
  public void add(String item) {
    items.add(item);
  }
  private int position = 1;

  @Override
  public List<String> items() {
    return items;
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
    return false;
  }

  @Override
  public boolean equals(Object other) {
    return reflectionEquals(this, other);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public int compareTo(Bag bag) {
    return this.position - bag.position();
  }
}

package com.codurance;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetalsBag implements Bag {
  private int position = 2;
  List<String> items = new ArrayList<>();
  List<String> metalItems = List.of("Copper", "Gold", "Iron", "Silver");

  public int position() {
    return position;
  }

  @Override
  public List<String> items() {
    throw new UnsupportedOperationException("Implement me!");
  }

  @Override
  public void add(String item) {
    items.add(item);
  }

  @Override
  public boolean equals(Object other) {
    return reflectionEquals(this, other);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  public boolean countOfItemsWithin(int count) {
    return items.size() < count;
  }

  @Override
  public int compareTo(Bag bag) {
    return this.position - bag.position();
  }

  public boolean include(String item) {
    return metalItems.contains(item);
  }

  public void sort() {
    Collections.sort(items);
  }
}

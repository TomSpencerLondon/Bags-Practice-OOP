package com.codurance.bags;

import java.util.List;

public interface Bag extends Comparable<Bag> {
  List<String> items();
  void add(String item);
  boolean countOfItemsWithin(int count);
  int position();
  boolean include(String item);
  void emptyBag();
  void sort();
}

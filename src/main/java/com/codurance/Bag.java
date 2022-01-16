package com.codurance;

import java.util.List;

public interface Bag extends Comparable<Bag> {
  List<String> items();
  public void add(String item);
  public boolean countOfItemsWithin(int count);
  public int position();
  public boolean include(String item);
  public void emptyBag();
  public void sort();
}

package com.codurance.domain.bags;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Adventurer {

  private final Organizer organizer;
  private Backpack backpack;
  private MetalsBag metalsBag;
  private NoCategoryBag noCategoryBag1;
  private WeaponsBag weaponsBag;
  private NoCategoryBag noCategoryBag2;


  public Backpack backpack() {
    return backpack;
  }

  public MetalsBag metalsBag() {
    return metalsBag;
  }

  public NoCategoryBag noCategoryBag1() {
    return noCategoryBag1;
  }

  public WeaponsBag weaponsBag() {
    return weaponsBag;
  }

  public NoCategoryBag noCategoryBag2() {
    return noCategoryBag2;
  }

  public Adventurer() {
    this.backpack = BagFactory.createBackpack();
    this.metalsBag = BagFactory.createMetalsBag();
    this.noCategoryBag1 = BagFactory.createNoCategoryBag();
    this.weaponsBag = BagFactory.createWeaponsBag();
    this.noCategoryBag2 = BagFactory.createNoCategoryBag2();
    this.organizer = new Organizer(this);
  }


  public List<Bag> viewInventory() {
    return List.of(
        backpack,
        metalsBag,
        noCategoryBag1,
        weaponsBag,
        noCategoryBag2
    );
  }

  public void add(String... items) {
    final Iterator<String> iterator = Arrays.stream(items).iterator();
    organizer.organize(iterator, this);
  }

  public boolean isWithinCountOfItemsFor(Entry<Bag, Integer> entry) {
    return entry.getKey().countOfItemsWithin(entry.getValue());
  }

}

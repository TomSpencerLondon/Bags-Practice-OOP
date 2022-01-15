package com.codurance;

import java.util.List;

public class Adventurer {

  private Backpack backpack;
  private MetalsBag metalsBag;
  private NoCategoryBag noCategoryBag1;
  private WeaponsBag weaponsBag;
  private NoCategoryBag noCategoryBag2;

  public Adventurer() {
    this.backpack = new Backpack();
    this.metalsBag = new MetalsBag();
    this.noCategoryBag1 = new NoCategoryBag();
    this.noCategoryBag2 = new NoCategoryBag();
    this.weaponsBag = new WeaponsBag();
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
    for (String item : items){
      if (backpack.countOfItemsWithin(8)) {
        backpack.add(item);
      }else {
        metalsBag.add(item);
      }
    }
  }
}

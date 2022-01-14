package com.codurance;

import java.util.List;

public class Adventurer {

  public List<Bag> viewInventory() {
    return List.of(
        new Backpack(),
        new MetalsBag(),
        new NoCategoryBag(),
        new WeaponsBag(),
        new NoCategoryBag()
    );
  }
}

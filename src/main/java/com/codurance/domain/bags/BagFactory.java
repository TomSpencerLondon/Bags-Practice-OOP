package com.codurance.domain.bags;

public class BagFactory {

  static Backpack backpack;
  private static MetalsBag metalsBag;
  private static NoCategoryBag noCategoryBag;
  private static WeaponsBag weaponsBag;
  private static NoCategoryBag noCategoryBag2;

  public static Backpack createBackpack() {
    if (backpack == null) {
      return new Backpack(Position.FIRST);
    }
    return backpack;
  }

  public static MetalsBag createMetalsBag() {
    if (metalsBag == null) {
      return new MetalsBag(Position.SECOND);
    }
    return metalsBag;
  }

  public static NoCategoryBag createNoCategoryBag() {
    if (noCategoryBag == null) {
      return new NoCategoryBag(Position.THIRD);
    }
    return noCategoryBag;
  }

  public static WeaponsBag createWeaponsBag() {
    if (weaponsBag == null) {
      return new WeaponsBag(Position.FOURTH);
    }
    return weaponsBag;
  }

  public static NoCategoryBag createNoCategoryBag2() {
    if (weaponsBag == null) {
      return new NoCategoryBag(Position.FIFTH);
    }
    return noCategoryBag2;
  }
}

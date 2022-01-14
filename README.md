# Bags-Practice-OOP
https://katalyst.codurance.com/bags
## Rules
Durance has 1 backpack and 4 extra bags
Each bag has a capacity of 4 items, the backpack has a capacity of 8 items
Each bag can have a category, the backpack doesn't have one
Items are sorted alphabetically after organizing the bags
  backpack = ['Leather', 'Iron', 'Copper', 'Marigold', 'Wool', 'Gold', 'Silk', 'Copper']
bag_with_metals_category = []
bag_with_no_category = []
bag_with_weapons_category = []
bag_with_no_category = []
      {
      "clothes": ["Leather", "Linen", "Silk", "Wool"],
      "herbs": ["Cherry Blossom", "Marigold", "Rose", "Seaweed"],
      "metals": ["Copper", "Gold", "Iron", "Silver"],
      "weapons": ["Axe", "Dagger", "Mace", "Sword"]
    }

## Domain language:
Adventurer - a person who goes on adventures, collection of bags, can organise and add items
inventory - empty backpack and 4 extra empty bags -
Bags include: 1. backpack, 2. metals, 3. weapons, 4. No category
Bag - one of the bags the Adventurer takes on his adventure, has a capacity, category
Categories - Metal, Weapons, Herbs, Clothes, Miscellaneous, Backpack (Miscellaneous bag with capacity of 8)
Backpack - bag which stores upto 8 miscellaneous items
Metals Bag - contains "Copper", "Gold", "Iron", "Silver"
weapons bag - contains "Axe", "Dagger", "Mace", "Sword"
Herbs bag - contains "Cherry Blossom", "Marigold", "Rose", "Seaweed"
Clothes bag - contains "Leather", "Linen", "Silk", "Wool"

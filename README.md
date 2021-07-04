# UraShop

###Configuration syntax:

###Create catergory :

**Item syntax:**

```
type=[Material];name=[Name];buy_price=[Name];sell_price=[Name];meta=[Name]
```

**Set id of the catergory :**
```yaml
categorys:
- [Id of the catergory]
```
**Set name of the catergory :**
```yaml
categorys_names:
- [Name of the catergory]
```

**Set catergory icon:**
```yaml
categorys_parameters:
  Vegetables:
    item: [Catergory icon item]
    color: [Catergory color]
    id: [Catergory id number]
```

**Set content of the catergory:**

List all items in categorys_content:

```yaml
categorys_content:
  [Id of the catergory]:
    - type=[Material];name=[Name];buy_price=[Name];sell_price=[Name];meta=[Name]
```
    

### UraCraft default config :
```yaml
categorys:
- Vegetables
- Loots
- Minerals

categorys_names:
  - Végétal
  - Animaux / Mobs
  - Minerais

categorys_parameters:
  Vegetables:
    item: type=CARROT_ITEM;name=Végétal;color=DARK_GREEN
    color: DARK_GREEN
    id: 1
  Loots:
    item: type=RAW_BEEF;name=Animaux / Mobs;color=RED
    color: RED
    id: 2
  Minerals:
    item: type=DIAMOND_ORE;name=Minerais / Blocks;color=BLUE
    color: BLUE
    id: 3

categorys_content:
  Vegetables:
    - type=SEEDS;name=Graine de blé;buy_price=4;sell_price=0;meta=0
    - type=MELON_SEEDS;name=Graine de melon;buy_price=6;sell_price=1;meta=0
    - type=PUMPKIN_SEEDS;name=Graine de citrouille;buy_price=4;sell_price=0;meta=0
    - type=CARROT_ITEM;name=Carrote;buy_price=8;sell_price=1;meta=0
    - type=POTATO_ITEM;name=Pomme de terre;buy_price=8;sell_price=1;meta=0
    - type=WHEAT;name=Blé;buy_price=4;sell_price=0;meta=0
    - type=MELON_BLOCK;name=Melon;buy_price=50;sell_price=11;meta=0
    - type=PUMPKIN;name=Citrouille;buy_price=20;sell_price=4;meta=0
    - type=SUGAR_CANE;name=Canne à sucre;buy_price=4;sell_price=0;meta=0
    - type=CACTUS;name=Cactus;buy_price=4;sell_price=1;meta=0
    - type=INK_SACK;name=Fève de cacao;buy_price=4;sell_price=0;meta=3
  Loots:
    - type=STRING;name=Fil;buy_price=8;sell_price=1;meta=0
    - type=SPIDER_EYE;name=Oeil d'araignée;buy_price=16;sell_price=3;meta=0
    - type=BONE;name=Os;buy_price=12;sell_price=2;meta=0
    - type=SULPHUR;name=Poudre à canon;buy_price=20;sell_price=4;meta=0
    - type=GHAST_TEAR;name=Larme de Ghast;buy_price=400;sell_price=88;meta=0
    - type=FEATHER;name=Plume;buy_price=8;sell_price=1;meta=0
    - type=LEATHER;name=Cuir;buy_price=40;sell_price=8;meta=0
    - type=RAW_BEEF;name=Steak;buy_price=20;sell_price=4;meta=0
    - type=RAW_CHICKEN;name=Poulet;buy_price=16;sell_price=3;meta=0
    - type=RAW_FISH;name=Poisson;buy_price=40;sell_price=8;meta=0
    - type=BLAZE_ROD;name=Bâton de Blaze;buy_price=100;sell_price=22;meta=0
    - type=SLIME_BALL;name=Boule de slime;buy_price=50;sell_price=11;meta=0
    - type=SKULL_ITEM;name=Tête de wither squelette;buy_price=25000;sell_price=11250;meta=1
  Minerals:
    - type=COBBLESTONE;name=Pierre;buy_price=1;sell_price=0;meta=0
    - type=DIRT;name=Terre;buy_price=1;sell_price=0;meta=0
    - type=SAND;name=Sable;buy_price=2;sell_price=0;meta=0
    - type=SOUL_SAND;name=Sable des âmes;buy_price=8;sell_price=1;meta=0
    - type=OBSIDIAN;name=Obsidienne;buy_price=24;sell_price=5;meta=0
    - type=COAL;name=Charbon;buy_price=16;sell_price=3;meta=0
    - type=REDSTONE;name=Redstone;buy_price=8;sell_price=1;meta=0
    - type=IRON_INGOT;name=Lingot de fer;buy_price=30;sell_price=6;meta=0
    - type=GOLD_INGOT;name=Lingot d'or;buy_price=80;sell_price=17;meta=0
    - type=QUARTZ;name=Quartz;buy_price=5;sell_price=1;meta=0
    - type=INK_SACK;name=Lapis-lazuli;buy_price=15;sell_price=4;meta=4
    - type=DIAMOND;name=Diamant;buy_price=320;sell_price=71;meta=0
    - type=EMERALD;name=Emeraude;buy_price=200;sell_price=44;meta=0
    - type=DIRT;name=Lingot d'argent;buy_price=410;sell_price=91;meta=0
    - type=DIRT;name=Lingot d'ura;buy_price=650;sell_price=144;meta=0
    - type=DIRT;name=Lingot de néodyme;buy_price=880;sell_price=195;meta=0
    - type=GLOWSTONE_DUST;name=Glowstone;buy_price=8;sell_price=1;meta=0
  ```


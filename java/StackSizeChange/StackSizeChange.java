package StackSizeChange;

import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = StackSizeChange.MOD_ID,
        name = StackSizeChange.MOD_NAME,
        version = StackSizeChange.MOD_VERSION,
        dependencies = StackSizeChange.MOD_DEPENDENCIES,
        useMetadata = true,
        acceptedMinecraftVersions = StackSizeChange.MOD_MC_VERSION)
public class StackSizeChange {

    public static final String MOD_ID = "StackSizeChange";
    public static final String MOD_NAME = "StackSizeChange";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[12.17.0.1965,)";
    public static final String MOD_MC_VERSION = "[1.9,1.10.99]";

    public static int itemSignMax;
    public static int itemDoorMax;
    public static int itemBedMax;
    public static int itemCakeMax;
    public static int itemBoatMax;
    public static int itemCartMax;
    public static int itemEggMax;
    public static int itemEnderMax;
    public static int itemSnowMax;
    public static int itemRecordMax;
    public static int itemSaddleMax;
    public static int itemBucketMax;
    //	public static int PotionMax;
//    public static int itemSoupMax;
//    public static int itemMilkMax;
    //	public static int BucketWaterMax;
//	public static int BucketLavaMax;
    public static int itemEnchantBookMax;
    //1.6より追加のアイテム
    public static int itemHorseArmorMax;

    public static int itemArmorStandMax;
    public static int itemBannerMax;

    //	public static boolean BucketReplace;
//	public static boolean addStackableBucket;
//	public static int StackableBucketID;
//	public static int SoupAmount;
//	public static boolean isNetherSetWater;
    public static boolean isStackCustom;

//	public static Item bucketEmpty;
//	public static Item bucketWater;
//	public static Item bucketLava;
//	public static Item bucketMilk;
//    public static Item bowlsoup;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        itemSignMax = config.get(Configuration.CATEGORY_GENERAL, "itemSignMax", 64, "Sign Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemDoorMax = config.get(Configuration.CATEGORY_GENERAL, "itemDoorMax", 64, "Door Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemBedMax = config.get(Configuration.CATEGORY_GENERAL, "itemBedMax", 64, "Bed Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemCakeMax = config.get(Configuration.CATEGORY_GENERAL, "itemCakeMax", 64, "Cake Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemBoatMax = config.get(Configuration.CATEGORY_GENERAL, "itemBoatMax", 64, "Boat Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemCartMax = config.get(Configuration.CATEGORY_GENERAL, "itemCartMax", 64, "Minecart Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemEggMax = config.get(Configuration.CATEGORY_GENERAL, "itemEggMax", 64, "Egg Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemEnderMax = config.get(Configuration.CATEGORY_GENERAL, "itemEnderMax", 64, "EnderParl Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemSnowMax = config.get(Configuration.CATEGORY_GENERAL, "itemSnowMax", 64, "Snowball Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemRecordMax = config.get(Configuration.CATEGORY_GENERAL, "itemRecordMax", 64, "Record Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemSaddleMax = config.get(Configuration.CATEGORY_GENERAL, "itemSaddleMax", 64, "Saddle Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemBucketMax = config.get(Configuration.CATEGORY_GENERAL, "itemBucketMax", 64, "Bucket Max Stack Size, min = 1, max = 64", 1, 64).getInt();
//		PotionMax = config.get(Configuration.CATEGORY_GENERAL, "PotionMax", 64, "Potion Max Stack Size, min = 1, max = 64").getInt();
//		PotionMax = (PotionMax<0)?1:(PotionMax>64)?64:PotionMax;
//        itemSoupMax = config.get(Configuration.CATEGORY_GENERAL, "itemSoupMax", 64, "Soup Max Stack Size, min = 1, max = 64", 1, 64).getInt();
//        itemMilkMax = config.get(Configuration.CATEGORY_GENERAL, "itemMilkMax", 64, "BucketMilk Max Stack Size, min = 1, max = 64", 1, 64).getInt();
//		BucketWaterMax = config.get(Configuration.CATEGORY_GENERAL, "BucketWaterMax", 64, "BucketWater Max Stack Size, min = 1, max = 64").getInt();
//		BucketWaterMax = (BucketWaterMax<1)?1:(BucketWaterMax>64)?64:BucketWaterMax;
//		BucketLavaMax = config.get(Configuration.CATEGORY_GENERAL, "BucketLavaMax", 64, "BucketLava Max Stack Size, min = 1, max = 64").getInt();
//		BucketLavaMax = (BucketLavaMax<1)?1:(BucketLavaMax>64)?64:BucketLavaMax;
        itemEnchantBookMax = config.get(Configuration.CATEGORY_GENERAL, "itemEnchantBookMax", 64, "EnchantableBook Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemHorseArmorMax = config.get(Configuration.CATEGORY_GENERAL, "itemHorseArmorMax", 64, "Horse Armor Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemArmorStandMax = config.get(Configuration.CATEGORY_GENERAL, "ArmorStandMax", 64, "Armor Stand Max Stack Size, min = 1, max = 64", 1, 64).getInt();
        itemBannerMax = config.get(Configuration.CATEGORY_GENERAL, "ArmorStandMax", 64, "Armor Stand Max Stack Size, min = 1, max = 64", 1, 64).getInt();
//		BucketReplace = config.get(Configuration.CATEGORY_GENERAL, "BucketReplace", true).getBoolean(true);
//		addStackableBucket = config.get(Configuration.CATEGORY_GENERAL, "addStackableBucket", false).getBoolean(false);
//		StackableBucketID = config.get(Configuration.CATEGORY_GENERAL, "StackableBucketID", 17250, "only use addStackableBacket=true. on use +0..+3 IDs, min = 4096, max = 31996").getInt();
//		StackableBucketID = (StackableBucketID<4096)?4096:(StackableBucketID>31996)?31996:StackableBucketID;
//		SoupAmount = config.get(Configuration.CATEGORY_GENERAL, "SoupAmount", 6, "1.2.5 = 8, 1.3.x = 6, min=1, max=20").getInt();
//		SoupAmount = (SoupAmount<1)?1:(SoupAmount>20)?20:SoupAmount;
//		isNetherSetWater = config.get(Configuration.CATEGORY_GENERAL, "isNetherSetWater", false,"true: I would like to put the water into a StackableBucket with Nether.").getBoolean(false);
//		isStackCustom = config.get(Configuration.CATEGORY_GENERAL, "isStackCustom", true, "true: Improve the operation of the stack").getBoolean(true);
//		
        config.save();
        Items.DARK_OAK_DOOR.setMaxStackSize(itemDoorMax);
        Items.ACACIA_DOOR.setMaxStackSize(itemDoorMax);
        Items.BIRCH_DOOR.setMaxStackSize(itemDoorMax);
        Items.JUNGLE_DOOR.setMaxStackSize(itemDoorMax);
        Items.OAK_DOOR.setMaxStackSize(itemDoorMax);
        Items.SPRUCE_DOOR.setMaxStackSize(itemDoorMax);
        Items.MINECART.setMaxStackSize(itemCartMax);
        Items.SADDLE.setMaxStackSize(itemSaddleMax);
        Items.IRON_DOOR.setMaxStackSize(itemDoorMax);
        Items.SNOWBALL.setMaxStackSize(itemSnowMax);
        Items.BOAT.setMaxStackSize(itemBoatMax);
        Items.CHEST_MINECART.setMaxStackSize(itemCartMax);
        Items.FURNACE_MINECART.setMaxStackSize(itemCartMax);
        Items.EGG.setMaxStackSize(itemEggMax);
        Items.CAKE.setMaxStackSize(itemCakeMax);
        Items.BED.setMaxStackSize(itemBedMax);
        Items.ENDER_PEARL.setMaxStackSize(itemEnderMax);
//		Items.potionitem.setMaxStackSize(PotionMax);
//        Items.MUSHROOM_STEW.setMaxStackSize(itemSoupMax);
        Items.RECORD_13.setMaxStackSize(itemRecordMax);
        Items.RECORD_CAT.setMaxStackSize(itemRecordMax);
        Items.RECORD_BLOCKS.setMaxStackSize(itemRecordMax);
        Items.RECORD_CHIRP.setMaxStackSize(itemRecordMax);
        Items.RECORD_FAR.setMaxStackSize(itemRecordMax);
        Items.RECORD_MALL.setMaxStackSize(itemRecordMax);
        Items.RECORD_MELLOHI.setMaxStackSize(itemRecordMax);
        Items.RECORD_STAL.setMaxStackSize(itemRecordMax);
        Items.RECORD_STRAD.setMaxStackSize(itemRecordMax);
        Items.RECORD_WARD.setMaxStackSize(itemRecordMax);
        Items.RECORD_11.setMaxStackSize(itemRecordMax);
        Items.RECORD_WAIT.setMaxStackSize(itemRecordMax);
        Items.ENCHANTED_BOOK.setMaxStackSize(itemEnchantBookMax);
        Items.TNT_MINECART.setMaxStackSize(itemCartMax);
        Items.HOPPER_MINECART.setMaxStackSize(itemCartMax);
        Items.ARMOR_STAND.setMaxStackSize(itemArmorStandMax);
        Items.BANNER.setMaxStackSize(itemBannerMax);

        Items.SIGN.setMaxStackSize(itemSignMax);
//        Items.BUCKET.setMaxStackSize(itemBucketMax);

        Items.DIAMOND_HORSE_ARMOR.setMaxStackSize(itemHorseArmorMax);
        Items.GOLDEN_HORSE_ARMOR.setMaxStackSize(itemHorseArmorMax);
        Items.IRON_HORSE_ARMOR.setMaxStackSize(itemHorseArmorMax);
//        Items.MILK_BUCKET.setMaxStackSize(itemMilkMax);
//        Items.water_bucket.setMaxStackSize(BucketWaterMax);
//        Items.lava_bucket.setMaxStackSize(BucketLavaMax);


//		MinecraftForge.EVENT_BUS.register((ItemSoupStack)Item.bowlSoup);

//		if(BucketReplace)
//		{
//			bucketEmpty = (new ItemBucketStack(Blocks.air)).setUnlocalizedName("bucket").setMaxStackSize(itemBucketMax).setTextureName("bucket_empty");
//			bucketWater = (new ItemBucketStack(Blocks.water)).setUnlocalizedName("bucketWater").setContainerItem(bucketEmpty).setMaxStackSize(BucketWaterMax).setTextureName("bucket_water");
//			bucketLava = (new ItemBucketStack(Blocks.lava)).setUnlocalizedName("bucketLava").setContainerItem(bucketEmpty).setMaxStackSize(BucketLavaMax).setTextureName("bucket_lava");
//			bucketMilk = (new ItemBucketMilkStack()).setUnlocalizedName("milk").setContainerItem(bucketEmpty).setMaxStackSize(itemMilkMax).setTextureName("bucket_milk");
//			
//			GameRegistry.registerItem(bucketEmpty, "bucket", "minecraft");
//			GameRegistry.registerItem(bucketWater, "water_bucket", "minecraft");
//			GameRegistry.registerItem(bucketLava, "lava_bucket", "minecraft");
//			GameRegistry.registerItem(bucketMilk, "milk_bucket", "minecraft");
//		}
//		if(!BucketReplace && addStackableBucket)
//		{
//			bucketEmpty = (new ItemBucketStack(Blocks.air)).setUnlocalizedName("stackbucket").setMaxStackSize(itemBucketMax).setTextureName("bucket_empty");
//			bucketWater = (new ItemBucketStack(Blocks.water)).setUnlocalizedName("stackbucketWater").setContainerItem(bucketEmpty).setMaxStackSize(BucketWaterMax).setTextureName("bucket_water");
//			bucketLava = (new ItemBucketStack(Blocks.lava)).setUnlocalizedName("stackbucketLava").setContainerItem(bucketEmpty).setMaxStackSize(BucketLavaMax).setTextureName("bucket_lava");
//			bucketMilk = (new ItemBucketMilkStack()).setUnlocalizedName("stackmilk").setContainerItem(bucketEmpty).setMaxStackSize(itemMilkMax).setTextureName("bucket_milk");
//			GameRegistry.registerItem(bucketEmpty, "bucket_stackable");
//			GameRegistry.registerItem(bucketWater, "water_bucket_stackable");
//			GameRegistry.registerItem(bucketLava, "lava_bucket_stackable");
//			GameRegistry.registerItem(bucketMilk, "milk_bucket_stackable");
//			addName(bucketEmpty, "Stackable Bucket",       "スタックバケツ");
//			addName(bucketWater, "Stackable Bucket Water", "スタック水入りバケツ");
//			addName(bucketLava,  "Stackable Bucket Lava",  "スタック溶岩入りバケツ");
//			addName(bucketMilk,  "Stackable Bucket Milk",  "スタック牛乳");
//			GameRegistry.addRecipe(new ItemStack(bucketEmpty, 2), new Object[]{ "I I","III"," I ", 'I',Items.iron_ingot });
//			GameRegistry.addShapelessRecipe(new ItemStack(bucketEmpty, 1), new Object[]{ Items.bucket });
//			GameRegistry.addShapelessRecipe(new ItemStack(Items.bucket, 1), new Object[]{ bucketEmpty });
//			GameRegistry.addRecipe(new ItemStack(Items.cake, 1), new Object[]
//				{ "MMM","SES","WWW", 'M',bucketMilk, 'S',Items.sugar, 'E',Items.egg, 'W',Items.wheat });
//		}
//		if(BucketReplace || addStackableBucket)
//		{
//			BehaviorSBucketFullDispense var2 = new BehaviorSBucketFullDispense();
//			BlockDispenser.field_149943_a.putObject(bucketLava, var2);
//			BlockDispenser.field_149943_a.putObject(bucketWater, var2);
//			BlockDispenser.field_149943_a.putObject(bucketEmpty, new BehaviorSBucketEmptyDispense());
//			MinecraftForge.EVENT_BUS.register((ItemBucketMilkStack)bucketMilk);
//		}
//		if(isStackCustom)
//		{
//			Item.potion = (ItemPotion)(new ItemPotionStack(117)).setUnlocalizedName("potion").setMaxStackSize(PotionMax).setTextureName("potion_bottle_empty");
//			Item.glassBottle = (new ItemGlassBottleStack(118)).setUnlocalizedName("glassBottle");
//		}
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ItemUseEventHook());
    }

//    public static ItemStack addropItems(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, ItemStack addItemStack) {
//        return addropItems(par1ItemStack, par3EntityPlayer, addItemStack, true);
//    }
//
//    public static ItemStack addropItems(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, ItemStack addItemStack, boolean dec) {
//        return addropItems(par1ItemStack, par3EntityPlayer, addItemStack, dec, false);
//    }
//
//    public static ItemStack addropItems(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, ItemStack addItemStack, boolean dec, boolean creativeDec) {
//        if (par3EntityPlayer.capabilities.isCreativeMode && !creativeDec || par1ItemStack == null) {
//            return par1ItemStack;
//        }
//
//        if (dec) {--par1ItemStack.stackSize;}
//
//        if (par1ItemStack.stackSize <= 0) {
//            if (!isStackCustom) return addItemStack;
//
//            boolean isStackable = false;
//            int slot = 0;
//            for (int i = 0; i < par3EntityPlayer.inventory.mainInventory.length; ++i) {
//                if (par3EntityPlayer.inventory.mainInventory[i] != null
//                        && par3EntityPlayer.inventory.mainInventory[i].getItem() == addItemStack.getItem()
//                        && par3EntityPlayer.inventory.mainInventory[i].stackSize < addItemStack.getMaxStackSize()) {
//                    isStackable = true;
//                    slot = i;
//                    break;
//                }
//            }
//
//            if (isStackable) {
//                par3EntityPlayer.inventory.addItemStackToInventory(addItemStack);
//                ItemStack result = par3EntityPlayer.inventory.mainInventory[slot];
//                par3EntityPlayer.inventory.mainInventory[slot] = null;
//                return result;
//            }
//            return addItemStack;
//        }
//
//        if (!par3EntityPlayer.inventory.addItemStackToInventory(addItemStack)) {
//            par3EntityPlayer.dropPlayerItemWithRandomChoice(addItemStack, false);
//        }
//
//        return par1ItemStack;
//
//    }
}

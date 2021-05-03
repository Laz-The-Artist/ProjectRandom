package multiteam.project_random.main.item;

import multiteam.project_random.ProjectRandom;
import multiteam.project_random.main.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> CABBAGE = Registration.ITEMS.register("cabbage", () -> new Item(new Item.Properties().tab(ProjectRandom.PROJECTRANDOM_LAZ).rarity(Rarity.UNCOMMON)));


    public static void register(){}
}

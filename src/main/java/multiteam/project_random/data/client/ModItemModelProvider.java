package multiteam.project_random.data.client;

import multiteam.multicore_lib.setup.utilities.data.ItemModelGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelGenerator {

    public ModItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blockitems
        //blockItem("withered_bone_block");


        //Regular Items
        //flatItem("acacia_bark");
    }
}

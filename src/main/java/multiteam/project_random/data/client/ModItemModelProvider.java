package multiteam.project_random.data.client;

import multiteam.project_random.ProjectRandom;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ProjectRandom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blockitems
        //withExistingParent("cabbage_bush", modLoc("block/cabbage_bush"));


        //Items
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        //Regular Items
        builder(itemGenerated, "cabbage");
        builder(itemGenerated, "cardboard_sheet");
        builder(itemGenerated, "glue_ball");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/"+name);
    }

}

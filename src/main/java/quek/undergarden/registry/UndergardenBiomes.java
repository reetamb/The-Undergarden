package quek.undergarden.registry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import quek.undergarden.UndergardenMod;
import quek.undergarden.biome.ForgottenAbyssBiome;
import quek.undergarden.world.gen.carver.UndergardenCaveWorldCarver;

public class UndergardenBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, UndergardenMod.MODID);

    public static final RegistryObject<Biome> FORGOTTEN_ABYSS = BIOMES.register("forgotten_abyss", ForgottenAbyssBiome::new);

    public static void addBiomeTypes()
    {
        BiomeDictionary.addTypes(FORGOTTEN_ABYSS.get(), BiomeDictionary.Type.WET);
    }

    public static void addBiomeFeatures() {
        for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
            if (biome instanceof ForgottenAbyssBiome) {
                ((ForgottenAbyssBiome)biome).addFeatures();
            }
        }
    }

    public static void addCarvers() {
        ForgottenAbyssBiome biome = (ForgottenAbyssBiome) FORGOTTEN_ABYSS.get();
        biome.addWorldCarver();
    }

}
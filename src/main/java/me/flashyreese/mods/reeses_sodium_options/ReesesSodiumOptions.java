package me.flashyreese.mods.reeses_sodium_options;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ReesesSodiumOptions.MODID)
public class ReesesSodiumOptions {

    public static Logger LOGGER = LogManager.getLogger("TexTrue's Sodium Options");

    public static final String MODID = "reeses_sodium_options";

    public static boolean rubidiumLoaded;
    public static boolean oculusLoaded;

    public ReesesSodiumOptions() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeClient);
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }

    public void onInitializeClient(final FMLClientSetupEvent event) {
        oculusLoaded = ModList.get().isLoaded("oculus");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");
    }
}

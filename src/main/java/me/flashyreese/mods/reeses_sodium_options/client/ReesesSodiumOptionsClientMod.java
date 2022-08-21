package me.flashyreese.mods.reeses_sodium_options.client;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.network.NetworkConstants;
//import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ReesesSodiumOptionsClientMod.MODID)
public class ReesesSodiumOptionsClientMod {

    public static Logger LOGGER = LogManager.getLogger("Reese's Sodium Options");

    private static String MOD_VERSION;

    public static final String MODID = "reeses_sodium_options";

    public static boolean rubidiumLoaded;
    public static boolean oculusLoaded;


    public ReesesSodiumOptionsClientMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeClient);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    }

    public void onInitializeClient(final FMLClientSetupEvent event) {

        oculusLoaded = ModList.get().isLoaded("oculus");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");

    }

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("Reese's Sodium Options");
        }

        return LOGGER;
    }

    public static String getVersion() {
        if (MOD_VERSION == null) {
            throw new NullPointerException("Mod version hasn't been populated yet");
        }

        return MOD_VERSION;
    }
}
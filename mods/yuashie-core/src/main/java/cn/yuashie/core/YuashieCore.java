package cn.yuashie.core;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Common entry point. Keep client-only classes out of this source set. */
public final class YuashieCore implements ModInitializer {
    public static final String MOD_ID = "yuashie_core";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Yuashie Core initialized.");
    }
}

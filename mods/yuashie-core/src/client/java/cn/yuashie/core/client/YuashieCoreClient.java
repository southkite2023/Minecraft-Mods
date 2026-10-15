package cn.yuashie.core.client;

import cn.yuashie.core.YuashieCore;
import net.fabricmc.api.ClientModInitializer;

/** Client-only entry point for future rendering, screens and key bindings. */
public final class YuashieCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YuashieCore.LOGGER.info("Yuashie Core client initialized.");
    }
}

package net.pulga22.hungerfires;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HungerFires implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hungurfires");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
    }
}
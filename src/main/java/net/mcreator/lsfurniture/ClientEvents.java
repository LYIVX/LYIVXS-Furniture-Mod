/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.lsfurniture as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.lsfurniture;

import net.mcreator.lsfurniture.init.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_OAK_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_DARK_OAK_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_SPRUCE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_ACACIA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_BIRCH_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_JUNGLE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_MANGROVE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_CRIMSON_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_WARPED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_OAK_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_DARK_OAK_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_SPRUCE_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_ACACIA_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_BIRCH_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_JUNGLE_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_MANGROVE_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_CRIMSON_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_WARPED_GLASS_CROSS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_OAK_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_DARK_OAK_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_SPRUCE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_ACACIA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_BIRCH_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_JUNGLE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_MANGROVE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_CRIMSON_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LsFurnitureModBlocks.CONNECTING_WARPED_GLASS_PANE.get(), RenderType.translucent());



    }
    @Mod("ls_furniture")
    public static class LsFurnitureMod {
        public static final Logger LOGGER = LogManager.getLogger(net.mcreator.lsfurniture.LsFurnitureMod.class);
        public static final String MODID = "ls_furniture";

        public LsFurnitureMod() {
            MinecraftForge.EVENT_BUS.register(this);
            LsFurnitureModTabs.load();
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            LsFurnitureModSounds.REGISTRY.register(bus);
            LsFurnitureModBlocks.REGISTRY.register(bus);
            LsFurnitureModItems.REGISTRY.register(bus);
            LsFurnitureModEntities.REGISTRY.register(bus);
            LsFurnitureModBlockEntities.REGISTRY.register(bus);

            LsFurnitureModParticleTypes.REGISTRY.register(bus);
            LsFurnitureModMenus.REGISTRY.register(bus);

            ModRecipes.register(bus);

            GeckoLib.initialize();
        }

        private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

        public static void queueServerWork(int tick, Runnable action) {
            workQueue.add(new AbstractMap.SimpleEntry(action, tick));
        }

        @SubscribeEvent
        public void tick(TickEvent.ServerTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
                workQueue.forEach(work -> {
                    work.setValue(work.getValue() - 1);
                    if (work.getValue() == 0)
                        actions.add(work);
                });
                actions.forEach(e -> e.getKey().run());
                workQueue.removeAll(actions);
            }
        }
    }


}




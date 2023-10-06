package net.mcreator.lsfurniture.block.display;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;

import net.minecraftforge.common.property.Properties;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.mcreator.lsfurniture.block.renderer.AcaciaDeskDisplayItemRenderer;

import java.util.function.Consumer;

public class AcaciaDeskDisplayItem extends BlockItem implements IAnimatable {
	public AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public AcaciaDeskDisplayItem(Block block, Properties settings) {
		super(block, settings);
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		return PlayState.CONTINUE;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new AcaciaDeskDisplayItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}
		});
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}

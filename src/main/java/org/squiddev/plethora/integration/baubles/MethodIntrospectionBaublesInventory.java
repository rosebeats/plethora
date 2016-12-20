package org.squiddev.plethora.integration.baubles;

import baubles.api.BaublesApi;
import dan200.computercraft.api.lua.LuaException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.squiddev.plethora.api.method.IContext;
import org.squiddev.plethora.api.method.IMethod;
import org.squiddev.plethora.api.method.IUnbakedContext;
import org.squiddev.plethora.api.module.IModuleContainer;
import org.squiddev.plethora.api.module.SubtargetedModuleObjectMethod;
import org.squiddev.plethora.gameplay.modules.PlethoraModules;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static org.squiddev.plethora.api.reference.Reference.id;

/**
 * Allows getting the player's baubles inventory
 */
@IMethod.Inject(value = IModuleContainer.class, modId = "Baubles")
public class MethodIntrospectionBaublesInventory extends SubtargetedModuleObjectMethod<EntityPlayer> {
	public MethodIntrospectionBaublesInventory() {
		super("getBaubles", PlethoraModules.INTROSPECTION, EntityPlayer.class, false, "function():table -- Get this player's baubles inventory");
	}

	@Nullable
	@Override
	public Object[] apply(@Nonnull EntityPlayer target, @Nonnull IContext<IModuleContainer> context, @Nonnull Object[] args) throws LuaException {
		IItemHandler inventory = new InvWrapper(BaublesApi.getBaubles(target));
		IUnbakedContext<IItemHandler> newContext = context.makeChild(id(inventory));
		return new Object[]{newContext.getObject()};
	}
}
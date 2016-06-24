package org.squiddev.plethora.api.reference;

import dan200.computercraft.api.lua.LuaException;

/**
 * A reference to an object
 */
public interface IReference<T> {
	/**
	 * Get the object if it still exists
	 *
	 * @return The object if it still exists
	 * @throws LuaException if the object doesn't exist
	 */
	T get() throws LuaException;
}
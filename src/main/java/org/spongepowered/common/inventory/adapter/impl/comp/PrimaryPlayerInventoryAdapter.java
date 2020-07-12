/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.inventory.adapter.impl.comp;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.PrimaryPlayerInventory;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.common.inventory.adapter.impl.BasicInventoryAdapter;
import org.spongepowered.common.inventory.fabric.Fabric;
import org.spongepowered.common.inventory.lens.impl.comp.PrimaryPlayerInventoryLens;

public class PrimaryPlayerInventoryAdapter extends BasicInventoryAdapter implements PrimaryPlayerInventory {

    private final PrimaryPlayerInventoryLens root;

    public PrimaryPlayerInventoryAdapter(Fabric fabric, PrimaryPlayerInventoryLens lens, Inventory parent) {
        super(fabric, lens, parent);
        this.root = lens;
    }

    @Override
    public Hotbar getHotbar() {
        return ((Hotbar) this.root.getHotbar().getAdapter(this.inventoryAdapter$getFabric(), this));
    }

    @Override
    public GridInventory asGrid() {
        return ((GridInventory) this.root.getFullGrid().getAdapter(this.inventoryAdapter$getFabric(), this));
    }

    @Override
    public GridInventory getStorage() {
        return ((GridInventory) this.root.getGrid().getAdapter(this.inventoryAdapter$getFabric(), this));
    }

}

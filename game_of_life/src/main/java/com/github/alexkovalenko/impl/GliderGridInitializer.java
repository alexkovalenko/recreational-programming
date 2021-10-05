package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;

public class GliderGridInitializer extends AbstractGridInitializer{

    public GliderGridInitializer() {
        super(25, 25);
    }

    @Override
    public Grid initialize() {
        Grid grid = initializeEmpty();
        grid.set(Cell.live(11, 11));
        grid.set(Cell.live(12, 12));
        grid.set(Cell.live(13, 10));
        grid.set(Cell.live(13, 11));
        grid.set(Cell.live(13, 12));
        return grid;
    }
}

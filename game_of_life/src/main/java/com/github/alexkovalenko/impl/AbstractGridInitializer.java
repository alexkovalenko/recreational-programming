package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;
import com.github.alexkovalenko.GridInitializer;

public abstract class AbstractGridInitializer implements GridInitializer {

    protected final int height;
    protected final int width;

    public AbstractGridInitializer(int height, int width) {
        this.height = height;
        this.width = width;
    }

    abstract public Grid initialize();

    @Override
    public Grid initializeEmpty() {
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = Cell.dead(i, j);
            }
        }
        return new ArrayGrid(grid);
    }
}

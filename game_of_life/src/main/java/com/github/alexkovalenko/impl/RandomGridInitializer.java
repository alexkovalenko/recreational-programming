package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;

import java.util.Random;

public class RandomGridInitializer extends AbstractGridInitializer {

    private final Random random;

    public RandomGridInitializer(int height, int width) {
        super(height, width);
        this.random = new Random();
    }

    @Override
    public Grid initialize() {
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = new Cell(getCellState(), i, j);
                grid[i][j] = cell;
            }
        }
        return new ArrayGrid(grid);
    }


    private CellState getCellState() {
        return random.nextInt(10) < 3 ? CellState.LIVE : CellState.DEAD;
    }
}

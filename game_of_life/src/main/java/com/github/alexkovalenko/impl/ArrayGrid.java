package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public record ArrayGrid(Cell[][] grid) implements Grid {

    @Override
    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int row = cell.getRow() + i;
                int column = cell.getColumn() + j;
                if (row == cell.getRow() && column == cell.getColumn()) {
                    continue;
                }
                if (inRange(row, column)) {
                    neighbors.add(grid[row][column]);
                }
            }
        }
        return neighbors;
    }

    @Override
    public void set(Cell cell) {
        grid[cell.getRow()][cell.getColumn()] = cell;
    }

    private boolean inRange(int row, int column) {
        return row >= 0 && row < grid.length
                && column >= 0 && column < grid[0].length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] row : grid) {
            builder.append(Arrays.toString(row));
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Iterator<Cell> iterator() {
        return new GridIterator(this.grid);
    }

    private static class GridIterator implements Iterator<Cell> {

        private final Cell[][] grid;
        private int row;
        private int column;

        public GridIterator(Cell[][] grid) {
            this.grid = grid;
        }

        @Override
        public boolean hasNext() {
            return row < grid.length && column < grid[0].length;
        }

        @Override
        public Cell next() {
            Cell cell = grid[row][column];
            if (column + 1 < grid[0].length) {
                column++;
            } else {
                column = 0;
                row++;
            }
            return cell;
        }
    }
}

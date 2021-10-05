package com.github.alexkovalenko.impl;

import java.util.Objects;

public class Cell {
    private final CellState state;
    private final int row;
    private final int column;

    public Cell(CellState state, int row, int column) {
        this.state = state;
        this.row = row;
        this.column = column;
    }

    public static Cell live(int row, int column) {
        return new Cell(CellState.LIVE, row, column);
    }

    public static Cell dead(int row, int column) {
        return new Cell(CellState.DEAD, row, column);
    }

    public CellState getState() {
        return state;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Cell) obj;
        return Objects.equals(this.state, that.state) &&
                this.row == that.row &&
                this.column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, row, column);
    }

    @Override
    public String toString() {
        return state.equals(CellState.LIVE) ? "1" : "0";
    }

}

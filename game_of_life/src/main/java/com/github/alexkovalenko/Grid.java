package com.github.alexkovalenko;

import com.github.alexkovalenko.impl.Cell;

import java.util.List;

public interface Grid extends Iterable<Cell> {

    void set(Cell cell);
    List<Cell> getNeighbors(Cell cell);
}

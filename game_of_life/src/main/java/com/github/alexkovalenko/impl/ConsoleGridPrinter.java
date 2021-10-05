package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;
import com.github.alexkovalenko.GridPrinter;

public class ConsoleGridPrinter implements GridPrinter {
    @Override
    public void print(Grid grid) {
        System.out.println(grid);
    }
}

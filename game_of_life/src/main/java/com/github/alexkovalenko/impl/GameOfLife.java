package com.github.alexkovalenko.impl;

import com.github.alexkovalenko.Grid;
import com.github.alexkovalenko.GridInitializer;
import com.github.alexkovalenko.Rule;
import com.github.alexkovalenko.impl.rule.RuleContext;

import java.util.List;
import java.util.Optional;

public class GameOfLife {

    private final GridInitializer initializer;
    private final List<Rule> rules;
    private Grid grid;

    public GameOfLife(GridInitializer initializer, List<Rule> rules) {
        this.rules = rules;
        this.initializer = initializer;
        this.grid = initializer.initialize();
    }

    public void nextGeneration() {
        Grid nextGeneration = initializer.initializeEmpty();
        for (Cell cell : grid) {
            List<Cell> neighbors = grid.getNeighbors(cell);
            RuleContext context = new RuleContext(cell.getState(), neighbors);
            testRules(context)
                    .filter(cellState -> cellState.equals(CellState.LIVE))
                    .ifPresent(cellState -> nextGeneration.set(Cell.live(cell.getRow(), cell.getColumn())));
        }
        this.grid = nextGeneration;
    }

    private Optional<CellState> testRules(RuleContext context) {
        return rules.stream()
                .flatMap(rule -> rule.test(context).stream())
                .findFirst();
    }

    public Grid getGrid() {
        return grid;
    }
}

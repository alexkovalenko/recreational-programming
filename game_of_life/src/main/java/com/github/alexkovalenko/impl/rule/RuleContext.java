package com.github.alexkovalenko.impl.rule;

import com.github.alexkovalenko.impl.Cell;
import com.github.alexkovalenko.impl.CellState;

import java.util.List;

public class RuleContext {
    private final CellState state;
    private final long liveCount;

    public RuleContext(CellState state, List<Cell> neighbors) {
        this.state = state;
        this.liveCount = neighbors.stream()
                .filter(c -> CellState.LIVE.equals(c.getState()))
                .count();
    }

    public CellState getState() {
        return state;
    }

    public long getLiveCount() {
        return liveCount;
    }
}

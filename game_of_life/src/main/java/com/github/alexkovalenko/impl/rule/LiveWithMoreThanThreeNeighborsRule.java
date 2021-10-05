package com.github.alexkovalenko.impl.rule;

import com.github.alexkovalenko.Rule;
import com.github.alexkovalenko.impl.CellState;

import java.util.Optional;


public class LiveWithMoreThanThreeNeighborsRule implements Rule {

    @Override
    public Optional<CellState> test(RuleContext context) {
        return Optional.of(context)
                .filter(c -> c.getState().equals(CellState.LIVE) && c.getLiveCount() > 3)
                .map(__ -> CellState.DEAD);
    }
}

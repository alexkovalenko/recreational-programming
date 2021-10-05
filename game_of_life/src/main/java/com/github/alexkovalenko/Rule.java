package com.github.alexkovalenko;

import com.github.alexkovalenko.impl.Cell;
import com.github.alexkovalenko.impl.CellState;
import com.github.alexkovalenko.impl.rule.RuleContext;

import java.util.List;
import java.util.Optional;

public interface Rule {
    Optional<CellState> test(RuleContext context);
}

package com.github.alexkovalenko;

import com.github.alexkovalenko.impl.ConsoleGridPrinter;
import com.github.alexkovalenko.impl.GameOfLife;
import com.github.alexkovalenko.impl.GliderGridInitializer;
import com.github.alexkovalenko.impl.RandomGridInitializer;
import com.github.alexkovalenko.impl.rule.*;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        //RandomGridInitializer randomGridInitializer = new RandomGridInitializer(10, 10);
        GliderGridInitializer gliderGridInitializer = new GliderGridInitializer();
        GridPrinter printer = new ConsoleGridPrinter();
        List<Rule> rules = List.of(
                new LiveWithFewerThanTwoNeighborsRule(),
                new LiveWithTwoOrThreeNeighborsRule(),
                new LiveWithMoreThanThreeNeighborsRule(),
                new DeadWithThreeNeighborsRule());
        GameOfLife game = new GameOfLife(gliderGridInitializer, rules);
        for (int i = 0; i < 10; i++) {
            printer.print(game.getGrid());
            game.nextGeneration();
        }
    }
}

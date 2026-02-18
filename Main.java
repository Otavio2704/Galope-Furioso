package horserace;

import horserace.engine.RaceEngine;
import horserace.engine.RaceResult;
import horserace.model.Horse;
import horserace.ui.ConsoleRenderer;
import horserace.ui.InputHandler;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        ConsoleRenderer renderer = new ConsoleRenderer();
        InputHandler    input    = new InputHandler();

        renderer.showWelcome();

        int         horseCount = input.askHorseCount();
        List<Horse> horses     = input.askHorseNames(horseCount);

        boolean running = true;
        while (running) {

            input.waitForStart();
            renderer.showCountdown();

            RaceEngine engine = new RaceEngine(horses, renderer);
            RaceResult result = engine.run();

            renderer.showResults(result);

            switch (input.askPostRace()) {
                case REMATCH -> {
                    for (Horse h : horses) h.reset();
                }
                case NEW_RACE -> {
                    renderer.clearScreen();
                    horseCount = input.askHorseCount();
                    horses     = input.askHorseNames(horseCount);
                }
                case QUIT -> running = false;
            }
        }

        input.close();
    }
}

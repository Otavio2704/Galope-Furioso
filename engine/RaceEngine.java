package horserace.engine;

import horserace.config.RaceConfig;
import horserace.model.Horse;
import horserace.ui.ConsoleRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RaceEngine {

    private final List<Horse>    horses;
    private final ConsoleRenderer renderer;
    private final Random          random;

    private final List<Horse> finishOrder;

    public RaceEngine(List<Horse> horses, ConsoleRenderer renderer) {
        this.horses      = horses;
        this.renderer    = renderer;
        this.random      = new Random();
        this.finishOrder = new ArrayList<>();
    }


    public RaceResult run() {
        int tick = 0;

        while (finishOrder.size() < horses.size()) {
            tick++;

            for (Horse horse : horses) {
                if (horse.isFinished()) continue;

                int steps = randomSteps();
                horse.advance(steps);

                if (horse.getPosition() >= RaceConfig.TRACK_LENGTH) {
                    horse.finish(finishOrder.size() + 1);
                    finishOrder.add(horse);
                }
            }

            renderer.render(horses, RaceConfig.TRACK_LENGTH);
            sleep(RaceConfig.TICK_DELAY_MS);
        }

        return new RaceResult(finishOrder, tick);
    }


    private int randomSteps() {
        return random.nextInt(RaceConfig.MAX_STEPS - RaceConfig.MIN_STEPS + 1)
                + RaceConfig.MIN_STEPS;
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

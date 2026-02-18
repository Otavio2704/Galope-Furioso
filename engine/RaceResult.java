package horserace.engine;

import horserace.model.Horse;
import java.util.Collections;
import java.util.List;


public class RaceResult {

    
    private final List<Horse> podium;

    private final int totalTicks;

    
    public RaceResult(List<Horse> podium, int totalTicks) {
        this.podium     = Collections.unmodifiableList(podium);
        this.totalTicks = totalTicks;
    }


    public List<Horse> getPodium() {
        return podium;
    }


    public Horse getWinner() {
        return podium.get(0);
    }


    public int getTotalTicks() {
        return totalTicks;
    }


    public int getTotalHorses() {
        return podium.size();
    }


    //  Utilitários

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RaceResult{\n");
        for (Horse h : podium) {
            sb.append(String.format("  %dº lugar: %s (posição final: %d)%n",
                    h.getFinishPosition(), h.getName(), h.getPosition()));
        }
        sb.append("  Ticks totais: ").append(totalTicks).append("\n}");
        return sb.toString();
    }
}

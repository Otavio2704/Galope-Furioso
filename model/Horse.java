package horserace.model;


public class Horse {

    private final String name;
    private int position;
    private boolean finished;
    private int finishPosition;

    public Horse(String name) {
        this.name      = name;
        this.position  = 0;
        this.finished  = false;
        this.finishPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getFinishPosition() {
        return finishPosition;
    }


    public void advance(int steps) {
        this.position += steps;
    }

    
    public void finish(int place) {
        this.finished       = true;
        this.finishPosition = place;
    }

    public void reset() {
        this.position       = 0;
        this.finished       = false;
        this.finishPosition = 0;
    }

    @Override
    public String toString() {
        return String.format("Horse{name='%s', position=%d, finished=%b, place=%d}",
                name, position, finished, finishPosition);
    }
}

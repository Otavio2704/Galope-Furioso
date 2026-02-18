package horserace.config;

public final class RaceConfig {

    private RaceConfig() {}

    public static final int TRACK_LENGTH = 90;
    public static final int NAME_DISPLAY_WIDTH = 12;

    public static final int MIN_STEPS = 1;
    public static final int MAX_STEPS = 4;

    public static final long TICK_DELAY_MS = 120;
    public static final long COUNTDOWN_DELAY_MS = 800;

    public static final int MIN_HORSES = 2;
    public static final int MAX_HORSES = 10;

    public static final String HORSE_SYMBOL = ">";
    public static final String TRACK_SYMBOL = "-";
    public static final String FINISH_LINE = "#";
    public static final String[] MEDALS = { "[1]", "[2]", "[3]" };
    public static final String TROPHY = "***";
}

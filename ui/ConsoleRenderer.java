package horserace.ui;

import horserace.config.RaceConfig;
import horserace.engine.RaceResult;
import horserace.model.Horse;
import java.util.List;


public class ConsoleRenderer {

    private static final String[] HORSE_RUN  = { "(>)" };
    private static final String[] HORSE_DONE = { "(|)" };

    
    private static final int HORSE_WIDTH = 3;


    public void showWelcome() {
        clearScreen();
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════╗");
        System.out.println("  ║                                                  ║");
        System.out.println("  ║           ./|,,/|                                ║");
        System.out.println("  ║          <   o o)          GALOPE  FURIOSO       ║");
        System.out.println("  ║         <\\ (    |                                ║");
        System.out.println("  ║       <\\\\  |\\   |   Velociade, Sorte e Glória    ║");
        System.out.println("  ║      <\\\\\\  | (__)                                ║");
        System.out.println("  ║    <\\\\\\\\   |                                     ║");
        System.out.println("  ║                                                  ║");
        System.out.println("  ╚══════════════════════════════════════════════════╝");
        System.out.println();
    }

    
    public void showCountdown() {
        String[][] frames = {
            {
                "  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557",
                "  \u2551    Preparar os cavalos...       \u2551",
                "  \u2551                                 \u2551",
                "  \u2551           3 . . .               \u2551",
                "  \u2551                                 \u2551",
                "  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d"
            },
            {
                "  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557",
                "  \u2551    Na linha de largada...       \u2551",
                "  \u2551                                 \u2551",
                "  \u2551             2 . .               \u2551",
                "  \u2551                                 \u2551",
                "  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d"

            },
            {
                "  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557",
                "  \u2551    Prontos para correr...       \u2551",
                "  \u2551                                 \u2551",
                "  \u2551               1 .               \u2551",
                "  \u2551                                 \u2551",
                "  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d"
            },
            {
                "  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557",
                "  \u2551   ========================      \u2551",
                "  \u2551         V  A  I  !              \u2551",
                "  \u2551        (*) (*) (*)              \u2551",
                "  \u2551   ========================      \u2551",
                "  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d"
            }
        };

        for (String[] frame : frames) {
            clearScreen();
            System.out.println();
            for (String line : frame) {
                System.out.println(line);
            }
            System.out.println();
            sleep(RaceConfig.COUNTDOWN_DELAY_MS);
        }
    }

    
    public void render(List<Horse> horses, int trackLength) {
        clearScreen();

        // Cabecalho da pista
        int totalWidth = trackLength + RaceConfig.NAME_DISPLAY_WIDTH + HORSE_WIDTH + 4;
        System.out.println();
        System.out.println("  \u2554" + "\u2550".repeat(totalWidth) + "\u2557");
        System.out.println("  \u2551" + center("- - -  CORRIDA EM ANDAMENTO  - - -", totalWidth) + "\u2551");
        System.out.println("  \u2560" + "\u2550".repeat(totalWidth) + "\u2563");

        for (int i = 0; i < horses.size(); i++) {
            renderLane(horses.get(i), trackLength, totalWidth);
        }

        System.out.println("  \u255a" + "\u2550".repeat(totalWidth) + "\u255d");
        System.out.println();
    }

    
    private void renderLane(Horse horse, int trackLength, int totalWidth) {
        String displayName = truncate(horse.getName(), RaceConfig.NAME_DISPLAY_WIDTH);
        String paddedName  = String.format("%-" + RaceConfig.NAME_DISPLAY_WIDTH + "s", displayName);
        String emptyName   = " ".repeat(RaceConfig.NAME_DISPLAY_WIDTH);

        int pos = Math.min(horse.getPosition(), trackLength);

        String trackBefore = "~".repeat(pos);
        String trackAfter  = "~".repeat(trackLength - pos);

        String[] art = horse.isFinished() ? HORSE_DONE : HORSE_RUN;


        String placeTag = horse.isFinished()
                ? String.format("  %do", horse.getFinishPosition())
                : "";

        // Linha unica: nome + trilha + cavalo + trilha + borda + tag
        System.out.printf("  \u2551 %s |%s%-3s%s| #%s%n",
                paddedName, trackBefore, art[0], trackAfter, placeTag);
    }

    
    public void showResults(RaceResult result) {
        clearScreen();
        System.out.println();

        // Banner de fim de corrida
        System.out.println("  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("  \u2551                                                  \u2551");
        System.out.println("  \u2551        *** F I M   D E   C O R R I D A ***       \u2551");
        System.out.println("  \u2551                                                  \u2551");
        System.out.println("  \u255f\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2562");

        // Vencedor em destaque com troféu ASCII
        String winner = result.getWinner().getName().toUpperCase();
        System.out.println("  \u2551    ___________                                   \u2551");
        System.out.println("  \u2551   '._==_==_=_.'   VENCEDOR:                      \u2551");
        System.out.println("  \u2551   .-\\:      /-.                                  \u2551");
        System.out.printf ("  \u2551  | (|:.     |) |  %-31s\u2551%n", winner);
        System.out.println("  \u2551   '-|:.     |-'                                  \u2551");
        System.out.println("  \u2551     \\::.    /                                    \u2551");
        System.out.println("  \u2551      '::. .'                                     \u2551");
        System.out.println("  \u2551        ) (                                       \u2551");
        System.out.println("  \u2551      _.' '._                                     \u2551");
        System.out.println("  \u2551     '-------'                                    \u2551");
        System.out.println("  \u2551                                                  \u2551");

        // Podio
        System.out.println("  \u255f\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2562");
        System.out.println("  \u2551           C L A S S I F I C A C A O              \u2551");
        System.out.println("  \u255f\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2562");

        List<Horse> podium = result.getPodium();

        for (int i = 0; i < podium.size(); i++) {
            String medal = i < RaceConfig.MEDALS.length ? RaceConfig.MEDALS[i] : "   ";
            String place = (i + 1) + "o";
            System.out.printf("  \u2551   %s  %-3s  %-37s\u2551%n",
                    medal, place, podium.get(i).getName());
        }

        System.out.println("  \u255f\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2562");
        System.out.printf ("  \u2551   Corrida concluida em %d ticks.%s\u2551%n",
                result.getTotalTicks(),
                " ".repeat(19 - String.valueOf(result.getTotalTicks()).length()));
        System.out.println("  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
        System.out.println();
    }

    
    private String center(String text, int width) {
        int padding = (width - text.length()) / 2;
        int extra   = (width - text.length()) % 2;
        return " ".repeat(padding) + text + " ".repeat(padding + extra);
    }

    
    public void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    
    private String truncate(String text, int maxLength) {
        if (text.length() <= maxLength) return text;
        return text.substring(0, maxLength - 1) + ".";
    }

    
    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package horserace.ui;

import horserace.config.RaceConfig;
import horserace.model.Horse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int askHorseCount() {
        System.out.printf("%n  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557%n");
        System.out.printf("  \u2551  Quantos cavalos vao correr? (%d-%d)    \u2551%n",
                RaceConfig.MIN_HORSES, RaceConfig.MAX_HORSES);
        System.out.printf("  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d%n");
        System.out.print("  > ");

        while (true) {
            String raw = scanner.nextLine().trim();

            try {
                int count = Integer.parseInt(raw);

                if (count >= RaceConfig.MIN_HORSES && count <= RaceConfig.MAX_HORSES) {
                    return count;
                }

                System.out.printf("  [!] Digite um numero entre %d e %d: ",
                        RaceConfig.MIN_HORSES, RaceConfig.MAX_HORSES);

            } catch (NumberFormatException e) {
                System.out.print("  [!] Entrada invalida. Digite um numero: ");
            }
        }
    }

    public List<Horse> askHorseNames(int count) {
        System.out.printf("%n  Otimo! Agora de um nome para cada cavalo.%n%n");

        List<Horse>  horses     = new ArrayList<>();
        List<String> usedNames  = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            System.out.printf("  Cavalo #%d - nome: ", i);

            while (true) {
                String name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.print("  [!] O nome nao pode ser vazio. Tente novamente: ");
                    continue;
                }

                if (usedNames.contains(name.toLowerCase())) {
                    System.out.printf(
                            "  [!] Ja existe um cavalo chamado \"%s\". Use outro nome: ", name);
                    continue;
                }

                horses.add(new Horse(name));
                usedNames.add(name.toLowerCase());
                break;
            }
        }

        return horses;
    }

    public enum PostRaceChoice {
        REMATCH,
        NEW_RACE,
        QUIT
    }

    public PostRaceChoice askPostRace() {
        System.out.println();
        System.out.println("  \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("  \u2551          O QUE DESEJA FAZER?               \u2551");
        System.out.println("  \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
        System.out.println("  \u2551  1 - Correr de novo (mesmos cavalos)       \u2551");
        System.out.println("  \u2551  2 - Nova corrida (cavalos diferentes)     \u2551");
        System.out.println("  \u2551  3 - Sair                                  \u2551");
        System.out.println("  \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
        System.out.print("  > ");

        while (true) {
            String raw = scanner.nextLine().trim();

            switch (raw) {
                case "1": return PostRaceChoice.REMATCH;
                case "2": return PostRaceChoice.NEW_RACE;
                case "3": return PostRaceChoice.QUIT;
                default:
                    System.out.print("  [!] Digite 1, 2 ou 3: ");
            }
        }
    }

    public void waitForStart() {
        System.out.printf("%n  Pressione ENTER para iniciar a corrida...");
        scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}

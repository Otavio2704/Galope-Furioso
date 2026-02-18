# 🐎 Galope Furioso

Simulador de corrida de cavalos no terminal, feito em Java. Com animações em tempo real, placar final e suporte a múltiplas corridas.

---

## 🎮 Como funciona

1. Informe quantos cavalos vão correr (2 a 10)
2. Dê um nome para cada cavalo
3. Pressione **ENTER** para iniciar
4. Acompanhe a corrida em tempo real no terminal
5. Veja o pódio e escolha o que fazer a seguir

---

## ✨ Funcionalidades

- Animação da pista atualizada a cada tick (120ms)
- Contagem regressiva animada antes da largada
- Movimentação aleatória por cavalo (1 a 4 passos por tick)
- Exibição de posição e ordem de chegada ao vivo
- Tela de resultados com troféu e pódio completo
- Opções pós-corrida: revanche, nova corrida ou sair
- Validação de entradas (nomes duplicados, valores inválidos)

---

## 🗂️ Estrutura do projeto

```
horserace/
├── Main.java
├── config/
│   └── RaceConfig.java       # Constantes globais (tamanho da pista, delays, limites)
├── engine/
│   ├── RaceEngine.java       # Lógica principal da corrida
│   └── RaceResult.java       # Resultado e pódio
├── model/
│   └── Horse.java            # Modelo do cavalo
└── ui/
    ├── ConsoleRenderer.java  # Renderização no terminal
    └── InputHandler.java     # Leitura e validação de entradas do usuário
```

---

## ▶️ Como rodar

### Pré-requisitos

- Java 14 ou superior (para `switch` com `->` e expressões de pattern)

### Compilar

```bash
javac -d out $(find . -name "*.java")
```

### Executar

```bash
java -cp out horserace.Main
```

> **Dica:** Use um terminal com suporte a escape ANSI (como o terminal padrão do Linux/macOS ou o Windows Terminal) para a animação de limpeza de tela funcionar corretamente.

---

## ⚙️ Configurações

Todas as constantes da corrida ficam em `config/RaceConfig.java` e podem ser alteradas facilmente:

| Constante           | Valor padrão | Descrição                          |
|---------------------|--------------|------------------------------------|
| `TRACK_LENGTH`      | 90           | Comprimento da pista               |
| `MIN_STEPS`         | 1            | Mínimo de passos por tick          |
| `MAX_STEPS`         | 4            | Máximo de passos por tick          |
| `TICK_DELAY_MS`     | 120          | Delay entre frames (ms)            |
| `COUNTDOWN_DELAY_MS`| 800          | Delay da contagem regressiva (ms)  |
| `MIN_HORSES`        | 2            | Mínimo de cavalos                  |
| `MAX_HORSES`        | 10           | Máximo de cavalos                  |

---

## 📄 Licença

Distribuído sob a licença [MIT](LICENSE).

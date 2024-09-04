package de.oose.breakout.statistics;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class StatisticToolTests {
    private List<String> logLines = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        logLines.add("2024-09-04 15:11:57,040 [JavaFX Application Thread] INFO  (Breakout.java) - start");
        logLines.add("2024-09-04 15:13:31,638 [JavaFX Application Thread] INFO  (Breakout.java) - found token: Token [character=S, points=80]");
        logLines.add("2024-09-04 15:13:31,650 [JavaFX Application Thread] INFO  (Breakout.java) - hit Tile");
        logLines.add("2024-09-04 15:13:38,395 [JavaFX Application Thread] INFO  (Breakout.java) - hit Tile");
        logLines.add("2024-09-04 15:13:45,145 [JavaFX Application Thread] INFO  (Breakout.java) - hit Tile");
        logLines.add("2024-09-04 15:13:45,145 [JavaFX Application Thread] INFO  (Breakout.java) - next ball");
        logLines.add("2024-09-04 15:14:05,249 [JavaFX Application Thread] INFO  (Breakout.java) - stop");
    }

}

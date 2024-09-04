package de.oose.breakout.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatisticToolTests {
    private List<String> logLines = new ArrayList<>();

    @Spy
    private StatisticTool statisticToolSpy;

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

    private class StatisticToolForTest extends StatisticTool {
        @Override
        protected List<String> fileOperation(String logFile) {
            return logLines;
        }
    }

    @Test
    void testgetPrettyStatisticsString() {
        StatisticTool statisticTool = new StatisticTool() {
            @Override
            protected List<String> fileOperation(String logFile) {
                return logLines;
            }
        };

        doReturn(logLines).when(statisticToolSpy).fileOperation(anyString());

        String expected = "Time played: 2 Minutes\n" +
                "Tiles hit: 3\n" +
                "Balls used: 1";
        assertEquals(expected, statisticToolSpy.getPrettyStatisticsString());
        verify(statisticToolSpy, times(3)).fileOperation(anyString());
    }

}

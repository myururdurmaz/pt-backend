package com.github.pt.xlsx;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class XlsxModifierTest {

    @Test
    public void updateCellData() throws IOException {
        try (InputStream stream = XlsxParserTest.class.getResourceAsStream("test-program2.xlsx")) {
            XlsxModifier xlsxModifier = XlsxModifier.of(stream);
            List<ExcelUser> excelUsers = Arrays.asList(
                    new ExcelUser()
                        .setSheetIndex(0)
                        .setWorkouts(Arrays.asList(
                                new Workout().setWorkoutItems(Arrays.asList(
                                        new WorkoutItem()
                                                .setInput(new Input()
                                                        .setSets(1)
                                                        .setRepetitions(5)
                                                        .setWeight(10)
                                                )
                                                .setOutput(new Output()
                                                        .setSets(1)
                                                .setRepetitions(Arrays.asList(5, 6))
                                                .setWeights(Arrays.asList(15, 16))))))));
            xlsxModifier.updateCellData(new ByteArrayOutputStream(), excelUsers);
        }
    }

}
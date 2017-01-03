package com.osomapps.pt.admin.exercise;

import com.osomapps.pt.exercises.ExerciseFileRepository;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminExerciseFileServiceTest {

    @Mock
    private ExerciseFileRepository exerciseFileRepository;    

    @InjectMocks
    private AdminExerciseFileService adminExerciseFileService;

    @Test
    public void findOne() {
        adminExerciseFileService.findAll(Arrays.asList(1L));
        verify(exerciseFileRepository).findAll(eq(Arrays.asList(1L)));
    }
}
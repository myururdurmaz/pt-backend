package com.github.pt.admin.exercise;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminExerciseResourceTest {

    @Mock
    private AdminExerciseService adminExerciseService;    
    
    @InjectMocks
    private AdminExerciseResource adminExerciseResource;

    @Test
    public void create() {
        adminExerciseResource.create(new ExerciseRequestDTO());
        verify(adminExerciseService).create(any(ExerciseRequestDTO.class));
    }

    public void delete() throws Exception {
        adminExerciseResource.delete(1L);
        verify(adminExerciseService).delete(anyLong());
    }
}
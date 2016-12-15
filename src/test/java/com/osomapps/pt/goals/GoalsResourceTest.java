package com.osomapps.pt.goals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GoalsResourceTest {

    @Mock
    private GoalService goalService;    

    @InjectMocks
    private GoalsResource goalsResource;

    @Test
    public void findAll() {
        goalsResource.findAll("");
        verify(goalService).findAll(eq(""));
    }
}

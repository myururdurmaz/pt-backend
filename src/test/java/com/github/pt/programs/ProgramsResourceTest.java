package com.github.pt.programs;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.runner.RunWith;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProgramsResourceTest {

    @Mock
    private ProgramService programService;    

    @InjectMocks
    private ProgramsResource programsResource;

    @Test
    public void findAll() throws Exception {
        programsResource.findAll("");
        verify(programService).getPredefinedPrograms(eq(""));
    }
}

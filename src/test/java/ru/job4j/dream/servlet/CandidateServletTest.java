package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CandidateServletTest {
    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Candidate name");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        assertThat(candidate, notNullValue());
    }

    @Test
    public void whenCreateThenEditPost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DbStore.instOf().saveCandidate(new Candidate(0, "name"));
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("edit name");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        assertThat("edit name", is(candidate.getName()));
    }

}
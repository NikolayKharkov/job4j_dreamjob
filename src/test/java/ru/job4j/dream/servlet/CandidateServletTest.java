package ru.job4j.dream.servlet;

import org.junit.Ignore;
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
    @Ignore
    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Candidate name");
        when(req.getParameter("city")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(2);
        assertThat(candidate, notNullValue());
    }

    @Ignore
    @Test
    public void whenCreateThenEditPost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Candidate can = new Candidate(0, "name", 1);
        DbStore.instOf().saveCandidate(can);
        when(req.getParameter("id")).thenReturn(String.valueOf(can.getId()));
        when(req.getParameter("name")).thenReturn(String.valueOf(can.getName()));
        when(req.getParameter("city")).thenReturn(String.valueOf(can.getCityId()));
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(2);
        assertThat("edit name", is(candidate.getName()));
    }
}
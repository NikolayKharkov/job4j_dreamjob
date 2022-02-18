package ru.job4j.dream.servlet;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.dream.model.Post;
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

public class PostServletTest {
    @Ignore
    @Test
    public void whenCreatePost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new post");
        when(req.getParameter("description")).thenReturn("post description");
        new PostServlet().doPost(req, resp);
        Post post = DbStore.instOf().findPostById(1);
        assertThat(post, notNullValue());
    }

    @Ignore
    @Test
    public void whenCreateThenEditPost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Post pt = new Post(0, "name", "post description");
        DbStore.instOf().savePost(pt);
        when(req.getParameter("id")).thenReturn(String.valueOf(pt.getId()));
        when(req.getParameter("name")).thenReturn("edit name");
        when(req.getParameter("description")).thenReturn("post description");
        new PostServlet().doPost(req, resp);
        Post post = DbStore.instOf().findPostById(1);
        assertThat("edit name", is(post.getName()));
    }
}
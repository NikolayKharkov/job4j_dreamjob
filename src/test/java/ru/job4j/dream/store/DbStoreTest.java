package ru.job4j.dream.store;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class DbStoreTest {
    @Ignore
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job", "Desc");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Ignore
    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "name", 1);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Ignore
    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job", "Desc");
        store.savePost(post);
        post.setName("Update");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Ignore
    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "name", 1);
        store.saveCandidate(candidate);
        candidate.setName("Java Middle");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is("Java Middle"));
    }

    @Ignore
    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "name", 1);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        store.deleteCandidate(candidateInDb.getId());
        assertNull(store.findCandidateById(candidateInDb.getId()));
    }
}
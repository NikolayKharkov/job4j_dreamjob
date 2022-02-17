package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.savePost(new Post(0, "Post1", "Desc1"));
        store.savePost(new Post(0, "Post2", "Desc2"));
        store.savePost(new Post(0, "Post3", "Desc3"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        store.savePost(new Post(21, "PostUpdated", "Desc3"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        store.saveCandidate(new Candidate(0, "Name1", 1));
        store.saveCandidate(new Candidate(0, "Name2", 1));
        store.saveCandidate(new Candidate(0, "Name3", 1));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }
        store.saveCandidate(new Candidate(1, "NameUpdated", 1));
        store.deleteCandidate(2);
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }
    }
}
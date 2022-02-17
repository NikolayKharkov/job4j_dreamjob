package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void savePost(Post post);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    void saveCandidate(Candidate candidate);

    void deleteCandidate(int id);

    void saveUser(User user);

    User findUserByEmail(String email);

    Collection<Post> findAllTodayPosts();

    Collection<Candidate> findAllTodayCandidates();

    Collection<City> findAllCities();
}
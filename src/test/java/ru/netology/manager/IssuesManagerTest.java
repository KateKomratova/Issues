package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {

    private IssuesRepository repo = new IssuesRepository();
    private IssuesManager manager = new IssuesManager(repo);

    private Issue issue1 = new Issue(5, "task1", "Svetlana", "new1",
            new HashSet<>(Arrays.asList("Nikolai", "Tanja", "Oleg")),
            new HashSet<>(Arrays.asList("jupiter", "kotlin", "OTA")), true);

    private Issue issue2 = new Issue(8, "task2", "Katerina", "new5",
            new HashSet<>(Arrays.asList("Tamara", "Stepan", "Oleg")),
            new HashSet<>(Arrays.asList("invalid", "new", "in progress")), false);

    private Issue issue3 = new Issue(11, "task3", "Svetlana", "new10",
            new HashSet<>(Arrays.asList("Tamara", "Stepan", "Oleg")),
            new HashSet<>(Arrays.asList("invalid", "new", "in progress")), true);


    @Test
    void shouldFindByAuthor() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue1, issue3));
        Set<Issue> actual = manager.searchByAuthor("Svetlana");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByOneAuthor() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue2));
        Set<Issue> actual = manager.searchByAuthor("Katerina");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNonExistentAuthor() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>();
        Set<Issue> actual = manager.searchByAuthor("Tamara");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByLabels() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>();
        Set<Issue> actual = manager.searchByLabels(new HashSet<String>(Arrays.asList("discovery", "hhh", "opened")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByOneLabels() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue1));
        Set<Issue> actual = manager.searchByLabels(new HashSet<String>(Arrays.asList("jupiter", "kotlin", "OTA")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByTwoLabels() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue2, issue3));
        Set<Issue> actual = manager.searchByLabels(new HashSet<String>(Arrays.asList("invalid", "new", "in progress")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAssignee() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue1));
        Set<Issue> actual = manager.searchByAssignee(new HashSet<String>(Arrays.asList("Nikolai", "Tanja", "Oleg")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByTwoAssignee() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of(issue2,issue3));
        Set<Issue> actual = manager.searchByAssignee(new HashSet<String>(Arrays.asList("Tamara", "Stepan", "Oleg")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNonExistentAssignee() {
        manager.addAll(List.of(issue1, issue2, issue3));
        Set<Issue> expected = new HashSet<>(List.of());
        Set<Issue> actual = manager.searchByAssignee(new HashSet<String>(Arrays.asList("Olga", "Stepan", "Oleg")));
        assertEquals(expected, actual);
    }
}




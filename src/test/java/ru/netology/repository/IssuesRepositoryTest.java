package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssuesRepositoryTest {
    private IssuesRepository repo = new IssuesRepository();

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
    void shouldFindByOpenIssue() {
        repo.saveAll(List.of(issue1, issue2, issue3));
        List<Issue> expected = new ArrayList<>(List.of(issue1, issue3));
        List<Issue> actual = repo.findOpenIssues();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByClosedIssue() {
        repo.saveAll(List.of(issue1, issue2, issue3));
        List<Issue> expected = new ArrayList<>(List.of(issue2));
        List<Issue> actual = repo.findClosedIssues();
        assertEquals(expected, actual);
    }
}
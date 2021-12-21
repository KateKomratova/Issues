package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.*;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepository repository;

    public IssuesManager(IssuesRepository repository) {
        this.repository = repository;
    }

    public void add(Issue item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void closeById(int id) {
        repository.closeById(id);
    }

    public void openById(int id) {
        repository.openById(id);
    }

    public List<Issue> findOpenIssues() {
        return repository.findOpenIssues();
    }

    public List<Issue> findClosedIssues() {
        return repository.findClosedIssues();
    }

    public void addAll(List<Issue> issues) {
        repository.saveAll(issues);
    }

    private Set<Issue> filterBy(Predicate<Issue> filter) {
        Set<Issue> result = new HashSet<>();
        for (Issue issue : repository.findAll()) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public Set<Issue> searchByAuthor(String text) {
        return filterBy(issue -> issue.getAuthor().equalsIgnoreCase(text));
    }

    public Set<Issue> searchByLabels(Set<String> label) {
        return filterBy(issue -> issue.getLabels().equals(label));
    }

    public Set<Issue> searchByAssignee(Set<String> assignee) {
        return filterBy(issue -> issue.getAssignee().equals(assignee));
    }
}

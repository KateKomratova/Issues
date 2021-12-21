package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssuesRepository {
    private List<Issue> items = new ArrayList<>();

    public void save(Issue item) {
        items.add(item);
    }

    public List<Issue> findAll() {
        return items;
    }

    public void removeById(int id) {
        items.removeIf(el -> el.getId() == id);
    }

    public void saveAll(List<Issue> issues) {
        items.addAll(issues);
    }

    public List<Issue> findOpenIssues() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items) {
            if (item.isOpen()) {
                issues.add(item);
            }
        }
        return issues;
    }

    public List<Issue> findClosedIssues() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items) {
            if (!item.isOpen()) {
                issues.add(item);
            }
        }
        return issues;
    }

    public void closeById(int id) {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items) {
            if (item.getId() == id && item.isOpen()) {
                item.setOpen(false);
            }
        }
    }

    public void openById(int id) {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items) {
            if (item.getId() == id && !item.isOpen()) {
                item.setOpen(true);
            }
        }
    }
}


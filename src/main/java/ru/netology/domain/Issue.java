package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    private int id;
    private String Name;
    private String Author;
    private String Projects;
    private Set<String> Assignee = new HashSet<>();
    private Set<String> Labels = new HashSet<>();
    private boolean isOpen;


}

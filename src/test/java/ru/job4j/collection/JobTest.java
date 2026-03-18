package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByAscName() {
        List<Job> jobs = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2),
                new Job("X task", 0)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenComparatorByDescName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2),
                new Job("X task", 0)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Implement task №2", 2),
                new Job("Implement task №1", 1),
                new Job("Fix bug №2", 4),
                new Job("Fix bug №1", 3)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenComparatorByAscPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2),
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenComparatorByDescPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug №1", 3),
                new Job("Fix bug №2", 4),
                new Job("Implement task №1", 1),
                new Job("Implement task №2", 2)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Fix bug №2", 4),
                new Job("Fix bug №1", 3),
                new Job("Implement task №2", 2),
                new Job("Implement task №1", 1),
                new Job("X task", 0)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}
package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScores = 0D;
        double numberElements = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScores = sumScores + subject.score();
                numberElements++;
            }
        }
        return sumScores / numberElements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sumScores;
        double numberElements;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sumScores = 0D;
            numberElements = 0D;
            for (Subject subject : pupil.subjects()) {
                sumScores = sumScores + subject.score();
                numberElements++;
            }
            Label label = new Label(pupil.name(), sumScores / numberElements);
            labelList.add(label);
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int numberElements = 0;
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> sumScoreSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoreSubject.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + newValue);
            }
            numberElements++;
        }
        for (String string : sumScoreSubject.keySet()) {
            Label label = new Label(string, (double) sumScoreSubject.get(string) / numberElements);
            labelList.add(label);
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sumScores;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sumScores = 0D;
            for (Subject subject : pupil.subjects()) {
                sumScores = sumScores + subject.score();
            }
            labelList.add(new Label(pupil.name(), sumScores));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> sumScoreSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoreSubject.merge(subject.name(), subject.score(), (oldScore, newScore) -> oldScore + newScore);
            }
        }
        for (String string : sumScoreSubject.keySet()) {
            labelList.add(new Label(string, (double) sumScoreSubject.get(string)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}
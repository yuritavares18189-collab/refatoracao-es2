package br.ufpa.refactoring.q4;

import java.util.ArrayList;
import java.util.List;

public class RecentFiles {

    private final int limit;
    private final List<String> files = new ArrayList<>();

    public RecentFiles(int limit) {
        this.limit = limit;
    }

    public void addFile(String path) {
        files.remove(path);
        files.add(0, path);
        while (files.size() > limit) files.remove(files.size() - 1);
    }

    public int size() {
        return files.size();
    }

    public String get(int index) {
        return files.get(index);
    }
}

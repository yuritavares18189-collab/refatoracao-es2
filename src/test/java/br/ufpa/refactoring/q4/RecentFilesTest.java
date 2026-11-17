package br.ufpa.refactoring.q4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecentFilesTest {

    @Test
    void addFile_shouldKeepMostRecentFirst_andRespectLimit() {
        RecentFiles rf = new RecentFiles(3);

        rf.addFile("/a");
        rf.addFile("/b");
        rf.addFile("/c");
        rf.addFile("/d");

        assertEquals(3, rf.size());
        assertEquals("/d", rf.get(0));
        assertEquals("/c", rf.get(1));
        assertEquals("/b", rf.get(2));
    }

    @Test
    void refactorGoal_replaceInheritanceWithDelegation() {
        // TODO: após refatorar, RecentFiles NÃO deve estender ArrayList (verificar em code review).
    }
}

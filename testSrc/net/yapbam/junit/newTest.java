package net.yapbam.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import net.yapbam.update.ReleaseInfo;

public class newTest {

    @Test
    public void testCompareToBothUnknown() {
        ReleaseInfo thisRelease = new ReleaseInfo("");
        ReleaseInfo otherRelease = new ReleaseInfo("");

        assertEquals(0, thisRelease.compareTo(otherRelease));
    }

    @Test
    public void testCompareToReleaseUnknown() {
        ReleaseInfo thisRelease = new ReleaseInfo("");
        ReleaseInfo otherRelease = new ReleaseInfo("1.0.0 (30/01/2012)");

        assertEquals(-1, thisRelease.compareTo(otherRelease));
    }

    @Test
    public void testCompareToOtherUnknown() {
        ReleaseInfo thisRelease = new ReleaseInfo("1.0.0 (30/01/2012)");
        ReleaseInfo otherRelease = new ReleaseInfo("");

        assertEquals(1, thisRelease.compareTo(otherRelease));
    }

    @Test
    public void testCompareToDifferentMajor() {
        ReleaseInfo thisRelease = new ReleaseInfo("1.0.0 (30/01/2012)");
        ReleaseInfo otherRelease = new ReleaseInfo("2.0.0 (30/01/2012)");

        assertTrue(thisRelease.compareTo(otherRelease) < 0);
    }

    @Test
    public void testCompareToDifferentMinor() {
        ReleaseInfo thisRelease = new ReleaseInfo("1.0.0 (30/01/2012)");
        ReleaseInfo otherRelease = new ReleaseInfo("1.1.0 (30/01/2012)");

        assertTrue(thisRelease.compareTo(otherRelease) < 0);
    }

    @Test
    public void testCompareToDifferentBuild() {
        ReleaseInfo thisRelease = new ReleaseInfo("1.0.0 (30/01/2012)");
        ReleaseInfo otherRelease = new ReleaseInfo("1.0.1 (30/01/2012)");

        assertTrue(thisRelease.compareTo(otherRelease) < 0);
    }

    @Test
    public void testCompareToSameRelease() {
        ReleaseInfo thisRelease = new ReleaseInfo("1.0.0 (30/01/2012)");
        ReleaseInfo otherRelease = new ReleaseInfo("1.0.0 (30/01/2012)");

        assertEquals(0, thisRelease.compareTo(otherRelease));
    }

}
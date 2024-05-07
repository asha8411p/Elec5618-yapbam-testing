package net.yapbam.junit;

import net.yapbam.gui.util.FriendlyTable;
import org.junit.Test;

import java.io.IOException;

public class TableExporterIntegrationTest {

    @Test
    public void testExportToJSON() throws IOException {
        FriendlyTable table = createSampleTable();
    }

    // Helper Functions
    private FriendlyTable createSampleTable() {
        FriendlyTable table = new FriendlyTable();
        return table;
    }

}
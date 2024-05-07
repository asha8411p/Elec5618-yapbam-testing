package net.yapbam.junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import net.yapbam.export.JsonFormatWriter;

public class JsonFormatWriterTest {

    private JsonFormatWriter writer;
    private OutputStream outputStream;

    @Before
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        writer = new JsonFormatWriter(outputStream);
    }

    @After
    public void close() throws IOException {
        writer.close();
    }

    @Test
    public void testAddHeader() throws IOException {
        writer.addHeader();
        writer.close();
        assertEquals("{\"values\":[", outputStream.toString());
    }

    @Test
    public void testAddLineStart() throws IOException {
        writer.addLineStart();
        writer.close();
        assertEquals("[", outputStream.toString());
    }

    @Test
    public void testAddLineEnd() throws IOException {
        writer.addLineEnd();
        writer.close();
        assertEquals("]", outputStream.toString());
    }

    @Test
    public void testAddValue() throws IOException {
        writer.addValue("some value");
        writer.close();
        assertEquals("\"some value\"", outputStream.toString());
    }

    @Test
    public void testAddFooter() throws IOException {
        writer.addFooter();
        writer.close();
        assertEquals("]}", outputStream.toString());
    }

    @Test
    public void testClose() throws IOException {
        writer.close();
        assertTrue(outputStream.toString().isEmpty());
    }

}

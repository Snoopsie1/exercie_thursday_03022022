import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FOOBARTest
{
    FOOBAR foobar = new FOOBAR();
    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown()
    {
    }

    @Test
    public void foobarNumTest()
    {
        int actual = foobar.foobarNum();
        int expected = 6;

        assertEquals(expected,actual);
    }
}
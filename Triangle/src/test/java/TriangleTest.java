import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void judgeTriangle1() {
        assertEquals(false,new Triangle(2,3,6).judgeTriangle());

    }
    @Test
    public void judgeTriangle2() {
        assertEquals(false,new Triangle(1,3,6).judgeTriangle());

    }
    @Test
    public void judgeTriangle3() {
        assertEquals(false,new Triangle(3,3,6).judgeTriangle());

    }
    @Test
    public void judgeTriangle4() {
        assertEquals(true,new Triangle(4,3,6).judgeTriangle());

    }

}
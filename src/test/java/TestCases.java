import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

    @Test
    public void verifyAddition() {
        Assert.assertEquals(2 + 2, 4);
    }

    @Test
    public void verifySubtraction() {
        Assert.assertEquals(4 - 2, 2);
    }

    @Test
    public void verifyMultiply() {
        Assert.assertEquals(4 * 2, 8);
    }
}

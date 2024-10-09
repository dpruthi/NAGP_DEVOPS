import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

    @Test
    public void verifyAddition() {
        System.out.println("Hello world!");
        Assert.assertEquals(2 + 2, 4);
    }

    @Test
    public void verifySubtraction() {
        System.out.println("");
        Assert.assertEquals(4 - 2, 2);
    }

    @Test
    public void verifyMultiply() {
        System.out.println("wfwefewijfjiwejifweifbhiwfhibfrhibfbrihjfwijrfhiwhfijwehrfhwehifihwjefijewhfhrwihfiwehgfiehwjbgfihrihuiwi");
        Assert.assertEquals(4 * 2, 8);
    }
}

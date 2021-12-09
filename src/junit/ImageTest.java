package junit;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @Author : huzejun
 * @Date: 2021/12/10-2:07
 */
public class ImageTest {

    @Test
    public void test() {

        try {
            final BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/1.png"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

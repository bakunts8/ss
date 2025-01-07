package health;

import com.asprise.ocr.Ocr;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ImageTextReorganizationTest {

    @Test
    public void verifyTextInImage() {
//        Selenide.open("/");
//        String urlPath = $x("//div[@class='a-box']//img").attr("src");
        String localPath = "D:/test/test.png";
        Ocr ocr = new Ocr();
        ocr.startEngine("eng", Ocr.SPEED_FASTEST);

        String text;
        try {
//            text = ocr.recognize(new URL[] { new URL(path) },
//                    Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            text = ocr.recognize(new File[] { new File(localPath) },
                    Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("text is: " + text);
        ocr.stopEngine();
    }
}

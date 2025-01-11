package health;

import com.asprise.ocr.Ocr;
import com.codeborne.selenide.Selenide;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$x;

public class ImageTextReorganizationTest {
    public void verifyTextFromImageInFile() {
        String localPath = "D:/Projects/my_projects/ss/src/test/resources/test.png";

        // Perform OCR on the image file
        String text = extractTextFromSource(new File(localPath), null);
        System.out.println("Text from file: " + text);
    }

    /**
     * Verifies the text extracted from an image URL using OCR.
     */
    public void verifyTextFromImageInUrl() {
        Selenide.open("/");

        // Extract the URL of the image from the web page
        String urlPath = $x("//div[@class='a-box']//img").attr("src");
        if (urlPath == null || urlPath.isEmpty()) {
            throw new RuntimeException("Image URL not found on the page.");
        }

        try {
            URL imageUrl = new URL(urlPath);

            // Perform OCR on the image URL
            String text = extractTextFromSource(null, imageUrl);
            System.out.println("Text from URL: " + text);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process the image URL: " + urlPath, e);
        }
    }

    /**
     * Extracts text from a source using OCR.
     *
     * @param file the image file (set this if processing a local file)
     * @param url  the image URL (set this if processing an image from a URL)
     * @return the extracted text
     */
    private String extractTextFromSource(File file, URL url) {
        Ocr ocr = new Ocr();
        ocr.startEngine("eng", Ocr.SPEED_FASTEST);

        try {
            if (file != null) {
                return ocr.recognize(new File[]{file}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            } else if (url != null) {
                return ocr.recognize(new URL[]{url}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            } else {
                throw new IllegalArgumentException("Both file and URL are null. Provide at least one source.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract text from source", e);
        } finally {
            ocr.stopEngine();
        }
    }
}

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TelegramBot {

    // =========================================================
    // PUT YOUR BOT TOKEN HERE
    // =========================================================
    private static final String BOT_TOKEN = "8748360288:AAFrb7s6aaQlPvgqv5MzKiNOf7XAh8Ipllo";

    private static final String API_URL =
            "https://api.telegram.org/bot" + BOT_TOKEN;

    private static final String FILE_URL =
            "https://api.telegram.org/file/bot" + BOT_TOKEN;

    private static long lastUpdateId = 0;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Telegram Resume Analyzer");
        System.out.println("=================================");
        System.out.println("Bot is running...");
        System.out.println("Send a PDF resume to your Telegram bot.");

        HttpClient client = HttpClient.newHttpClient();

        while (true) {

            try {

                // =================================================
                // GET TELEGRAM UPDATES
                // =================================================

                String url = API_URL +
                        "/getUpdates?offset=" +
                        (lastUpdateId + 1) +
                        "&timeout=10";

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response =
                        client.send(
                                request,
                                HttpResponse.BodyHandlers.ofString()
                        );

                String json = response.body();

                // =================================================
                // CHECK WHETHER THERE IS A NEW MESSAGE
                // =================================================

                if (json.contains("\"update_id\"")) {

                    long updateId = extractLong(
                            json,
                            "\"update_id\":"
                    );

                    lastUpdateId = updateId;

                    // =================================================
                    // GET CHAT ID
                    // =================================================

                    String chatId =
                            extractString(
                                    json,
                                    "\"chat\":{\"id\":",
                                    ","
                            );

                    if (chatId == null) {
                        continue;
                    }

                    // =================================================
                    // CHECK FOR PDF/DOCUMENT
                    // =================================================

                    if (json.contains("\"document\"")) {

                        String fileId =
                                extractString(
                                        json,
                                        "\"file_id\":\"",
                                        "\""
                                );

                        if (fileId == null) {

                            sendMessage(
                                    chatId,
                                    "❌ I could not read the PDF file."
                            );

                            continue;
                        }

                        sendMessage(
                                chatId,
                                "📄 Resume received!\n\n" +
                                "⏳ Analyzing your resume..."
                        );

                        // =================================================
                        // GET FILE PATH FROM TELEGRAM
                        // =================================================

                        String fileInfoUrl =
                                API_URL +
                                "/getFile?file_id=" +
                                fileId;

                        HttpRequest fileInfoRequest =
                                HttpRequest.newBuilder()
                                        .uri(URI.create(fileInfoUrl))
                                        .GET()
                                        .build();

                        HttpResponse<String> fileInfoResponse =
                                client.send(
                                        fileInfoRequest,
                                        HttpResponse.BodyHandlers.ofString()
                                );

                        String fileInfo =
                                fileInfoResponse.body();

                        String filePath =
                                extractString(
                                        fileInfo,
                                        "\"file_path\":\"",
                                        "\""
                                );

                        if (filePath == null) {

                            sendMessage(
                                    chatId,
                                    "❌ Could not download the resume."
                            );

                            continue;
                        }

                        // =================================================
                        // DOWNLOAD PDF
                        // =================================================

                        String downloadUrl =
                                FILE_URL + "/" + filePath;

                        Path resumePath =
                                Paths.get("telegram_resume.pdf");

                        URL urlObject =
                                new URL(downloadUrl);

                        try (InputStream input =
                                     urlObject.openStream();
                             FileOutputStream output =
                                     new FileOutputStream(
                                             resumePath.toFile()
                                     )) {

                            byte[] buffer = new byte[8192];

                            int bytesRead;

                            while ((bytesRead =
                                    input.read(buffer)) != -1) {

                                output.write(
                                        buffer,
                                        0,
                                        bytesRead
                                );
                            }
                        }

                        System.out.println(
                                "Resume downloaded successfully."
                        );

                        // =================================================
                        // READ PDF USING YOUR ResumeReader
                        // =================================================

                        ResumeReader reader =
                                new ResumeReader();

                        String resumeText =
                                reader.readResume(
                                        resumePath.toString()
                                );

                        if (resumeText.startsWith(
                                "Error reading resume")) {

                            sendMessage(
                                    chatId,
                                    "❌ Error reading your PDF.\n\n" +
                                    resumeText
                            );

                            continue;
                        }

                        // =================================================
                        // ANALYZE RESUME
                        // =================================================

                        ResumeAnalyzer analyzer =
                                new ResumeAnalyzer();

                        String result =
                                analyzer.analyzeResume(
                                        resumeText
                                );

                        // =================================================
                        // SEND RESULT TO TELEGRAM
                        // =================================================

                        sendMessage(
                                chatId,
                                result
                        );

                        System.out.println(
                                "Resume analysis sent to Telegram."
                        );

                    } else {

                        // =================================================
                        // NORMAL TEXT MESSAGE
                        // =================================================

                        String message =
                                extractString(
                                        json,
                                        "\"text\":\"",
                                        "\""
                                );

                        if (message != null) {

                            if (message.equals("/start")) {

                                sendMessage(
                                        chatId,
                                        "👋 Welcome to Resume Analyzer!\n\n" +
                                        "📄 Send me your resume as a PDF.\n\n" +
                                        "I will analyze it and give you:\n" +
                                        "⭐ Overall Score\n" +
                                        "✅ Matched Skills\n" +
                                        "❌ Missing / Weak Skills\n" +
                                        "💡 Suggestions\n" +
                                        "🎓 Recommended Courses"
                                );

                            } else {

                                sendMessage(
                                        chatId,
                                        "📄 Please send your resume as a PDF file."
                                );
                            }
                        }
                    }
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    // =============================================================
    // SEND MESSAGE TO TELEGRAM
    // =============================================================

    private static void sendMessage(
            String chatId,
            String message) {

        try {

            String encodedMessage =
                    java.net.URLEncoder.encode(
                            message,
                            "UTF-8"
                    );

            String url =
                    API_URL +
                    "/sendMessage?chat_id=" +
                    chatId +
                    "&text=" +
                    encodedMessage;

            HttpClient client =
                    HttpClient.newHttpClient();

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();

            client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error sending Telegram message: " +
                    e.getMessage()
            );
        }
    }

    // =============================================================
    // EXTRACT STRING FROM JSON
    // =============================================================

    private static String extractString(
            String json,
            String startText,
            String endText) {

        int start =
                json.indexOf(startText);

        if (start == -1) {
            return null;
        }

        start += startText.length();

        int end =
                json.indexOf(
                        endText,
                        start
                );

        if (end == -1) {
            return null;
        }

        return json.substring(
                start,
                end
        );
    }

    // =============================================================
    // EXTRACT LONG NUMBER FROM JSON
    // =============================================================

    private static long extractLong(
            String json,
            String searchText) {

        int start =
                json.indexOf(searchText);

        if (start == -1) {
            return 0;
        }

        start += searchText.length();

        int end = start;

        while (
                end < json.length() &&
                Character.isDigit(
                        json.charAt(end)
                )
        ) {
            end++;
        }

        try {

            return Long.parseLong(
                    json.substring(
                            start,
                            end
                    )
            );

        } catch (Exception e) {

            return 0;
        }
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("WhatsApp Resume Analyzer");
        System.out.println("------------------------");

        ResumeReader reader = new ResumeReader();

        String resumeText = reader.readResume("resume.pdf");

        if (resumeText.startsWith("Error reading resume")) {

            System.out.println(resumeText);
            return;
        }

        ResumeAnalyzer analyzer = new ResumeAnalyzer();

        String result = analyzer.analyzeResume(resumeText);

        System.out.println(result);
    }
}
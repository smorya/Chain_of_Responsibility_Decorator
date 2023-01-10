package task2;


public class TimedDocument {
    private Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }

    public long measureTime() {
        long start = System.nanoTime();
        document.parse();
        long end = System.nanoTime();
        return end - start;
    }
}

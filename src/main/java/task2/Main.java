package task2;

public class Main {
    public static void main(String[] args) {
        String path = "gs://oop-course/Geico-2021.png";
        Document document = new SmartDocument(path);
        TimedDocument time = new TimedDocument(document);
        System.out.println(time.measureTime()/(double)1000000000);

        CachedDocument cachedDocument = new CachedDocument(1, path, "");
        if (cachedDocument.check() == 0) {
            cachedDocument.setParsed(document.parse());
            cachedDocument.save();
        } else {
            long start = System.nanoTime();
            System.out.println(cachedDocument.get());
            long end = System.nanoTime();
            System.out.println((end-start)/(double)1000000000);
        }
    }
}

// As one can see there is a big difference between the time needed
// for parsing a document and simple checking in database.
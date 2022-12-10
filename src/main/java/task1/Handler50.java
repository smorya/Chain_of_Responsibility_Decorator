package task1;

public class Handler50 extends Handler {
    @Override
    public boolean process(int price) {
        Handler next = getNext();
        if (price % 50 > 0 && next == null) {
            System.out.println("We can not provide that amount of money");
            throw new IllegalArgumentException();
        } else if (next != null) {
            next.process(price % 50);
            System.out.println(price / 50 + " * 50");
        }
        return true;
    }
}

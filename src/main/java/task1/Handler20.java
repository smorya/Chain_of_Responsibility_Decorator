package task1;

public class Handler20 extends Handler{
    @Override
    public boolean process(int price) {
        Handler next = getNext();
        if (price % 20 > 0 && next == null) {
            System.out.println("We can not provide that amount of money");
            throw new IllegalArgumentException();
        } else if (next != null) {
            next.process(price % 20);
            System.out.println(price / 20 + " * 20");
        }
        return true;
    }
}

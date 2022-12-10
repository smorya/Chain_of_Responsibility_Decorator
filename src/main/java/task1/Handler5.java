package task1;

public class Handler5 extends Handler{
    @Override
    public boolean process(int price) {
        Handler next = getNext();
        if (price % 5 > 0 && next == null) {
            System.out.println("We can not provide that amount of money");
            throw new IllegalArgumentException();
        } else if (next != null) {
            next.process(price % 5);
        }
        System.out.println(price / 5 + " * 5");
        return true;
    }
}

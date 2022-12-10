package task1;

import lombok.Getter;
import lombok.Setter;

public abstract class Handler {
    @Setter @Getter
    private Handler next;
    public abstract boolean process(int price);
}

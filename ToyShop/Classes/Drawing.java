package ToyShop.Classes;

import java.util.LinkedList;
import java.util.List;

public class Drawing {
    List<Prize> prizesToAward;
    List<PrizeDate> prizesAwarded;

    public Drawing() {
        this.prizesToAward = new LinkedList<>();
        this.prizesAwarded = new LinkedList<>();
    }

    public List<Prize> getPrizesToAward() {
        return prizesToAward;
    }

    public List<PrizeDate> getPrizesAwarded() {
        return prizesAwarded;
    }

    public void setPrizesToAward(List<Prize> prizesToAward) {
        this.prizesToAward = prizesToAward;
    }

    public void setPrizesAwarded(List<PrizeDate> prizesAwarded) {
        this.prizesAwarded = prizesAwarded;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Player {
    static List <Integer> players = new ArrayList<>();
    static List<Integer> deals = new ArrayList<>();
    private int dealerPoint;
    private int playerPoint;

    public int getPlayerPoint(){
        return this.playerPoint;
    }
    public int getDealerPoint(){
        return this.dealerPoint;
    }

    public void setPlayerPoint(int total){
        this.playerPoint = total;
    }
    public void setDealerPoint(int total){
        this.dealerPoint = total;
    }

    public void deleteHand(){
        players.clear();
        deals.clear();
    }

    public void resetPoint(){
        setDealerPoint(0);
        setPlayerPoint(0);
    }

}

public class ForBlackJack extends Player implements ChangeCard{
    
    // 手札の合計ポイント
    public void playerTotal(){
        int total = 0;
        for(int i = 0; i < players.size(); i++){
            total += toPoint(toNum(players.get(i)));

        }
        setPlayerPoint(total);
    }

    // ディーラーの合計ポイント
    public void dealerTotal(){
        int total2 = 0;
        int ace;
        for(int i = 0; i < deals.size(); i++){
            total2 += toPoint(toNum(deals.get(i)));
        }

        for(int i = 0; i < deals.size(); i++){
            ace = toNum(deals.get(i));
            if ((ace == 1) && (total2 <= 10)){
                total2 = (total2 - 1) + 11;
                if(total2 > 21){
                    total2 = (total2 - 11) + 1;
                    break;
                }else{
                    break;
                }
            }
        }
        setDealerPoint(total2);
    }

    //バーストの判定
    public boolean busted(int point){
        if(point > 21){
            return true;
        }else{
            return false;
        }
    }

    // スーツに変更
    public String toSuit(int cardNum){
        switch((cardNum - 1)/13){
            case 0: return "Spades";
            case 1: return "Diamond";
            case 2: return "Heart";
            case 3: return "Clover";
            default: return "Exceptions";
        }
    }

    // 絵札に変更
    public String toRank(int number){
        switch(number) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                String str = String.valueOf(number);
                return str;
            }
    }

    // 13以上の数字を1~13に変更
    public int toNum(int cardNum){
        
        int num = cardNum % 13;
        if(num == 0){
            num = 13;
        }
        return num;
    }

     //絵札を得点に変更
     public int toPoint(int num){
        if(num == 11 || num == 12 || num == 13){
            num = 10;
        }
        return num;

    }

    // 表示用のメソッド
    public String toDescription(int cardNum){
        String suit = toSuit(cardNum);
        String rank = toRank(toNum(cardNum));

        return rank + " of " + suit;
    }

    // 手札にエースがあるときの計算
    public int handInAce(int ace){
        playerTotal();
        int total = getPlayerPoint();
        if(ace == 11){
            total = (total - 1) + 11;
            return total; 
        }else{
            return total;
        }       
    }

    public boolean isAce(){
        boolean ace = false;
        for(int i = 0; i < players.size(); i++){
            int card = toNum(players.get(i));
            if(card == 1){
                ace = true;
                break;
            }else
                ace =  false;
        }
        return ace;
    }

    
}

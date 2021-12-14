import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    // カード用の配列
    List<Integer> cardDeck = new ArrayList<>(52);    

    public void shuffle(){
         // カードを配列に入れる
         for(int i = 1; i <= 52; i++){
            cardDeck.add(i);
        }
        Collections.shuffle(cardDeck);
        
    }
}
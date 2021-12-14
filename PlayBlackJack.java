import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayBlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                ForBlackJack bj = new ForBlackJack();
                Deck deck = new Deck();
                deck.shuffle();

                // 開始の手札
                int cardOne = deck.cardDeck.get(0);
                int cardTwo = deck.cardDeck.get(2);
                int dealerOne = deck.cardDeck.get(1);
                int dealerTwo = deck.cardDeck.get(3);
                Player.players.add(cardOne);
                Player.deals.add(dealerOne);
                Player.players.add(cardTwo);
                Player.deals.add(dealerTwo);

                
                // 手札の枚数
                int deckCount = 4;
                int playersHand = 2;

                bj.playerTotal();
                bj.dealerTotal();
                
                //今の手札
                System.out.println("Your first card:" + bj.toDescription(cardOne));
                System.out.println("Dealer's first card:" + bj.toDescription(dealerOne));
                System.out.println("Your second card:" + bj.toDescription(cardTwo));
                System.out.println("Dealers second card is hidden");
                System.out.println();

                //エースがあれば得点を選択
                if(bj.isAce()){
                    System.out.print("Choose 1 or 11: ");
                    int ace = sc.nextInt();
                    bj.setPlayerPoint(bj.handInAce(ace));
                }

                System.out.println("Players point: " + bj.getPlayerPoint());
                System.out.println();


                
                //プレイヤーのターン
                while(true){
                    System.out.print("Draw? (Yes...0/No...1) : "); int draw = sc.nextInt();
                    System.out.println();

                    if(draw == 0){
                        Player.players.add(deck.cardDeck.get(deckCount));
                        deckCount++;
                        playersHand++;

                        System.out.printf("Card %d is %s\n", playersHand, bj.toDescription(Player.players.get(playersHand - 1)));

                        bj.playerTotal();

                        System.out.println("Your total point: " + bj.getPlayerPoint());
                        System.out.println();

                        // ヒットした後のエースの得点を調整
                        if(bj.isAce()){
                            System.out.print("Choose 1 or 11: ");
                            int ace = sc.nextInt();
                            bj.setPlayerPoint(bj.handInAce(ace));
                            System.out.println("Your total point: " + bj.getPlayerPoint());
                            
                        }

                        //プレイヤーがバーストしたらゲーム終了
                        if(bj.busted(bj.getPlayerPoint())){
                            System.out.println("Burst!!!!");
                            break;
                        }
                    }else{
                        
                        System.out.println("Dealers turn");
                        System.out.println("Dealer's second card: " + bj.toDescription(dealerTwo));
                        break;
                    }
                }

                // プレイヤーがバーストまたは手札のカードの得点が17以上は何もしない
                while(true){
                    if(bj.getDealerPoint() >= 17 || bj.getPlayerPoint() > 21) {
                        break;
                    }else{
                        // ディーラーが17以上までカードを引く
                        int dealersCard = deck.cardDeck.get(deckCount);
                        Player.deals.add(dealersCard);
                        System.out.println("Dealer's next card: " + bj.toDescription(dealersCard));

                        deckCount++;
                        bj.dealerTotal();     
                    }

                }

                // 勝敗の判定
                System.out.println("--------------------");

                System.out.println("Your Point: " + bj.getPlayerPoint());
                System.out.println("Dealer's Point: " + bj.getDealerPoint());

                if(bj.busted(bj.getPlayerPoint())){;
                    System.out.println("You lose!!! hahaha");

                }else if(bj.busted(bj.getDealerPoint())){
                    System.out.println("You win!!!");

                }else if(bj.getDealerPoint() < bj.getPlayerPoint()){
                    System.out.println("You win!!!");
                
                }else if (bj.getDealerPoint() == bj.getPlayerPoint()){
                    System.out.println("Draw (-_-)");
                }else
                    System.out.println("You lose!!! hahahha");

                // 手札と得点の初期化
                bj.deleteHand();
                bj.resetPoint();
                
                // もう一度遊ぶ？
                System.out.println("--------------------");
                System.out.print("Play again? (Yes...0/No...1) : "); int cont = sc.nextInt();
                System.out.println("--------------------");

                if (cont == 1){
                    System.out.println("Thank you for playing");
                    sc.close();
                    break;
                }

            }catch(InputMismatchException e){

                ForBlackJack bug = new ForBlackJack();

                System.out.println("Please Type 0 or 1!!!");
                String error = sc.next();
                System.out.println("Not " + error);
                System.out.println("Restarting the game..... \n");
                
                //手札と得点をリセット
                bug.deleteHand();
                bug.resetPoint();
            }
        }
    }
}

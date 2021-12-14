interface ChangeCard{

    // スーツに変更
    abstract public String toSuit(int cardNum);

    // 絵札に変更
    abstract public String toRank(int number);

    // 13以上の数字を1~13に変更
    public int toNum(int cardNum);

    //絵札を得点に変更
    public int toPoint(int num);

    // 表示用のメソッド
    abstract public String toDescription(int cardNum);

}

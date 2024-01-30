package com.bjtu.collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private List<Card> allCards = new ArrayList<>();

    public Room(){
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors={"黑桃","红桃","梅花","方块"};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                allCards.add(new Card(numbers[i],colors[j],i+1));
            }
        }
        allCards.add(new Card("","小王",numbers.length+1));
        allCards.add(new Card("","大王",numbers.length+2));
        System.out.println(allCards);
    }


    public void startGame() {
        //洗牌
        Collections.shuffle(allCards);
        //发牌
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        List<Card> dipai = new ArrayList<>();
        for (int i = 0; i < allCards.size(); i++) {
            if(i>=allCards.size()-3){
                dipai.add(allCards.get(i));
            }else if(i%3==0){
                player1.add(allCards.get(i));
            }else if(i%3==1){
                player2.add(allCards.get(i));
            }else if(i%3==2){
                player3.add(allCards.get(i));
            }
        }
        //排序
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);
        //看牌
        System.out.println("玩家1："+player1);
        System.out.println("玩家2："+player2);
        System.out.println("玩家3："+player3);
        System.out.println("底牌："+dipai);
    }

    private void sortCards(List<Card> player) {
        player.sort((o1, o2) -> o2.getSize()-o1.getSize());
    }
}

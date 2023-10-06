package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import card.Card;
import card.CardDeck;
import card.January01;
import game.GameManager;
import game.GameStart;

public class Main {
	
	public static final Scanner sc = new Scanner(System.in);
	public static CardDeck userCardList = new CardDeck();
	public static CardDeck npcCardList = new CardDeck();
	public static Card[] userCard = new Card[3];
	public static Card[] npcCard = new Card[3];
	public static boolean userCallCard = false;
	public static boolean npcCallCard = false;
	public static int score = 0;

	public static void main(String[] args) {
		
		// 게임스타트
		GameStart gameStart = new GameStart();
		gameStart.gameStart();
		
		// 게임진행배틀
		GameManager gameManager = new GameManager();
		gameManager.game();
		
	}

}

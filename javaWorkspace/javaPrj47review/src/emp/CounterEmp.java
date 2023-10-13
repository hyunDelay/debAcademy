package emp;

import java.util.ArrayList;
import java.util.List;

import menu.Burger;

public class CounterEmp {
	
	public void showBurgerMenu(List<Burger> burgerList) {
		
		for(Burger burger : burgerList) {
			System.out.println(burger);
			burger.setPrice(0);
		}
		
	}

}

package fr.cactuscata.ti;

import java.util.HashMap;
import java.util.Scanner;

public class TI83Premuim {

	public static void main(String[] args) {
		new TI83Premuim();
	}

	// ------------

	private Scanner sc = new Scanner(System.in);
	private HashMap<Character, String> map = new HashMap<>();
	private float result;

	/**
	 * Pr�sentation du programme Initialisation de la map M�thode
	 * {@link TI83Premuim#ask()} lanc�e
	 */
	private TI83Premuim() {
		say("Bienvenue dans le programme Ti83Premuim");
		map.put('+', "additionn�");
		map.put('-', "soustrait");
		map.put('*', "multipli�");
		map.put('/', "divis�");
		ask();
	}

	/**
	 * Demande le premier numbre qui sera la r�f�rence (stock� dans result)
	 */
	private void ask() {
		result = getNumber();
		launch();
	}

	/**
	 * Va s'occuper de faire la boucle pour faire les deux actions suivantes:
	 * <li>Recuperer un nombre (un deuxieme, le premier �tant d�ja stock� dans la
	 * variable {@link TI83Premuim#result})</li>
	 * <li>Appliquer la m�thode math�matique associ� � un character</li>
	 */
	private void launch() {

		float number;
		String restart = "o";

		do {
			number = getNumber();
			arithmetic(number);
			say("Voulez-vous recommencer ?");
			restart = sc.nextLine();
		} while (restart.equalsIgnoreCase("o"));
		
		say("Au revoir !");

	}

	/**
	 * 
	 * @param number
	 *            l'op�rande
	 */
	private void arithmetic(float number) {

		char operator = getOperator();
		float result = 0.0f;

		switch (operator) {
		case '-':
			number = -number;
		case '+':
			result = this.result + number;
			break;
		case '*':
			result = this.result * number;
			break;
		case '/':
			result = this.result / number;
			break;
		}

		say("Le calcul %f %s � %f est �gal � %f !", this.result, this.map.get(operator), number, result);
		this.result = result;

	}

	/**
	 * Saisie du character
	 * 
	 * @return le character correct
	 */
	private char getOperator() {
		StringBuilder allOperator = new StringBuilder();
		this.map.keySet().forEach(allOperator::append);

		say("Veuillez saisir (%s)", allOperator);

		String operator = sc.nextLine();

		if (operator.length() == 0 || !map.containsKey(operator.charAt(0))) {
			say("L'op�rateur %c n'existe pas", operator);
			return getOperator();
		} else {
			return operator.charAt(0);
		}
	}

	/**
	 * 
	 * @return un nombre
	 */
	private int getNumber() {
		say("Veuillez saisir un nombre:");
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ex) {
			say("Le nombre saisi est incorrect ! Veuillez en saisir un nouveau !");
			return getNumber();
		}
	}

	private void say(String string, Object... objects) {
		System.out.println(String.format(string, objects));
	}

}

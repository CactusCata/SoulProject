package fr.soulscythe.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TI83 {

	private static boolean buffer = true;
	private static int typCalcul = 0; // 1=somme 2 = différence 3 = multiplication 4 = division
	private static double val = 0;
	private static double res = 0;
	private static int nbrEntries = 1;

	static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {

		res = doubleValue(nbrEntries++);
		while (buffer) {
			if (nbrEntries > 2) {
				System.out.println("Valeur memorise: " + res);
			}
			
			typCalcul = calcType();

			val = doubleValue(nbrEntries);

			nbrEntries++;

			res = calcul();

			Continue();
		}
		System.out.println("Fin du programme");
	}

	private static void Continue() {
		char car = '0';
		boolean validContinue = false;
		do {
			System.out.println("Souhaitez vous continuer ? (o: oui    n: non) ");
			do {
				try {
					car = clavier.nextLine().charAt(0);
					validContinue = true;
				} catch (StringIndexOutOfBoundsException g) {
					System.out.println("Veuillez entrez une saisie valide !");
				}
			} while (!validContinue);
			switch (car) {
			case 'o':
				return;
			case 'n':
				buffer = false;
				return;
			default:
				System.out.println("Veuillez entrez une saisie valide !");
				break;
			}
		} while ((car != 'o') && (car != 'n'));
	}

	private static double calcul() {
		StringBuilder sentence = new StringBuilder("\nLe resultat de " + res + " ");
		double result;
		switch (typCalcul) {
		case 1:
			result = res + val;
			sentence.append("+ ");
			break;
		case 2:
			result = res - val;
			sentence.append("- ");
			break;
		case 3:
			result = res * val;
			sentence.append("* ");
			break;
		case 4:
			result = res / val;
			sentence.append("+ ");
			break;
		default:
			return 0;
		}
		System.out.println(sentence.append(val).append(" est :").append(result));
		return result;
	}

	private static double doubleValue(int i) {
		double val = 0.0;
		boolean validDouble = false;
		do {
			try {
				System.out.println("Veuillez la valeur numéro " + i + ":");
				val = clavier.nextDouble();
				fflush();
				validDouble = true;
			} catch (InputMismatchException e) {
				System.out.println("Veuillez entrez une valeur correct");
				fflush();
			}
		} while (!validDouble);
		return val;
	}

	private static int calcType() {
		int val = 0;
		char operande = '0';
		boolean validCalc = false;
		StringBuilder sentence1 = new StringBuilder("choix effectue : ");
		
		do {
			System.out.println("Mode de calcul ( + , - , * , /)");
			do {
				try {
					operande = clavier.nextLine().charAt(0);
					validCalc = true;
				} catch (StringIndexOutOfBoundsException f) {
					System.out.println("le type d'operation est incorrect");
				}
			} while (!validCalc);
			
			switch (operande) {
			case '+':
				sentence1.append("addition");
				return 1;
			case '-':
				sentence1.append("soustraction");
				return 2;
			case '*':
				sentence1.append("multiplication");
				return 3;
			case '/':
				sentence1.append("division");
				return 4;
			default:
				System.out.println("le type d'operation est incorrect");
			}
		} while (typCalcul == 0);
		System.out.println(sentence1);
		return val;

	}

	private static void fflush() {
		clavier.nextLine();
	}
}
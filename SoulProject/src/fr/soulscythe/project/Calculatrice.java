package fr.soulscythe.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculatrice {
	static boolean buffer = true; 
	static int calc= 0;   //1=somme  2 = différence   3 = multiplication    4 = division
	static double Val = 0;
	static double Res; 
	static int i=1;
	
	static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Res = doubleValue(i++);
		while(buffer) {
			if(i>2)
			{
				System.out.println("Valeur memorise: " + Res);
			}
			calc = calcType();
			
			Val=doubleValue(i++);
						
			Res=calcul();

				
			Continue();
		}
		System.out.println("Fin du programme");
	}

	private static void Continue() {
		char car = '0';
		boolean y = false;
		do {
			System.out.println("Souhaitez vous continuer ? (o: oui    n: non) ");
			do {
				try {
					car = clavier.nextLine().charAt(0);
					y=true;
				} catch (StringIndexOutOfBoundsException g) {
					System.out.println("Veuillez entrez une saisie valide !");
				} 
			} while(!y);
			switch(car)
			{
			case 'o':
				return;
			case 'n':
				buffer = false;
				return;
			default:
				System.out.println("Veuillez entrez une saisie valide !");
				break;
			}
		}while((car != 'o') && (car != 'n'));
	}

	private static double calcul() {
			switch(calc)
			{
			case 1:
				System.out.println("\nLe resultat de " + Res + " + " + Val + " est :" + (Res + Val));
				return (Res + Val);
			case 2:
				System.out.println("\nLe resultat de " + Res + " - " + Val + " est :" + (Res - Val));
				return (Res - Val);
			case 3:
				System.out.println("\nLe resultat de " + Res + " * " + Val + " est :" + (Res * Val));
				return (Res * Val);
			case 4:
				System.out.println("\nLe resultat de " + Res + " / " + Val + " est :" + (Res / Val));
				return (Res / Val);
			}
			return 0;
	}

	private static double doubleValue(int i) {
		double Val=0.0;
		boolean v=false;
		do {
			try {
				System.out.println("Veuillez la valeur numéro " + i + ":");
				Val = clavier.nextDouble();
				v=true;
			} catch (InputMismatchException e) {
				System.out.println("Veuillez entrez une valeur correct");
				fflush(clavier);
			}
		}while(!v);
		return Val;
	}

	private static int calcType() {
		int Val = 0;
		char op = '0';
		boolean w=false;
		do{
			System.out.println("Mode de calcul ( + , - , * , /)");
			do {
				try {
					op = clavier.nextLine().charAt(0);
					w=true;
				} catch (StringIndexOutOfBoundsException f) {
					System.out.println("le type d'operation est incorrect");
				}
			}while(!w);
			switch(op)
			{
			case '+':
				System.out.println("choix effectue : addition");
				return 1;
			case '-':
				System.out.println("choix effectue : soustraction");
				return 2;
			case '*':
				System.out.println("choix effectue : multiplication");
				return 3;
			case '/':
				System.out.println("choix effectue : division");
				return 4;
			default:
				System.out.println("le type d'operation est incorrect");
				break;
			}
		}while(calc == 0);
		return Val;
	
	}

	private static void fflush(Scanner clavier2) {
		clavier2.nextLine();
	}
}
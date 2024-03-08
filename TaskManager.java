package it.etlabora.progetto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		selectTask(list, scan);
	}

	/* questo mi permette di gestire interamente lo switch case per la scelta dei
	 options*/
	public static void selectTask(List<String> list, Scanner scan) {
		boolean flag = true;
		while (flag) {
			menu();
			try {
				int option = scan.nextInt();
				scan.nextLine(); // Consuma il newline
				switch (option) {
				case 1:
					addListItems(list, scan);
					break;
				case 2:
					deleteListItemByName(list, scan);
					break;
				case 3:
					deleteListItemByIndex(list, scan);
					break;
				case 4:
					printList(list);
					break;
				case 5:
					clearList(list);
					break;
				case 6:
					flag = false;
					break;
				default:
					System.out.println("Opzione non valida");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Input non valido. Inserire un numero intero.");
				scan.nextLine(); // Pulisce il buffer di input
			}
		}
	}

	//questo metodo  mi stampa il menu di tutte le opzioni presenti
	public static void menu() {
		System.out.println("1: Aggiungi elemento");
		System.out.println("2: Elimina elemento per nome");
		System.out.println("3: Elimina elemento per indice");
		System.out.println("4: Stampare lista");
		System.out.println("5: Svuota lista");
		System.out.println("6: Termina");
		System.out.println("Scegli un'opzione:");
	}

	// questo metodo mi permette di aggiungere nuovi elementi nella lista
	public static void addListItems(List<String> list, Scanner scan) {
		String str;
		// il ciclo mi permette di aggiungere elementi finchè la stringa inserita non è
		// vuota
		do {
			System.out.print("Inserisci una stringa (invio per terminare): ");
			str = scan.nextLine().trim();
			if (!"".equals(str)) {
				list.add(str);
			}
		} while (!"".equals(str));
	}

    // questo metodo mi stampa la lista 
	public static void printList(List<String> list) {
		System.out.println("Contenuto della lista: " + list);
	}

	// questo medodo mi permette di cancellare una parola dalla lista
	public static void deleteListItemByName(List<String> list, Scanner scan) {
		System.out.print("Inserire l'elemento da cancellare: ");
		String item = scan.nextLine().trim();
		// il ciclo mi permette di cancellare un elemento solo se presente nella lista
		if (list.remove(item)) {
			System.out.println("Elemento rimosso con successo.");
		} else {
			System.out.println("Elemento non trovato nella lista.");
		}
	}

	// questo metodo mi permette di cancellare un elemento dalla lista prendendo
	// l'indece
	public static void deleteListItemByIndex(List<String> list, Scanner scan) {
		System.out.print("Inserire l'indice dell'elemento da cancellare: ");
		int index = scan.nextInt();
		scan.nextLine(); // Consuma il newline
		// mi entra nell'if solo se l'indice dell'elemento è presente nella lista'
		if (index >= 0 && index < list.size()) {
			list.remove(index);
			System.out.println("Elemento rimosso con successo.");
		} else {
			System.out.println("Indice non valido.");
		}
	}

	// questo metodo mi permette di cancellare tutti gli elementi della lista
	public static void clearList(List<String> list) {
		list.clear();
		System.out.println("Lista svuotata.");
	}
}

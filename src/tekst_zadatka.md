# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**



# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja bi trebalo da ispisuje kvadrat dimenzija 5x5 (od znakova 0) na ekranu. Ideja je da se u prvom redu na ekranu iscrta gornja ivica kvadrata (pet znakova 0), u drugom redu dva znaka 0 i tri prazna mesta između njih... a u poslednjem redu donja ivica kvadrata, tako da bi konačan izlaz na ekranu trebalo da izgleda ovako:

	00000
	0   0
	0   0
	0   0
	00000
	
Dati kod se kompajlira, ali ne radi to šta treba. Napraviti klasu **Ispisivac3** u paketu **ispravka_koda**, prekucati u nju kod koji je dat  i, uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Koristeći main metodu iz test klase, pozvati metodu ispisiKvadrat() i proveriti njen rad.

	package ispravka_koda;
	
	class Ispisivac3 {
		static void ispisiKvadrat() {
		  int i=1;
		  while(i >= 25){
			if (i<6 || i>21 || i%5==2 || i%5==3) System.out.print('0');
			else System.out.print(' ');
			if (i%5==3) System.out.println();
			i++;
		}
	  }
	}

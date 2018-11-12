# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javni nabrojivi tip **VrstaGume** u paketu **prodavnica.gume** koji ima instance:

* LETNJA

* ZIMSKA

* SVE_SEZONE 

Napraviti javnu klasu **Guma** u paketu **prodavnica.gume** koja ima:

* Privatni atribut **marka**

* Privatni atribut **vrstaGume** koji predstavlja instancu nabrojivog tipa VrstaGume.

* Privatni atribut **sirina** koji predstavlja širinu gume (npr. 165)

* Privatni atribut **visina** koji predstavlja visinu gume (npr. 55)

* Privatni atribut **precnik** koji predstavlja prečnik gume (npr. 15)

* Privatni atribut **stanje** koji predstavlja broj takvih guma na stanju u prodavnici.

* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za atribut marka su null i prazan String. Širina gume treba da bude u rasponu od 135 do 265, visina od 45 do 85 a prečnik od 13 do 19. Stanje treba da bude nula ili veće. U slučaju unosa nedozvoljenih vrednosti potrebno je na ekranu ispisati reč "GRESKA".

* Redefinisanu **equals** metodu klase Object koja proverava da li je zaista unet objekat klase Guma i vraća false ako nije. Ako jeste unet objekat te klase, metoda vraća true ako su atributi marka, vrsta gume, širina, visina i prečnik jednaki marki, vrsti gume, širini, visini i prečniku unete gume, a inače false.

* Redefinisanu **toString** metodu klase Object koja vraća String sa svim podacima o gumi uz odgovarajuću poruku.

Napraviti javnu klasu **ProdavnicaAutoDelova** u paketu **prodavnica** koja ima:

* Privatni atribut **ponudaGuma** koji je niz objekata klase Guma.

* Javni konstruktor koji inicijalizuje niz ponudaGuma na kapacitet 200.

* Javnu metodu **pretrazi** koja kao parametre dobija: vrstu gume, širinu, visinu i prečnik gume pronalazi i ispisuje na ekranu sve podatke o gumama koje odgovaraju unetim parametrima. Ako takvih guma nema u prodavnici, ispisati na ekranu reč "NEMA".

* Javnu metodu **unesiGumu** koja kao parametar prima objekat klase Guma i unosi ga u niz i to na prvo slobodno mesto (element na tom mestu ima NULL vrednost). Unošenje se vrši ako u nizu ne postoji ista guma. Ako u nizu postoji ista guma (ista marka, vrsta, širina, visina i prečnik), onda se samo stanje preuzeto iz unetog objekta Guma (broj novih guma) dodaje na postojeće stanje odgovarajuće gume iz niza.

* Javnu metodu **sastaviSpisakZaNabavku** sastavlja spisak za nabavku guma koje ponestaju na zalihama. Metoda nema parametre, a vraća niz objekata klase Guma u kojem se nalaze sve one gume iz niza ponudaGuma kojima je stanje 2 ili manje. Niz treba da bude tačno onolike dužine koliko takvih guma ima. Ako takvih guma nema, vratiti null.

Napraviti javnu klasu **ProbaProdavnicaAutoDelova** u paketu **prodavnica.proba** koja u main metodu pravi jedan objekat klase ProdavnicaAutoDelova i u njega unosi tri gume: zimsku "Kleber" širine 195 visine 65 i prečnika 15 (stanje 10), letnju "Hankook" širine 165 visine 65 i prečnika 14 (stanje 20) i "Goodyear" za sve sezone širine 185 visine 60 i prečnika 15 (stanje 2). Ispisati na ekranu sve gume iz prodavnice koje je potrebno ponovo nabaviti, odnosno koje ponestaju na zalihama.

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

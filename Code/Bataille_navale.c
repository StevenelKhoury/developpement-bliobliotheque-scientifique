#include<stdio.h>
#include<stdlib.h>
#include<time.h>


typedef int grille[12][12];

struct joueur 
{
	char nom[10];
	grille alliee, ennemie;
	int type_jr; //0=humain 1= aleatoire 2=ordinateur
};
typedef struct joueur joueur;

struct bateau 
{
	int placement[2],taille,vie;
	char direction;// cela permet de n'avoir a rentrer qu'un coup et de placer en fonction de la direction
};
typedef struct bateau bateau;

struct flotte 
{
	bateau porteA,torpilleur,contreT,SSmarin,croiseur;
	int compteur; //nombre de bateaux encore en vie
};
typedef struct flotte flotte;

void init_grille(grille plateau) 
{
	int i,j;
	for(i=0; i<12; i++) plateau[i][0]=plateau[0][i]=plateau[i][11]=plateau[11][i]=5;
	for(i=1; i<11; i++) for(j=1; j<11; j++) plateau[i][j]=0;
}

void init_flotte(flotte *bonjour) 
{
	bonjour->torpilleur.vie = 2;
	bonjour->contreT.vie = 3;
	bonjour->SSmarin.vie = 3;
	bonjour->croiseur.vie = 4;
	bonjour->porteA.vie = 5;
	bonjour->torpilleur.taille = 2;
	bonjour->contreT.taille = 3;
	bonjour->SSmarin.taille = 3;
	bonjour->croiseur.taille = 4;
	bonjour->porteA.taille = 5;
	bonjour->compteur=17;
}

void affiche_double(grille plateau1, grille plateau2,int dbl)
{
	int i,j;
	if(dbl) printf("\n   Grille alliee\t\t    Grille ennemie \n   A B C D E F G H I J\t\t    A B C D E F G H I J\n");
	else printf("\n   Grille alliee\n   A B C D E F G H I J\n");
	for(i=1; i<10; i++)
	{
		printf("%d ",i);
		for(j=1; j<11; j++) printf(" %c","./0X#"[plateau1[i][j]]);
		if(dbl)
		{
			printf("\t\t ");
			printf("%d ",i);
			for(j=1; j<11; j++) printf(" %c","./0X#"[plateau2[i][j]]);
		}
		printf("\n");
	}
	printf("10");
	for(j=1; j<11; j++) printf(" %c","./0X#"[plateau1[i][j]]);
	if(dbl)
	{
		printf("\t\t ");
		printf("10");
		for(j=1; j<11; j++) printf(" %c","./0X#"[plateau2[i][j]]);
	}
	printf("\n\n");
}

void init_joueur(joueur *prsn)
{
	char type;
	for(;;)
	{
		printf("Le joueur sera t'il un humain ou un ordinateur facile ou un ordinateur difficile ? (h/f/d) : \n");
		fflush(stdin);
		type=getchar();
		type|=32;
		switch(type)
		{
			case 'h' :
				prsn->type_jr=0;
				printf("\nEntrez votre nom : ");
				scanf("%s", prsn->nom);
				fflush(stdin);
				return;
			case 'f' :prsn->type_jr=1; break;
			case 'd' :prsn->type_jr=2;
		}
		printf("\nQuel est le nom de l'ordinateur ? (max 10 caracteres) : ");
		scanf("%s", prsn->nom);
		fflush(stdin);
		if(type=='h' || type=='f' || type=='d') return;
		else printf("Type nom valide\n");
	}	
}

void litcase(int*i,int*k)
{
	char c;
	for(;;)
	{
		printf("\nDonnez une coordonnee ('0' pour '10') : ");
		c=getchar();
		c|=32;      // transforme une majuscule en minuscule
		if(c<'a' || c>'j') continue;
		*k=c-'a'+1;
		c=getchar();
		if(c<'0' || c>'9') continue;
		if(c=='0') *i=10;
		else *i=c-'0';
		return;
	}
}

void aleat(int *i, int *j)
{
	*i=rand()%10+1;
	*j=rand()%10+1;	
}

int taille_bateau(flotte *bonjour) // Donne la taille du plus grand bateau en vie
{
	if(bonjour->porteA.vie!=0) return 5;
	if(bonjour->croiseur.vie!=0) return 4;
	if(bonjour->SSmarin.vie!=0) return 3;
	if(bonjour->contreT.vie!=0) return 3;
	return 2;
}

void placer_coup(grille jalliee, grille jennemie, int i, int j, int valeur) 
{ 
	jalliee[i][j]=valeur;
	jennemie[i][j]=valeur;
}

int verif_bateau(int ligne, int colonne, bateau *bat)
{
	int k,i=bat->placement[0],j=bat->placement[1];
	switch(bat->direction)
	{
		case 's' : for(k=i; k<i+bat->taille; k++) if(ligne==k && colonne==j) bat->vie--; return 1; 
		case 'n' : for(k=i; k>i-bat->taille; k--) if(ligne==k && colonne==j) bat->vie--; return 1;
		case 'e' : for(k=j; k<j+bat->taille; k++) if(ligne==i && colonne==k) bat->vie--; return 1;
		case 'o' : for(k=j; k>j-bat->taille; k--) if(ligne==i && colonne==k) bat->vie--; return 1;
	}
	return 0;
}

int colle(joueur* prsn, bateau* bat) // Retourne 1 si un autre bateau est colle 0 sinon
{
	int i=bat->placement[0], j =bat->placement[1], k, variable;
	switch(bat->direction)
	{
		case 's' : 
		if( prsn->alliee[i-1][j]==4) return 1;
		for(variable=-1;variable<2;variable+=2) for(k=i; k<i+bat->taille; k++) if( prsn->alliee[k][j+variable]==4) return 1;
		if(prsn->alliee[i+bat->taille][j]==4) return 1;
		break;
		case 'n' :  
		if(prsn->alliee[i+1][j]==4) return 1;
		for(variable=-1;variable<2;variable+=2) for(k=i; k>i-bat->taille; k--) if( prsn->alliee[k][j+variable]==4) return 1;
		if( prsn->alliee[i-bat->taille][j]==4) return 1;
		break;
		case 'o' :
		if( prsn->alliee[i][j+1]==4) return 1;
		for(variable=-1;variable<2;variable+=2) for(k=j; k>j-bat->taille; k--) if( prsn->alliee[i+variable][k]==4) return 1;
		if(prsn->alliee[i][j-bat->taille]==4) return 1;
		break;
		case 'e' : 
		if( prsn->alliee[i][j-1]==4) return 1;
		for(variable=-1;variable<2;variable+=2) for(k=j; k<j+bat->taille; k++) if( prsn->alliee[i+variable][k]==4) return 1;
		if(prsn->alliee[i][j+bat->taille]==4) return 1;
		break;
	}
	return 0;
}

int verif(grille jennemie,int i, int j)
{
	if(jennemie[i][j]==5) return 0;
	else return 1;
}

void coule(bateau *bat,joueur *allie,joueur *ennemi,flotte *bonjour, int regle)
{
	int k,i=bat->placement[0],j=bat->placement[1];
	if(bat->vie==0)
	{
		switch(bat->direction)
		{
			case 's' :
			if(verif(allie->ennemie,i-1,j) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i-1,j,1);
			for(k=i; k<i+bat->taille; k++)
			{
				placer_coup(allie->ennemie,ennemi->alliee,k,j,3);
				if(verif(allie->ennemie,k,j-1) && !regle)placer_coup(allie->ennemie,ennemi->alliee,k,j-1,1);
				if(verif(allie->ennemie,k,j+1) && !regle)placer_coup(allie->ennemie,ennemi->alliee,k,j+1,1);
			}
			if(verif(allie->ennemie,k,j) && !regle)placer_coup(allie->ennemie,ennemi->alliee,k,j,1);
			break;
			case 'n' :
			if(verif(allie->ennemie,i+1,j) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i+1,j,1);
			for(k=i;k>i-bat->taille; k--)
			{
			    placer_coup(allie->ennemie,ennemi->alliee,k,j,3);
				if(verif(allie->ennemie,k,j-1) && !regle)	placer_coup(allie->ennemie,ennemi->alliee,k,j-1,1);
				if(verif(allie->ennemie,k,j+1) && !regle)placer_coup(allie->ennemie,ennemi->alliee,k,j+1,1);
			}
			if(verif(allie->ennemie,k,j) && !regle)placer_coup(allie->ennemie,ennemi->alliee,k,j,1);
			break;
			case 'e' :
			if(verif(allie->ennemie,i,j-1) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i,j-1,1);
			for(k=j; k<j+bat->taille; k++)
			{
			    placer_coup(allie->ennemie,ennemi->alliee,i,k,3);
				if(verif(allie->ennemie,i-1,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i-1,k,1);
				if(verif(allie->ennemie,i+1,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i+1,k,1);
			}
			if(verif(allie->ennemie,i,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i,k,1);
			break;
			case 'o' : 
			if(verif(allie->ennemie,i,j+1) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i,j+1,1);
			for(k=j; k>j-bat->taille; k--)
			{
			    placer_coup(allie->ennemie,ennemi->alliee,i,k,3);
				if(verif(allie->ennemie,i-1,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i-1,k,1);
				if(verif(allie->ennemie,i+1,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i+1,k,1);
			}
			if(verif(allie->ennemie,i,k) && !regle)placer_coup(allie->ennemie,ennemi->alliee,i,k,1);
			 break;
		}
		if(allie->type_jr==0) printf("\nVous avez coule un bateau");
	}
}

void iteratif (grille ennemie, int *i, int *j, int dir)
{
	int flag=1,toto=99;
	for(;;)
	{
		if(dir==1||toto==0)
		{
			toto=0;
			while(toto!=2)
			{
				if(ennemie[*i+flag][*j]==0 || ennemie[*i+flag][*j]==2)
				{
			
					if(ennemie[*i+flag][*j]==0) { *i=*i+flag; return; }
					else *i=*i+flag;
				}
				if(ennemie[*i+flag][*j]!=0&&ennemie[*i+flag][*j]!=2) {	flag=-flag;	toto++;	}
			}
			dir=0;
		}
		if(dir==0||toto==2)
		{
			toto=2;
			while(toto!=0)
			{
				if(ennemie[*i][*j+flag]==0 || ennemie[*i][*j+flag]==2)
				{
					if(ennemie[*i][*j+flag]==0) {	*j=*j+flag; return; }
					else *j=*j+flag;
				}
				if(ennemie[*i][*j+flag]!=0&& ennemie[*i][*j+flag]!=2) {	flag=-flag;	toto--;	}
			}
			
		}
	}
}

int nb_possible(int ligne,int colonne, int taille, grille tab)
{
    int i,j,k,l,compteur=0;
    for(i=0;i<=taille-1;i++) if(tab[ligne-i][colonne]!=0) {i--; break;}
    for(k=0;k<=taille-1;k++) if(tab[ligne+k][colonne]!=0) {k--; break;}
    for(j=0;j<=taille-1;j++) if(tab[ligne][colonne-j]!=0) {j--; break;}
    for(l=0;l<=taille-1;l++) if(tab[ligne][colonne+l]!=0) {l--; break;}
    if(i+k+1>=taille) compteur+=i+k+1-taille;
    if(j+l+1>=taille) compteur+=j+l+1-taille;
    return compteur;
}
void moyen(grille ennemie, int *ligne,int *colonne,flotte *bonjour)
{
	int i,j,coup,banane,flag=1, tab[12][12],valeur,max=0,compteur=0,nb;
	for(i=1;i<11;i++)
	{
		for(j=1;j<11;j++)
		{
			if(ennemie[i][j]==2)
			{
				if(ennemie[i+1][j]!=2 && ennemie[i][j+1]!=2 && ennemie[i-1][j]!=2 && ennemie[i][j-1]!=2) 
				{
					coup=rand()%4;
					switch(coup)
					{
						case 0 :*ligne=i-1; *colonne=j;   break;						
						case 1 :*ligne=i;   *colonne=j-1; break;
						case 2 :*ligne=i+1; *colonne=j;   break;
						case 3 :*ligne=i;   *colonne=j+1; break;
					}
					flag=0;
				}
				else
				{
					if(ennemie[i+1][j]==2) banane=1;
					if(ennemie[i][j+1]==2) banane=0;
					*ligne=i;
					*colonne=j;
					iteratif(ennemie,ligne,colonne,banane);
					flag=0;
				}	
			}		
		}
	}
	if(flag==1) 
	{
		for(i=1;i<11;i++)  
		for(j=1;j<11;j++)
		{
			valeur =nb_possible(i,j,taille_bateau(bonjour),ennemie);
			tab[i][j]=valeur;
			if(valeur>max) 
			{
				max=valeur;
				compteur=0;
			}
			if(valeur==max) compteur++;
		}
	nb=rand()%compteur+1;
		for(i=1;i<11;i++)
		for(j=1;j<11;j++) 
		{
			if(tab[i][j]==max) 
			{
				nb--;
				if(nb==0) {*ligne=i; *colonne=j;}
			}
		}
	}
}

int jouer_coup(joueur *allie, joueur *ennemi, flotte *fennemie, int regle) 
{ //peut etre passer seulement la grille alliee de l'autre joueur et pas la structure entiere ou alliee serait grille joueur jouant pas le coup, cette fonction est presque recursive, mais on est obliger d'utiliser des varibles donc pas possible
	int verif=0,rejouer=0, ligne, colonne,compteur=0;
	while(rejouer==0) 
	{
		compteur++;
		while(verif!=1) 
		{ // verifie que l'on a pas deja tire a cet endroit
			if(allie->type_jr==0) 
			{
				printf("\nOu voulez vous tirer ?");
				litcase(&ligne,&colonne);
			}
			if(allie->type_jr==1) aleat(&ligne,&colonne);
			if(allie->type_jr==2) moyen(allie->ennemie,&ligne,&colonne,fennemie); 
			if(allie->ennemie[ligne][colonne]!=1 && allie->ennemie[ligne][colonne]!=2 && allie->ennemie[ligne][colonne]!=3 
			&& allie->ennemie[ligne][colonne]!=5) verif=1;
			else if(allie->type_jr==0) printf("\nVous avez deja joue a cet emplacement\n");
		}
		verif=0;
		if(ennemi->alliee[ligne][colonne]==0) 
		{
			placer_coup(allie->ennemie, ennemi->alliee, ligne, colonne, 1);
			printf("\nVous n'avez pas touche de bateau adverse");
			rejouer = 1;
		} else 
		{
			placer_coup(allie->ennemie, ennemi->alliee,ligne, colonne,2);
			if(verif_bateau(ligne,colonne,&fennemie->porteA)) coule(&fennemie->porteA,allie,ennemi,fennemie,regle);
			if(verif_bateau(ligne,colonne,&fennemie->torpilleur)) coule(&fennemie->torpilleur,allie,ennemi,fennemie,regle);
			if(verif_bateau(ligne,colonne,&fennemie->contreT)) coule(&fennemie->contreT,allie,ennemi,fennemie,regle);
			if(verif_bateau(ligne,colonne,&fennemie->SSmarin)) coule(&fennemie->SSmarin,allie,ennemi,fennemie,regle);
			if(verif_bateau(ligne,colonne,&fennemie->croiseur)) coule(&fennemie->croiseur,allie,ennemi,fennemie,regle);
			affiche_double(allie->alliee,allie->ennemie,1);
			fennemie->compteur=fennemie->porteA.vie+fennemie->torpilleur.vie+fennemie->contreT.vie+fennemie->SSmarin.vie+fennemie->croiseur.vie;
			if(fennemie->compteur==0) rejouer=1;
			if(allie->type_jr==0) printf("\nVous avez touche un bateau ennemi, vous pouvez rejouer");
		}
	}
	return compteur;
}

char demande_direction() 
{
	char direction;
	do 
	{
		printf("\nentrez la direction dans laquelle sera votre bateau\n");
		direction = getchar();
		direction|=32;
	} while(direction != 's' && direction != 'n' && direction != 'e' && direction != 'o');
	return direction;
}

void placer_bateau(joueur *prsn, bateau *bat, int regle)
{
	int i,j,k,valeur=0,flag=0,truc=0;
	do
	{
		if(prsn->type_jr==0) 
		{
			printf(" \nEntrez les coordonnees de la case de reference de votre bateau : ");
			litcase(&i,&j);
		}
		else aleat(&i,&j);		
		bat->placement[0]=i;
		bat->placement[1]=j;
		if(prsn->type_jr==0) bat->direction = demande_direction();
		if(regle==0) 
		{
			truc=flag=colle(prsn,bat);
			//if(flag)truc=1;
			if(prsn->type_jr==0) printf("\nPosition non valide");
		}
		if(truc==0)
		switch(bat->direction)
		{
			case 's' :
				valeur=0;
				flag=0;
				for(k=i; k<i+bat->taille; k++)
				{
					if(prsn->alliee[k][j]==4 || prsn->alliee[k][j]==5 )
					{
						valeur=1;
						flag=1;
						if(prsn->type_jr==0) printf("\nPosition non valide");
					}
				}
				if(valeur==0) for(k=i; k<i+bat->taille; k++) prsn->alliee[k][j]=4; break;
			case 'n' :
				valeur=0;
				flag=0;
				for(k=i; k>i-bat->taille; k--)
				{
					if(prsn->alliee[k][j]==4 || prsn->alliee[k][j]==5)
					{
						valeur=1;
						flag=1;
						if(prsn->type_jr==0) printf("\nPosition non valide");
					}
				}
				if(valeur==0) for(k=i; k>i-bat->taille; k--) prsn->alliee[k][j]=4; break;
			case 'e' :
				valeur=0;
				flag=0;
				for(k=j; k<j+bat->taille; k++)
				{
					if(prsn->alliee[i][k]==4 || prsn->alliee[i][k]==5)
					{
						valeur=1;
						flag=1;
						if(prsn->type_jr==0) printf("\nPosition non valide");
					}
				}
				if(valeur==0) for(k=j; k<j+bat->taille; k++) prsn->alliee[i][k]=4; break;
			case 'o' :
				valeur=0;
				flag=0;
				for(k=j; k>j-bat->taille; k--)
				{
					if(prsn->alliee[i][k]==4 || prsn->alliee[i][k]==5)
					{
						valeur=1;
						flag=1;
						if(prsn->type_jr==0) printf("\nPosition non valide");
					}
				}
				if(valeur==0) for(k=j; k>j-bat->taille; k--) prsn->alliee[i][k]=4; 
		}
	} while(flag!=0);
}

void placer_flotte(joueur *prsn, flotte *bonjour, int regle)
{
	if(prsn->type_jr==0) printf("\nPlacer le porte-avion (5 cases)");
	placer_bateau(prsn,&bonjour->porteA,regle); //Porte avion
	affiche_double(prsn->alliee,prsn->ennemie,0);
	if(prsn->type_jr==0) printf("\nPlacer le torpilleur (2 cases)");
	placer_bateau(prsn,&bonjour->torpilleur,regle); //Torpilleur
	affiche_double(prsn->alliee,prsn->ennemie,0);
	if(prsn->type_jr==0) printf("\nPlacer le contre-Torpilleur (3 cases)");
	placer_bateau(prsn,&bonjour->contreT,regle); //Contre-Torpilleur
	affiche_double(prsn->alliee,prsn->ennemie,0);
	if(prsn->type_jr==0) printf("\nPlacer le sous-marin (3 cases)");
	placer_bateau(prsn,&bonjour->SSmarin,regle); //Sous-marin
	affiche_double(prsn->alliee,prsn->ennemie,0);
	if(prsn->type_jr==0) printf("\nPlacer le croiseur (4 cases)");
	placer_bateau(prsn,&bonjour->croiseur,regle); //Croiseur
	affiche_double(prsn->alliee,prsn->ennemie,0);
}

void placement_nul(joueur *ordi, flotte *bonjour,int regle)
{
	int i, dir;
	char direct;
	for(i=0;i<5;i++)
	{
		dir=rand()%4;
		switch(dir)
		{
			case 0 : direct = 'n'; break;
			case 1 : direct = 'e'; break;
			case 2 : direct = 's'; break;
			case 3 : direct = 'o'; break;
		}
		switch(i)
		{
			case 0 : bonjour->porteA.direction = direct; break;
			case 1 : bonjour->torpilleur.direction = direct; break;
			case 2 : bonjour->SSmarin.direction = direct; break;
			case 3 : bonjour->contreT.direction = direct; break;
			case 4 : bonjour->croiseur.direction = direct; break;
		}		
	}
	placer_flotte(ordi,bonjour,regle);
}

void placement_joueur(joueur *prsn, flotte *bonjour, int regle)
{
	if(prsn->type_jr==0) placer_flotte(prsn,bonjour,regle);
	else placement_nul(prsn,bonjour,regle);
}

void partie(joueur *j1, joueur *j2, flotte *f1, flotte *f2, int regle)
{
	int play,compt=0,compt1=0;
	if(j1->type_jr==0) affiche_double(j1->alliee,j1->ennemie,0);
	placement_joueur(j1,f1,regle);
	if(j2->type_jr==0) affiche_double(j2->alliee,j2->ennemie,0);
	placement_joueur(j2,f2,regle);
	while(play)
	{
		printf("\nC'est a %s de jouer",j1->nom);
		affiche_double(j1->alliee,j1->ennemie,1);
		compt+=jouer_coup(j1,j2,f2,regle);
		if(f1->compteur==0 || f2->compteur==0)
		{
			play=0; continue;
		}
		printf("\nC'est a %s de jouer",j1->nom);
		affiche_double(j2->alliee,j2->ennemie,1);
		compt1+=jouer_coup(j2,j1,f1,regle);
		if(f1->compteur==0 || f2->compteur==0) play=0;
	}
	if (f1->compteur==0) printf("\n%s a gagne la partie en %d coups!!!",j2->nom,compt1);
	if (f2->compteur==0) printf("\n%s a gagne la partie en %d coups!!!",j1->nom,compt);
}

int init_partie()
{
	char regle;
	printf("Voulez vous pouvoir coller les bateaux ou non ? (O/N) : "); //1 coller bateaux,0 sinon
	regle = getchar();
	regle |= 32;
	if(regle=='o') return 1;
	return 0;
}

int main()
{
	joueur j1,j2;
	flotte flotte_j1, flotte_j2;
	int regle=init_partie();
	init_joueur(&j1);
	init_joueur(&j2);
	init_grille(j1.alliee);
	init_grille(j2.alliee);
	init_grille(j1.ennemie);
	init_grille(j2.ennemie);
	init_flotte(&flotte_j1);
	init_flotte(&flotte_j2);
	srand(time(NULL));
	partie(&j1,&j2,&flotte_j1,&flotte_j2,regle);
	return EXIT_SUCCESS;
}

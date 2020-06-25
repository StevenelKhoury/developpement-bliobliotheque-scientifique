
#include <cfloat>
#include <iostream>
#include "finiteHorizonMDP.h"
#include "alglin.h"
#include "sparseMatrix.h"


solutionMDP* finiteHorizonMDP::PdePi(double epsilon, int maxIter, sparseMatrice vector<sparseMatrix*>){
    //Create necessary variables.
    int i;
    int a;
    int j=0;
    int nbaction;
    
    /*Allocate buffers (to be used to iterate state space and action space) */
    int* actionbuffer = (int*) calloc( actionSpace->totNbDims(), sizeof(int) );
    int* statebuffer = (int*) calloc( stateSpace->totNbDims(), sizeof(int) );
    vector<sparseMatrix*> trans(actionSpace->cardinal());
	sparseMatrix *PdePi = new sparseMatrix(stateSpace->cardinal());
    double *tab = (double*) calloc( stateSpace->cardinal(), sizeof(double) ))
	for(nbaction=0;nbaction<sparseMatrice.size;nbaction+1)
    {	
    	for(i=0;i<stateSpace->cardinal();i++)
		{
			for(j=0;i<stateSpace->cardinal();i++)
			{
				PdePI->addToEntry(i,j,[i][j])
			}
		} 
	}
}


for(i=0;i<stateSpace->cardinal();i++){
       stateSpace->nextState(statebuffer);
       stateSpace->printState(stdout,statebuffer);
       indiceEtat=stateSpace->index(statebuffer);
       fprintf(stdout" etat : %d\n",indiceEtat);
   }

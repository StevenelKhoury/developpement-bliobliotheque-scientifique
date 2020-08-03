
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
    double *tab = (double*) calloc(stateSpace->cardinal(), sizeof(double) ))
	stateSpace->firstState(statebuffer)
	for(i=0;i<stateSpace->cardinal();i++){
       stateSpace->printState(stdout,statebuffer);
       indiceEtat=stateSpace->index(statebuffer);
       indiceAction=actionSpace->getAction(indiceEtat);
       stateSpace->nextState(statebuffer);
       for(j=0;i<stateSpace->cardinal();i++){
    	tab[indiceEtat][indiceEtat]=trans.at(indiceAction)->getEntry(indiceEtat,indiceEtat)
	   }
   }



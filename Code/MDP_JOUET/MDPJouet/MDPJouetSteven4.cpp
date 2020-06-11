/* Marmote and MarmoteMDP are free softwares: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Marmote is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Marmote. If not, see <http://www.gnu.org/licenses/>.

Copyright 2019 Emmanuel Hyon, Alain Jean-Marie
*/

/**
 * @brief file MDP_jouet10.cpp
 * @author Hyon, lip6
 * @date Jul 2019
 * @version 1.1
 *
 * This .cpp file is for implementing a simple infinite discounted MDP model
 * associated with a toy problem of a marmote in the moutain.
 *
 * Les résultats doivent être
 * V(0)=31,1299
 * V(1)=20,4374
 * V(1)=16.1846

 * pi(0)=0
 * pi(1)=1
 *
 *
 */

#include <iostream>
#include <sstream>
#include <stdlib.h>
#include <stdio.h>
#include <malloc.h>
#include <values.h>
#include <time.h>
#include <list>
#include <vector>
#include <string>

using namespace std;

#include "Set/marmoteInterval.h"
#include "Set/marmoteSet.h"
#include "transitionStructure/sparseMatrix.h"
#include "discountedMDP.h"
#include "feedbackSolutionMDP.h"
#include "solutionMDP.h"


int main( int argc, char** argv )
{
  int i;
  //create and initialize the discount factor.
  double beta = 0.5;
  string critere("max");

  //create and initialize epsilon.
  double epsilon = 0.0001;

  //create and initialize the maximum number of iterations allowed.
  int maxIter = 700;

  //==================Test new features==================//

 
  int min = 0;
  int max = 2;
  marmoteSet *actionSpace = new marmoteInterval(0,3);
  marmoteSet *stateSpace = new marmoteInterval(min,max);

  vector<sparseMatrix*> trans(actionSpace->cardinal());
  sparseMatrix *P1 = new sparseMatrix(3);
  P1->addToEntry(0,0,0.25);
  P1->addToEntry(0,1,0.5);
  P1->addToEntry(0,2,0.25);
  P1->addToEntry(1,0,0.4);
  P1->addToEntry(1,1,0.2);
  P1->addToEntry(1,2,0.4);
  P1->addToEntry(2,0,0.4);
  P1->addToEntry(2,1,0.3);
  P1->addToEntry(2,2,0.3);
  trans.at(0) = P1;

  sparseMatrix *P2 = new sparseMatrix(3);
  P2->addToEntry(0,0,0.5);
  P2->addToEntry(0,1,0.25);
  P2->addToEntry(0,2,0.25);
  P2->addToEntry(1,0,0.6);
  P2->addToEntry(1,1,0.2);
  P2->addToEntry(1,2,0.2);
  P2->addToEntry(2,0,0.5);
  P2->addToEntry(2,1,0.4);
  P2->addToEntry(2,2,0.1);
  trans.at(1) = P2;
  
  sparseMatrix *P3 = new sparseMatrix(3);
  P3->addToEntry(0,0,0.25);
  P3->addToEntry(0,1,0.55);
  P3->addToEntry(0,2,0.2);
  P3->addToEntry(1,0,0.2);
  P3->addToEntry(1,1,0.4);
  P3->addToEntry(1,2,0.4);
  P3->addToEntry(2,0,0.4);
  P3->addToEntry(2,1,0.3);
  P3->addToEntry(2,2,1);
  trans.at(1) = P3;
  
  sparseMatrix *P4 = new sparseMatrix(3);
  P4->addToEntry(0,0,0.1);
  P4->addToEntry(0,1,0.2);
  P4->addToEntry(0,2,0.7);
  P4->addToEntry(1,0,0.0);
  P4->addToEntry(1,1,0.1);
  P4->addToEntry(1,2,0.9);
  P4->addToEntry(2,0,0.0);
  P4->addToEntry(2,1,0.0);
  P4->addToEntry(2,2,1);
  trans.at(1) = P4;

  sparseMatrix *R1  = new sparseMatrix(4);
  R1->addToEntry(0,0,3.025);
  R1->addToEntry(0,1,0.225);
  R1->addToEntry(0,2,2.07);
  R1->addToEntry(0,3,0.77);
  R1->addToEntry(1,0,4.24);
  R1->addToEntry(1,1,1.22);
  R1->addToEntry(1,2,1.44);
  R1->addToEntry(1,3,-0.31);
  R1->addToEntry(2,0,4.33);
  R1->addToEntry(2,1,0.41);
  R1->addToEntry(2,2,2.43);
  R1->addToEntry(2,3,-0.4);
  



  std::cout << critere.size() << std::endl;
  fprintf(stdout,"Debut de la construction MDP\n");
  unfiniteHorizonDiscountedMDP *mdp1 = new finiteHorizonDiscountedMDP(critere, stateSpace, actionSpace, trans, R1,beta); //j'ai pas la bibliothèque 
  fprintf(stdout,"Fin de la construction MDP\n");

  fprintf(stdout,"Affichage MDP\n");
  mdp1->writeMDP();

  fprintf(stdout,"Affichage solution iteration valeur\n");
  //call the function to solve the MDP.
  solutionMDP *optimum = mdp1->valueIteration(epsilon, maxIter);
  optimum->writeSolution();

  fprintf(stdout,"\n\nVerification des solutions\n");
  double *sol1 = mdp1->policyCost(optimum,epsilon, maxIter);
  for(i=0;i<stateSpace->cardinal();i++){
         printf("i=%d sol1= %f \n",i,sol1[i]);
  }

  //call the function to solve the MDP.
  fprintf(stdout,"\n\nCalcul par iteration valeur modifiee\n");
  solutionMDP *optimum2 = mdp1->policyIterationModified(epsilon, maxIter, 0.001, 100);
  optimum2->writeSolution();


  fprintf(stdout,"Destruction\n");
  mdp1->clearRew();
  delete mdp1;
  delete optimum;
  delete optimum2;


  fprintf(stdout,"Destruction 2\n");
  delete actionSpace;
  delete stateSpace;

  fprintf(stdout,"Destruction 3\n");

  delete P1;
  delete P2;
  delete P3;
  delete P4;

  free(sol1);

  return 0;
}

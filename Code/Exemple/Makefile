MARMOTEDIR=./marmoteBase
CFLAGS=-ansi -Wall -pedantic -g -I
LDFLAGS = -L lib -lmingw32 -lSDL2main -lSDL2 -mwindows
CC=gcc

LIBRARIES=$(addprefix -l, MarmoteBase MarmoteMDP)
INCLUDEDIR=$(MARMOTEDIR)/include
LIBDIR=$(MARMOTEDIR)/lib
MDPDIR=./marmoteMDP/lib
MDPINCLUDE=./marmoteMDP/include

APPLIS= MDPJouetSteven MDPJouetSteven2

all: $(APPLIS)

MDPJouetSteven: Exemple/MDPJouetSteven.cpp
	$(CC) $(CFLAGS) -I$(INCLUDEDIR) -I$(MDPINCLUDE) $^ -o $@ -L$(LIBDIR) -L$(MDPDIR) $(LIBRARIES) -c Exemple/MDPJouetSteven.cpp	
	
MDPJouetSteven2: Exemple/MDPJouetSteven2.cpp
	$(CC) $(CFLAGS) -I$(INCLUDEDIR) -I$(MDPINCLUDE) $^ -o $@ -L$(LIBDIR) -L$(MDPDIR) $(LIBRARIES) -c Exemple/MDPJouetSteven.cpp
		

clean:
	del *.o $(APPLIS)

cleanall: clean
	del *.exe
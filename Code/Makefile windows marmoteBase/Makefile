0S=Windows_NT
ifeq ($(OS),Windows_NT)
CFLAGS += -std=gnu++11
endif

#cat := $(if $(filter $(OS),Windows_NT),type,cat)
#VERSION := $(shell $(cat) version.txt)
VERSION := "1.2.1_MDP"
DISTDIR=marmoteBase

GPPCOMPILER=C:\MinGW\bin\mingw32-g++.exe
#GPPCOMPILER=clang


CFLAGS = -ansi -Wall -Wformat-security -g 

DISTRIBS=bernoulliDistribution Distribution \
	uniformDistribution diracDistribution \
	exponentialDistribution discreteDistribution  \
	uniformDiscreteDistribution geometricDistribution \
	poissonDistribution
TRANSITIONS=sparseMatrix multiDimHomTransition eventMixture transitionStructure
SETS=marmoteSet marmoteBox marmoteInterval binarySimplex binarySequence

COREOBJECTS=\
	$(addprefix lib/, $(addsuffix .o, $(DISTRIBS) ) ) \
	$(addprefix lib/, $(addsuffix .o, $(TRANSITIONS) ) ) \
	$(addprefix lib/, $(addsuffix .o, $(SETS) ) )

OBJECTS=$(COREOBJECTS) 

LIBRARIES=$(addprefix lib/, $(addsuffix .a, libMarmoteBase) )

all: objects libraries 

objects: $(OBJECTS)

# Making the core lib objects
lib/%.o: Distribution/%.cpp
	$(GPPCOMPILER) $(CFLAGS) -c $< -o $@

lib\%.o: transitionStructure/%.cpp
	$(GPPCOMPILER) $(CFLAGS) -c $< -o $@

lib\%.o: Set/%.cpp
	$(GPPCOMPILER) $(CFLAGS) -c $< -o $@

lib/%.o: %.cpp
	$(GPPCOMPILER) $(CFLAGS) -c $< -o $@

libraries: $(OBJECTS)
	ar crv lib/libMarmoteBase.a $(COREOBJECTS)

documentation: 
	doxygen Doxyfile
	@(cd ./Documentation/latex/ && $(MAKE) pdf && cd ../)
	@/bin/cp ./Documentation/latex/refman.pdf ../../Documentation/man_marmoteBase.pdf
	@/bin/rm -rvf ./Documentation

tarball_distrib:
	$(info Entree dans tarball distrib $(DISTDIR))
	@/bin/rm -rvf ../../$(DISTDIR)
	$(info creation des repertoires)
	@/bin/mkdir $(DISTDIR)
	@/bin/mkdir $(DISTDIR)/include
	@/bin/mkdir $(DISTDIR)/include/Distribution
	@/bin/mkdir $(DISTDIR)/include/transitionStructure
	@/bin/mkdir $(DISTDIR)/include/Set
	@/bin/mkdir $(DISTDIR)/lib
	$(info copies des repertoires)
	@/bin/cp -p *.h $(DISTDIR)/include
	@/bin/cp -p Distribution\*.h $(DISTDIR)/include/Distribution
	@/bin/cp -p transitionStructure\*.h $(DISTDIR)/include/transitionStructure
	@/bin/cp -p Set/*.h $(DISTDIR)/include/Set
	@/bin/cp -p lib/*.a $(DISTDIR)/lib
	$(info deplacement du repertoire destination)
	@/bin/mv -v $(DISTDIR) ../../$(DISTDIR)
	$(info fin de tarball distrib)


distribs:
	@make -i clean
#	@make documentation
	@make
	@make tarball_distrib
	$(info fin de distribs)


clean:
	@/bin/rm -rf $(OBJECTS) $(LIBRARIES) 

# Genetic algorithm

Simple implementation of genetic algorithm.

START
<ul>
<li>Generate the initial population</li>
<li>Compute fitness</li></ul>
REPEAT
<ul>
<li>Selection</li>    
    <li>Crossover</li>
    <li>Mutation</li>
    <li>Compute fitness</li></ul>
UNTIL population has converged<br/>
STOP

<h3>Task description</h3>
* domain class Gene
* domain class Chromosome
* domain class Chain
* domain class Pool
* method createGene (random)
* method createChromosome (random Genes)
* method crossover (Chromosome)
* method mutate (Chromosome)
* method createChain (random Chromosomes)
* describe fitness (what task is solved with genetic algorithm)
* get result
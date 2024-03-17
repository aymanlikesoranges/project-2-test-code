import animal.*;
import linkedlist.LinkedList;
public class Zoo{
    private LinkedList<Animal> animalLedger;
    public static enum SortType{
	NAME, WEIGHT
    }
    /**
     *Wrapper for the LinkedList sort
     * TODO: Implement AnimalWeightComparator
     */
    public void sort(SortType s){
	switch(s){
	case NAME:
	    animalLedger.sort(new AnimalNameComparator());
        break;
	case WEIGHT:
	    animalLedger.sort(new AnimalWeightComparator());
	}
	
    }
    
    /**
     * Returns a copy of the underlying LinkedList
     * @return copy of the animals LinkedList
     */
    public LinkedList<Animal> getLedgerCopy(){
        return new LinkedList<Animal>(this.animalLedger);
    }

    
    /**
     * Adds an Animal to the animals list (All animals must have unique names (i.e., I can't have two Animals named Jim at the same time))
     *@param givenAnimal Animal to be added to the animals list
     *@return whether the animal was added to the list or not
     */
    public boolean addAnimal(Animal givenAnimal){
	for(Animal a : animalLedger){
	    if(a.getName().equals(givenAnimal.getName())){
		return false;
	    }
	}
	return animalLedger.append(givenAnimal);
    }

    /**
     * Takes an array of Animals and adds each one to the animals list
     *@param animalArr a simple Array of type Animal containing Animals to be added to the animals list 
     *@return whether all of the animals were added to the list or not
     * 
     */
    public boolean addAnimal(Animal[] animalArr){
	boolean addedAll = true;
	for(Animal a : animalArr){
	    addedAll =  ( addAnimal(a) & addedAll );
	}
	return addedAll;
    }

    /**
     * Adds the total weight of the Zoo 
     *@return the weight of the animals in the Zoo
     * 
     */
    public int totalWeight(){
	int total = 0;
	for(Animal a : animalLedger){
	    total += a.getWeight();
	}
	return total;
    }

    /**
     * Adds the total number of legs in the Zoo 
     *@return the number of legs in the Zoo
     * 
     */
    public int totalLegs(){
	int total = 0;
	for(Animal a : animalLedger){
	    total += a.numLegs();
	}
	return total;	
    }
    
    
    /**
     * Constructs a Zoo object with a given ArrayList of Animals
     *@param givenAnimals an ArrayList of Animal types
     */
    public Zoo(LinkedList<Animal> givenAnimals){
	this.animalLedger = new LinkedList<Animal>(givenAnimals);
    }
    /**
     *Constructs a Zoo object with an initial Animal
     *@param singleAnimal an initial Animal to put in the Zoo
     */
    public Zoo(Animal singleAnimal){
	this.animalLedger = new LinkedList<Animal>();
	this.animalLedger.append(singleAnimal);
    }
    /**
     *Constructs an empty Zoo object with an empty ArrayList of Animals
     */
    public Zoo(){
	this.animalLedger = new LinkedList<Animal>();
    }

}

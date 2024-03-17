/*"import" tells java to look in the ./animal/ directory and grab every .java file in there
                                     ./animal/mammal/ directory and grabe every .java file in there
   When you add more animal class types you'll need to import their packages as well
*/
import animal.*;
import animal.mammal.*;
import animal.reptile.*;
import animal.bird.*;
import animal.fish.*;
public class Driver{


    public static void stats(Animal a){
        String output = "";
	output += a.getName() + " is a " + a.getSpecies() + " and they say, \"" + a.speak()  + "!\"" + "\n";
	output += "\t INFO:\n";
	output += "\t\t Class -- " + a.getAnimalClass() + "\n";
	output += "\t\t Weight -- " + a.getWeight() + " lbs\n";
	output += "\t\t Diet -- " + a.eat() + "\n";
	output += "\t\t Legs -- " + a.numLegs() + "\n";
	output += "\t\t Breathes -- " + a.breathe() + "\n";
	output += "\t\t Can Fly -- " + a.canFly() + "\n";
	output += "\t\t Can Swim -- " + a.canSwim() + "\n";
	System.out.println(output);
    }

    public static void stats(Zoo z){
        String output = "Zoo stats: \n";
	output += "\t # Animals -- " + z.getLedgerCopy().size() + "\n";
	output += "\t # Legs -- " + z.totalLegs() + "\n";
	output += "\t Total Weight -- " + z.totalWeight() + " lbs\n";
	System.out.println(output);
    }

    public static void main(String[] args){
	//The below demonstrates the output for the program.
	//I will use my own Driver to test your code. - JR
	Zoo myZoo = new Zoo();
        Animal[] animalArr = {new Lion("Mark"),
			      new Penguin("Luke"),
			      new Snake("Sylvester"),
			      new Parrot("Morgan"),
			      new Giraffe("Gerald"),
			      new Clownfish("Garry")};
	myZoo.addAnimal(animalArr);
	for(Animal a : myZoo.getLedgerCopy()){
		System.out.println(myZoo.getLedgerCopy().size());
	}
    }
}

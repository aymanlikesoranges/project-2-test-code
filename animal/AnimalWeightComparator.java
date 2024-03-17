package animal;
import java.util.Comparator;
public class AnimalWeightComparator implements Comparator<Animal>{
    //We'll sort animals by their weight
public int compare(Animal a1, Animal a2) {
    double weightDifference = a1.getWeight() - a2.getWeight();

    if (weightDifference > 0) {
        return 1;
    } else if (weightDifference < 0) {
        return -1;
    } else {
        return 0;
    }
}
}

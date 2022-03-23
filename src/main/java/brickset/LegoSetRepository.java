package brickset;

import repository.Repository;
import java.util.Comparator;


/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /** Method 1
     * Returns the number of LEGO sets whose name is longer than 10.
     * @param num the number of letters
     * @return the number of LEGO sets whose name is longer than the specified number.
     */
    public long countLegoSetsHasLongerName(Integer num) {
        return getAll().stream()
                .filter(legoSet -> legoSet.getName().length() > num)
                .count();
    }

    /** Method 2
     * Print the first 10 members and print out their theme (no repeats)
     */
    public void printTheDistinctThemes() {
        getAll().stream()
            .filter(legoSet -> legoSet.getTheme() != null)
            .map(LegoSet::getTheme)
            .limit(10)
            .distinct()
            .forEach(System.out::println);
    }

    /** Method 3
    * Add 30 to all pieces, and print out the first three as a test
    **/
    public void printAddPieces(){
        getAll().stream()
             .map(LegoSet::getPieces)
             .map(x -> x + 30)
             .limit(3)
             .forEach(System.out::println);
    }

    /** Method 4
     * Print out the highest number of Pieces
     **/
     public void printHighestPieces() {
         getAll().stream()
             .map(LegoSet::getPieces)
             .sorted(Comparator.reverseOrder())
             .limit(1)
             .forEach(System.out::println);
     }

    /** Method 5
     * Count the number of members whose number starts with 2
     * @param str the start number
     * @return the specified start number .
     **/
    public long countLegoSetsStartNum2(String str) {
            return getAll().stream()
                    .map(LegoSet::getNumber)
                    .filter(s->s.startsWith(str))
                    .count();
    }

   public static void main (String[]args){
        var repository = new LegoSetRepository();
        System.out.println(repository.countLegoSetsHasLongerName(10)); System.out.println();
        repository.printTheDistinctThemes(); System.out.println();
        repository.printAddPieces(); System.out.println();
        repository.printHighestPieces(); System.out.println();
        System.out.println(repository.countLegoSetsStartNum2("2"));
    }

}






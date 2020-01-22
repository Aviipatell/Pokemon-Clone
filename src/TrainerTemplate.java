/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Image;

public abstract class TrainerTemplate {
	/**
	 * abstract method to print out the trainers party
	 */
	public abstract void printParty();
	/**
	 * abstract method to set the trainersImage
	 */
	public abstract void setPlayerImage();
	/**
	 * abstract method to set which way the trainer is facing
	 * @param tX - int
	 */
	public abstract void setPlayerImage(int tX);
	/**
	 * abstract method to set the X and Y co-ordinates of the trainer
	 */
	public abstract void setTrainerXandY();
	/**
	 * abstract method to get the numerical value of the current trainer
	 * @return - int
	 */
	public abstract int getTrainerNum();
	/**
	 * abstract method for asseccor to the trainers party
	 * @return Pokemon[]
	 */
	public abstract Pokemon[] getTrainerParty();
	/**
	 * abstract method as a mutator to the trainers party
	 */
	public abstract void setTrainerParty();
	/**
	 * abstract method to act as a mutator to the trainer's party by setting it based on num of pokemon and specific boosts in attack power
	 * @param numOfPokemon - int
	 * @param boost - int
	 */
	public abstract void setParty(int numOfPokemon, int boost);
	/**
	 * abstract method as a getter / accessor for the players Image
	 * @return Image
	 */
	public abstract Image getTrainerImage();

}

import java.util.List;
import java.util.ArrayList;


public class TacitProject {
	
	public static void main(String[] args){

	//	OTHER POSSIBILITIES
	//		ArrayList<Animal> animalList = new ArrayList<Animal>();
	//	=========================================================================
	//		List<AnimalSound> animalList = new ArrayList<AnimalSound>();
	//		ArrayList<AnimalSound> animalList = new ArrayList<AnimalSound>();
		
		List<Animal> animalList = new ArrayList<Animal>();

		animalList.add(new Dog(true));
		animalList.add(new Cat(true));
		animalList.add(new Cat(false));
		animalList.add(new Parrot(true));
		animalList.add(new Dog(false));
		animalList.add(new Mockingbird(false));
		
		testSounds(animalList);
	}
	
	public static void testSounds(List<Animal> animalList){
		for(int i = 0; animalList != null && i < animalList.size(); i++){
			testSound(animalList.get(i));
		}	
	}
	
	public static void testSound(Animal animalSound){
		System.out.println(animalSound.makeSound());
	}	
	
}


interface AnimalSound{
	
	public String makeSound();
	
}


abstract class Animal implements AnimalSound{
	
	public abstract String getName();
	protected abstract String getSound();
	
	protected boolean isLoud;
	
	public Animal (boolean s) {	
		isLoud = s;
	}
	
	protected String getSoundLevel() {
		if (isLoud)
			return ("LOUD!");
		else
			return ("quite");
	}
	
	public String makeSound(){
		return getName() + " " + getSound() + " (" + getSoundLevel() + ")";
	}
	
}


class Cat extends Animal{
	
	public Cat(boolean s){
		super(s);
	}
	
	@Override
	public String getName(){
		return "Cat";
	}
	
	@Override
	public String getSound(){
		return "Meow";
	}
	
}


class Dog extends Animal{
	
	public Dog(boolean s){
		super(s);
	}
	
	@Override
	public String getName(){
		return "Dog";
	}
	
	@Override
	public String getSound(){
		return "Woof";
	}

}


interface Talkable{
	
	public String talk();
	
}


class Mockingbird extends Animal implements Talkable{
	
	public Mockingbird(boolean s){
		super(s);
	}
	
	@Override
	public String getName(){
		return "Mockingbird";
	}
	
	@Override
	public String getSound(){
		return talk();
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return "Cafer kapici kapici";
	}

}



class Parrot extends Animal implements Talkable{
	
	public Parrot(boolean s){
		super(s);
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return "Kapici Babajim kapici";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Parrot";
	}

	@Override
	protected String getSound() {
		// TODO Auto-generated method stub
		return talk();
	}
	
}

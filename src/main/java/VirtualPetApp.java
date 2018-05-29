import java.util.Scanner;

public class VirtualPetApp {
	public static void main(String[] args) {

		VirtualPet rapidash = new VirtualPet(5, 50, 7, 50);
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Virtual Pet! Would you like to play?");
		goToMenu(input);
		System.out.println("Great! Your pet's name is Rapidash.");

		String optionEntered = selectMenuItem(input);
		int tick = 10;
		while (rapidash.tick() < tick) {

			if (optionEntered.equals("1")) {
				System.out.println("How many scoops of food do you want to feed: ");
				int feedPortion = input.nextInt();
				System.out.println(rapidash.feedPetAndCheckPetsSatisfactionLevel(feedPortion));
				while (feedPortion < VirtualPet.petIsFull) {
					System.out.println("How many scoops of food do you want to feed: ");
					feedPortion = feedPortion + input.nextInt();
					System.out.println(rapidash.feedPetAndCheckPetsSatisfactionLevel(feedPortion));
				}
				System.out.println("Would you like to go back to menu?");
				input.nextLine();
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("2")) {
				System.out.println("How many minutes of time did you groom your pet?");
				int groomingTime = input.nextInt();
				rapidash.morale = groomingTime;
				System.out.println(rapidash.getGroomingMessage());
				System.out.println("Would you like to go back to menu?");
				input.nextLine();
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("3")) {
				System.out.println("What is your pets manure level?");
				int manureLevel = input.nextInt();
				System.out.println(rapidash.doINeedToCleanMyPetsManureAfterACleaning(rapidash.cleanUpAfterPet(manureLevel)));
				System.out.println("Would you like to go back to menu?");
				input.nextLine();
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("4")) {
				if(rapidash.isMyPetSick)
				{
					System.out.println("Yes, you need to take Rapidash to vet because Rapish is either overfed, toxic, or hurt from too much exercise!");
				}else{
					System.out.println("Rapidash is Fine. You don't need to go to vet!");
				}
				System.out.println("Would you like to go back to menu?");
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("5")) {
				System.out.println("How many minutes of exercise did you give Rapidash?");
				int playtime = input.nextInt();
				System.out.println(rapidash.doesMyPetHaveEnoughExercise(playtime));
				System.out.println("Would you like to go back to menu?");
				input.nextLine();
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("6")) {
				System.out.println("How many minutes of sleep did you give Rapidash?");
				int timeSlept = input.nextInt();
				System.out.println(rapidash.doesPetNeedSleep(timeSlept));
				System.out.println("Would you like to go back to menu?");
				input.nextLine();
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("7")) {
				rapidash.isMyPetSick = false;
				System.out.println("Pet has been healed");
				System.out.println("Would you like to go back to menu?");
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else if (optionEntered.equals("8")) {
				System.out.println("Pet has been exterminated");
				System.out.println("Would you like to go back to menu?");
				goToMenu(input);
				optionEntered = selectMenuItem(input);
			}
			else {
				System.out.println("You entered incorrect menu item!");
				selectMenuItem(input);
			}
			rapidash.tick++;
			if(rapidash.tick == tick) {
				System.out.println("You are out of times you can loop, GoodBye!");
				System.exit(0);
			}
		}

	}

	private static void goToMenu(Scanner input) {
		String answer = input.nextLine();
		if (!answer.equalsIgnoreCase("Yes")) {
			System.out.println("Nobody likes a quitter!");
			System.exit(0);
		}
	}

	private static String selectMenuItem(Scanner input) {
		System.out.println("\nWhat would you like to do with Rapidash?");
		System.out.println("1. Feed your pet");
		System.out.println("2. Groom your pet");
		System.out.println("3. Pick up your pet's poop");
		System.out.println("4. Do you need to take pet to the vet");
		System.out.println("5. Play with pet");
		System.out.println("6. Leave pet to chill out and take a nap");
		System.out.println("7. Heal Pet");
		System.out.println("8. Euthanize pet");
		String optionEntered = input.nextLine();
		return optionEntered;
	}
}

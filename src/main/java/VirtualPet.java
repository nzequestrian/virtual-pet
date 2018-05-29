
public class VirtualPet {

	public int rationAmount = 0;
	public int startingAmountOfFood = 0;
	public int morale = 0;
	public int startingAmountOfMorale = 0;
	public boolean isMyPetSick;
	public int tick = 0;
	public static final int manureSafeLevel = 10;
	public static final int manureDangerLevel = 15;
	public static final int manureCleaning = 5;
	public static final int petIsFull = 10;
	public static final int petIsOverFullAndSick = 20;
	public static final int adequateAmountOfGroomingTime = 57;
	
	
	public VirtualPet() {
		// TODO Auto-generated constructor stub
	}
	
	public VirtualPet(int rationAmount, int startingAmountOfFood, int morale, int startingAmountOfMorale) {
		this.rationAmount = rationAmount;
		this.startingAmountOfFood = startingAmountOfFood;
		this.morale = morale;
		this.startingAmountOfMorale = startingAmountOfMorale;
	}

	public int getActualAmountOfFoodAfterEating() {
		 return this.startingAmountOfFood - this.rationAmount;
	}

	public int getActualAmountOfPetMoraleAfterGrooming() {
		 return this.startingAmountOfMorale + morale;
	}

	public String doINeedToCleanMyPetsManureAfterACleaning(int currentManureLevel) {
		String message = "";
				
		String safeLevelMessage = "Pet is healthy, you don't need to pick up manure!";
		String timeToCleanLevelMessage = "Clean up the manure before your pet gets sick!";
		String dangerLevelMessage = "Your pet is probably sick now you lazy piece of manure!";
				
		if (currentManureLevel < manureSafeLevel)
		{
			message = safeLevelMessage;
		}
		else if (currentManureLevel >= manureSafeLevel && currentManureLevel < manureDangerLevel) {
			message = timeToCleanLevelMessage;
		}    
		else if (currentManureLevel >= manureDangerLevel) {
			message = dangerLevelMessage;
			this.isMyPetSick = true;
		} 
		
		return message;
	}

	public int cleanUpAfterPet(int currentManureLevel) {
		currentManureLevel = currentManureLevel - manureCleaning;
		return currentManureLevel;
	}

	public String feedPetAndCheckPetsSatisfactionLevel(int feedPortion) {
		
		String feedMessage = "";
		String feedMoreMessage = "Please feed Pet more food";
		String feedPerfectMessage = "Pet is perfectly fed!";
		String feedLessMessage = "Please feed Pet less food as Pet is sick now!";
		
		if(feedPortion < petIsFull){
			feedMessage = feedMoreMessage;
		}
		else if (feedPortion >= petIsFull && feedPortion < petIsOverFullAndSick){
			feedMessage = feedPerfectMessage;
		}
		else{
			feedMessage = feedLessMessage;
			this.isMyPetSick = true;
		}
		return feedMessage;
	}

	public String doesMyPetHaveEnoughExercise(int playtime) {
		String notEnoughExerciseMessage = "Pet needs more exercise!";
		String perfectExerciseMessage = "Thanks, pet is happy to be out running around!";	
		String tooMuchExercise = "You exercised me too much, I might be hurt. Please call the vet!";
		int minutesPerDay = 60;
		String exerciseMessage ="";
		
		if (playtime < minutesPerDay) {
			exerciseMessage = notEnoughExerciseMessage;
		}else if (playtime == minutesPerDay){
			exerciseMessage = perfectExerciseMessage;	
		}else{
			exerciseMessage = tooMuchExercise;
			this.isMyPetSick = true;
		}
		return exerciseMessage;

	}

	public String doesPetNeedSleep(int timeSlept) {
		String notEnoughSleep = "Pet needs to rest!";
		String completelyRested = "Thanks, pet is happy to be rested!";
		int amountOfSleepNeeded = 8;
		String sleepMessage;

		if (timeSlept < amountOfSleepNeeded) { // this is a conditional statement.
			sleepMessage = notEnoughSleep;
		} else {
			sleepMessage = completelyRested;
		}
		return sleepMessage;
			
	}

	public String getGroomingMessage() {
		String groomingMessage = "";
		String needMoreGroomingMessage = "You need to groom your pet more.";
		String enoughGroomingMessage = "Your pet has enough grooming.";

		if(getActualAmountOfPetMoraleAfterGrooming() >= adequateAmountOfGroomingTime)
		{
			groomingMessage = enoughGroomingMessage;
		}
		else {
			groomingMessage = needMoreGroomingMessage;
		}
		return groomingMessage;
	}
	
	public int tick() {
		return this.tick;
	}

}

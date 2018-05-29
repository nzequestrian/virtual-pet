import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	VirtualPet virtualPet = new VirtualPet(5, 50, 7, 50);

	@Test
	public void testWhenMyPetIsHungryThatIFeedItAndManageFoodSupply() {

		int expectedAmountOfFoodAfterEating = 45;
		assertEquals(expectedAmountOfFoodAfterEating, virtualPet.getActualAmountOfFoodAfterEating());
	}

	@Test
	public void testThatWhenIFeedPetIGetMessageTellingMeIfPetIsFullOrSick() {
		String feedMoreMessage = "Please feed Pet more food";
		String feedPerfectMessage = "Pet is perfectly fed!";
		String feedLessMessage = "Please feed Pet less food as Pet is sick now!";

		int feedPortion = 5;
		assertEquals(feedMoreMessage, virtualPet.feedPetAndCheckPetsSatisfactionLevel(feedPortion));
		feedPortion = 10;
		assertEquals(feedPerfectMessage, virtualPet.feedPetAndCheckPetsSatisfactionLevel(feedPortion));
		feedPortion = 21;
		assertEquals(feedLessMessage, virtualPet.feedPetAndCheckPetsSatisfactionLevel(feedPortion));
	}

	@Test
	public void testExpectedAmountOfMoraleAfterGrooming() {

		int expectedAmountOfMoraleAfterGrooming = 57;
		Assert.assertEquals(expectedAmountOfMoraleAfterGrooming, virtualPet.getActualAmountOfPetMoraleAfterGrooming());
	}
	
	@Test
	public void testThatWhenMyPetGetsGroomedItsMoraleGoesUp() {
		String needMoreGroomingMessage = "You need to groom your pet more.";
		String enoughGroomingMessage = "Your pet has enough grooming.";
		
		assertEquals(enoughGroomingMessage, virtualPet.getGroomingMessage());
		virtualPet.morale = 6;
		assertEquals(needMoreGroomingMessage, virtualPet.getGroomingMessage());

	}

	@Test
	public void testThatMyPetsManureIsAtAcceptableLevels() {
		// I don't need to clean my pets manure if its less than level 10
		// I need to clean my pets manure if its above 10
		// My pet will be sick if the manure level gets above 15

		String safeLevelMessage = "Pet is healthy, you don't need to pick up manure!";
		String timeToCleanLevelMessage = "Clean up the manure before your pet gets sick!";
		String dangerLevelMessage = "Your pet is probably sick now you lazy piece of manure!";

		VirtualPet virtualPet = new VirtualPet();

		assertEquals(safeLevelMessage,
				virtualPet.doINeedToCleanMyPetsManureAfterACleaning(virtualPet.cleanUpAfterPet(14)));
		assertEquals(timeToCleanLevelMessage,
				virtualPet.doINeedToCleanMyPetsManureAfterACleaning(virtualPet.cleanUpAfterPet(16)));
		assertEquals(dangerLevelMessage,
				virtualPet.doINeedToCleanMyPetsManureAfterACleaning(virtualPet.cleanUpAfterPet(20)));
	}

	@Test
	public void testThatMyPetNeedsToGoToTheVet() {

		virtualPet.feedPetAndCheckPetsSatisfactionLevel(21);
		assertTrue(virtualPet.isMyPetSick);
		virtualPet.isMyPetSick = false;

		virtualPet.doINeedToCleanMyPetsManureAfterACleaning(16);
		assertTrue(virtualPet.isMyPetSick);

	}

	@Test
	public void testDoesMyPetNeedPlaytime() {
		String notEnoughExerciseMessage = "Pet needs more exercise!";
		String perfectExerciseMessage = "Thanks, pet is happy to be out running around!";
		String tooMuchExercise = "You exercised me too much, I might be hurt. Please call the vet!";

		int playtime = 15;
		assertEquals(notEnoughExerciseMessage, virtualPet.doesMyPetHaveEnoughExercise(playtime));

		playtime = 60;
		assertEquals(perfectExerciseMessage, virtualPet.doesMyPetHaveEnoughExercise(playtime));

		virtualPet.isMyPetSick = false;
		playtime = 61;
		assertEquals(tooMuchExercise, virtualPet.doesMyPetHaveEnoughExercise(playtime));
		assertTrue(virtualPet.isMyPetSick);

	}

	@Test
	public void testDoesMyPetNeedRest() {
		String notEnoughSleep = "Pet needs to rest!";
		String completelyRested = "Thanks, pet is happy to be rested!";
		int timeSlept = 1;

		assertEquals(notEnoughSleep, virtualPet.doesPetNeedSleep(timeSlept));

		timeSlept = 9;

		assertEquals(completelyRested, virtualPet.doesPetNeedSleep(timeSlept));

	}


}
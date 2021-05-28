package model;

public class TextToSpeechAPIFactory {

	private TTSFacade dummyAudioManager;
	
	public TextToSpeechAPIFactory() {

	}
	
	public TTSFacade createTTSAPI(String text) {
		if(text == "real") {
			TTSFacade freeAudioManager = new FreeTTSAdapter();
			return freeAudioManager;
		}
		else  {
			System.out.println("Adapter not found.");
			return dummyAudioManager;
		}
		
	}
}
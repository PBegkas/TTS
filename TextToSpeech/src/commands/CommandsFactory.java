package commands;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JTextArea;
import model.Document;
import output.SaveDocument;
import input.OpenDocument;
import commands.LineSpeech;

public class CommandsFactory {

	//constructor passed objects
	JTextArea textArea;
	JFrame frame;
	JSlider volumeSlider;
	JSlider rateSlider;
	JSpinner pitchSpinner;
	//document object carried over from view
	Document curDocument;
	//commands
	public ActionListener newListener = null;

	private NewDocument newDocument;
	private SaveDocument saveDocument;
	private OpenDocument openDocument;
	private EditDocument editDocument;
	
	private LineSpeech playContents;
	private LineSpeech playReverseContents;
	private LineSpeech playLine;
	private LineSpeech playReverseLine;
	private LineSpeech playEncodedDocument;
	private LineSpeech playEncodedLine;
	
	private TuneEncoding rot13;
	private TuneEncoding atBash;
	
	private TuneAudio tuneAudio;
	
	private ReplayCommand startReplay;
	private ReplayCommand stopReplay;
	private ReplayCommand playReplay;
	
	private static boolean startReplayBool = false;
	
	private ArrayList<ActionListener> commandList = new ArrayList<ActionListener>();
	
	//arraylist in order to pass boolean by reference 
	private ArrayList<Boolean> replayBool = new ArrayList<Boolean>();

	public CommandsFactory(JTextArea textArea, JFrame frame, Document curDocument, JSlider volumeSlider, JSlider rateSlider, JSpinner pitchSpinner) {
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		this.volumeSlider = volumeSlider;
		this.rateSlider = rateSlider;
		this.pitchSpinner = pitchSpinner;
		//Document
		this.curDocument = curDocument;
		replayBool.add(startReplayBool);
	}

	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			newDocument = new NewDocument(textArea, frame, curDocument, commandList, replayBool);
			return newDocument;
		} else if(s.equals("Save")) {
			saveDocument = new SaveDocument(curDocument,commandList, replayBool);
			return saveDocument;
		}
		else if(s.equals("Open...")) {
			openDocument = new OpenDocument(textArea, frame, curDocument, commandList, replayBool);
			return openDocument;
		}
		else if(s.equals("Edit")) {
			editDocument = new EditDocument(textArea, curDocument, commandList, replayBool);
			return editDocument;
		}
		else if(s.equals("Play document")) {
			playContents = new LineSpeech(textArea, curDocument, 1, commandList, replayBool);
			return playContents;
		}
		else if(s.equals("Play reverse document")) {
			playReverseContents = new LineSpeech(textArea, curDocument, 2, commandList, replayBool);
			return playReverseContents;
		}
		else if(s.equals("Play reverse line")) {
			playReverseLine = new LineSpeech(textArea, curDocument, 4, commandList, replayBool);
			return playReverseLine;
		}
		else if(s.equals("Play line")) {
			playLine = new LineSpeech(textArea, curDocument, 3, commandList, replayBool);
			return playLine;
		}
		else if(s.equals("Play encoded document")) {
			playEncodedDocument = new LineSpeech(textArea, curDocument, 5, commandList, replayBool);
			return playEncodedDocument;
		}
		else if(s.equals("Play encoded line")) {
			playEncodedLine = new LineSpeech(textArea, curDocument, 6, commandList, replayBool);
			return playEncodedLine;
		}
		else if(s.equals("Rot13")) {
			rot13 = new TuneEncoding(curDocument, 2, commandList, replayBool);
			return rot13;
		}
		else if(s.equals("AtBash")) {
			atBash = new TuneEncoding(curDocument, 1, commandList, replayBool);
			return atBash;
		}
		else if(s.equals("TuneAudio")) {
			tuneAudio = new TuneAudio(curDocument, volumeSlider, rateSlider, pitchSpinner, commandList, replayBool);
			return tuneAudio;
		}
		else if(s.equals("Start recording commands")){
			startReplay = new ReplayCommand(3,commandList,replayBool);
			return startReplay;
		}
		else if(s.equals("Stop recording commands")){
			stopReplay = new ReplayCommand(1,commandList,replayBool);
			return stopReplay;
		}
		else if(s.equals("Play recorded commands")){
			playReplay = new ReplayCommand(2,commandList,replayBool);
			return playReplay;
		}
		//add other commands
		return temp;
	}
	
	//setter and getter for the start replay command operation
	public static void setStartReplayBool(boolean value) {
		 startReplayBool = value;
	}
	
	public static boolean getStartReplayBool() {
		return startReplayBool;
	}
}

package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator {

	private String cenzoredWord = null;

	/**
	 * @param maxLength
	 */
	public WordCensor(String word) {
		cenzoredWord = word;
	}

	/** 
	 * @param i
	 * @param decoratedChannel
	 */
	public WordCensor(String word, SocialChannel decoratedChannel) {
		cenzoredWord=word;
		this.delegate = decoratedChannel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.decorator.channel.
	 * SocialChannel#deliverMessage(java.lang.String)
	 */
	@Override
	public void deliverMessage(String message) {
		message=message.replaceAll(cenzoredWord, "####");
		delegate.deliverMessage(message);
	}
}

package info.bomas.rxjava.sandbox;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;

public class CreateExampleLambda {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateExampleLambda.class);

	public static void main(String[] args) {

		Observable.create(observer -> {
			try {
				if (!observer.isUnsubscribed()) {
					for (int i = 1; i < 5; i++) {
						observer.onNext(i);
					}
					observer.onCompleted();
				}
			} catch (Exception e) {
				observer.onError(e);
			}
		}).subscribe(item -> LOGGER.info("Next: {}", item), 
				error -> LOGGER.info("Error: {}", error.getMessage()),
				() -> LOGGER.info("Sequence complete."));
		
		
		Observable.range(1, 5)
		.subscribe(item -> LOGGER.info("Next: {}", item), 
				error -> LOGGER.info("Error: {}", error.getMessage()),
				() -> LOGGER.info("Sequence complete."));
		
		
		Observable.range(1, 5)
		.subscribe(item -> LOGGER.info("Next: {}", item));
		
		
		List<String> input = Arrays.asList("a","b","c","d");
		
		Observable.from(input)
		.subscribe(item -> LOGGER.info("Next: {}", item));
		
		Observable.just("something")
		.subscribe(item -> LOGGER.info("Next: {}", item));
		
	}

}

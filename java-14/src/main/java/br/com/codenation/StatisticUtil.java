package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class StatisticUtil {

	private StatisticUtil() {}

	public static int average(int[] elements) {
		return IntStream.of(elements).sum() / elements.length;
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> occurrences = new HashMap<>();
		int mostFrequent = 0;
		int mostOccurrences = 0;

		for (int num : elements) {
			if (occurrences.get(num) == null)
				occurrences.put(num, 1);
			else
				occurrences.put(num, occurrences.get(num) + 1);

			if (mostOccurrences < occurrences.get(num)) {
				mostOccurrences = occurrences.get(num);
				mostFrequent = num;
			}
		}

		return mostFrequent;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);

		if (elements.length % 2 == 0)
			return (elements[elements.length / 2 - 1] + elements[elements.length / 2]) / 2;

		return elements[elements.length / 2];
	}
}

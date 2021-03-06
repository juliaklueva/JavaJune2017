package lesson170728.exceptions;

import java.util.Arrays;

public class StringStackWithTryCatch {

	private static final int DEFAULT_MAX_SIZE = 3;
	private String[] elements;
	private int size;

	public StringStackWithTryCatch() {
		this(DEFAULT_MAX_SIZE);
	}

	public StringStackWithTryCatch(int maxSize) {
		elements = new String[maxSize];
		size = 0;
	}

	public boolean push(String string) {
		try {
			this.elements[this.size++] = string;
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return false;
		}
		return true;
	}

	public String pop() {
		if (size <= 0) { // guard condition
			return null; // stack underflow
		}
		String result = elements[--size];
		elements[size] = null;
		return result;
	}

	public int size() {
		return size;
	}

	public String tos() {
		return size <= 0 ? null : elements[size - 1];
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
	}

}

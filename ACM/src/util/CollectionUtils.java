package util;

/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/


import java.util.*;

public abstract class CollectionUtils {
	private static class EnumerationIterator implements Iterator {

		private Enumeration enumeration;

		public boolean hasNext() {
			return enumeration.hasMoreElements();
		}

		public Object next() {
			return enumeration.nextElement();
		}

		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Not supported.");
		}

		public EnumerationIterator(Enumeration enumeration) {
			this.enumeration = enumeration;
		}
	}

	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}

	public static List arrayToList(Object source) {
		return Arrays.asList(ObjectUtils.toObjectArray(source));
	}

	public static void mergeArrayInfoCollection(Object array,
			Collection collection) {
		if (collection == null)
			throw new IllegalArgumentException("Collection is null.");
		Object arr[] = ObjectUtils.toObjectArray(array);
		Object arr$[] = arr;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			Object elem = arr$[i$];
			collection.add(elem);
		}

	}

	public static void mergePropertiesIntoMap(Properties props, Map map) {
		if (map == null)
			throw new IllegalArgumentException("Map is null.");
		if (props != null) {
			String key;
			Object value;
			for (Enumeration en = props.propertyNames(); en.hasMoreElements(); map
					.put(key, value)) {
				key = (String) en.nextElement();
				value = props.getProperty(key);
				if (value == null)
					value = props.get(key);
			}

		}
	}

	public static boolean contains(Iterator iterator, Object element) {
		if (iterator != null)
			while (iterator.hasNext()) {
				Object candidate = iterator.next();
				if (ObjectUtils.nullSafeEquals(candidate, element))
					return true;
			}
		return false;
	}

	public static boolean contains(Enumeration enumeration, Object element) {
		if (enumeration != null)
			while (enumeration.hasMoreElements()) {
				Object candidate = enumeration.nextElement();
				if (ObjectUtils.nullSafeEquals(candidate, element))
					return true;
			}
		return false;
	}

	public static boolean containsInstance(Collection collection, Object element) {
		label0: {
			if (collection == null)
				break label0;
			Iterator i$ = collection.iterator();
			Object candidate;
			do {
				if (!i$.hasNext())
					break label0;
				candidate = i$.next();
			} while (candidate != element);
			return true;
		}
		return false;
	}

	public static boolean containsAny(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates))
			return false;
		for (Iterator i$ = candidates.iterator(); i$.hasNext();) {
			Object candidate = i$.next();
			if (source.contains(candidate))
				return true;
		}

		return false;
	}

	public static Object findFirstMatch(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates))
			return null;
		for (Iterator i$ = candidates.iterator(); i$.hasNext();) {
			Object candidate = i$.next();
			if (source.contains(candidate))
				return candidate;
		}

		return null;
	}

	public static Object findValueOfType(Collection collection, Class type) {
		if (isEmpty(collection))
			return null;
		Object value = null;
		Iterator i$ = collection.iterator();
		do {
			if (!i$.hasNext())
				break;
			Object element = i$.next();
			if (type == null || type.isInstance(element)) {
				if (value != null)
					return null;
				value = element;
			}
		} while (true);
		return value;
	}

	public static Object findValueOfType(Collection collection, Class types[]) {
		if (isEmpty(collection) || ObjectUtils.isEmpty(types))
			return null;
		Class arr$[] = types;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			Class type = arr$[i$];
			Object value = findValueOfType(collection, type);
			if (value != null)
				return value;
		}

		return null;
	}

	public static boolean hasUniqueObject(Collection collection) {
		label0: {
			if (isEmpty(collection))
				return false;
			boolean hasCandidate = false;
			Object candidate = null;
			Object elem;
			label1: do {
				for (Iterator i$ = collection.iterator(); i$.hasNext();) {
					elem = i$.next();
					if (hasCandidate)
						continue label1;
					hasCandidate = true;
					candidate = elem;
				}

				break label0;
			} while (candidate == elem);
			return false;
		}
		return true;
	}

	public static Class findCommonElementType(Collection collection) {
		Class candidate;
		label0: {
			if (isEmpty(collection))
				return null;
			candidate = null;
			Object val;
			label1: do {
				for (Iterator i$ = collection.iterator(); i$.hasNext();) {
					val = i$.next();
					if (val != null) {
						if (candidate != null)
							continue label1;
						candidate = val.getClass();
					}
				}

				break label0;
			} while (candidate == val.getClass());
			return null;
		}
		return candidate;
	}

	public static Object[] toArray(Enumeration enumeration, Object array[]) {
		ArrayList elements = new ArrayList();
		for (; enumeration.hasMoreElements(); elements.add(enumeration
				.nextElement()))
			;
		return elements.toArray(array);
	}

	public static Iterator toIterator(Enumeration enumeration) {
		return new EnumerationIterator(enumeration);
	}
}

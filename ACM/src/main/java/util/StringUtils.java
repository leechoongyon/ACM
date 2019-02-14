package util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StringUtils {
	
	
	
	
	
	/**
	 * 
	 * // 한글 잘라내기 함수에서 new string할 때 encoding안너주면 서버 locale에따라 값이 달라짐. 바이트를 받아서 스트링으로 한 번 변환해주고 이 스트링을 받아서 서버로 보낼땐 바이트로 변경해주니 반드시 이 과정과정에서 인코딩 주의깊게 해줘야함.
	 * // 이거 안지켜서 arraycopy할 때 바이트 제한된크기를 넘겨버려서 에러 떨굼.
	 * 
	 */
	
	public static String splitStringToByte(String str, int beginIndex, int range, String encoding)
	{
		int count = 0;	// 한글 갯수 체크 (바이트 단위로)

		String result = "";
		
		try {
			byte [] strByte = str.getBytes(encoding);

			//한글은 1바이트로 읽으면 음수가 나온다. 이를 이용하여 한글 꺠지는 것을 방지.
			for(int i = beginIndex ; i < beginIndex + range ; i++)
			{
				if(strByte[i] < 0)
					count++;
			}

			if("UTF-8".equals(encoding) || "utf-8".equals(encoding))
			{
				if(count % 3 == 0)
					result = new String(strByte, beginIndex, range, Charset.forName(encoding));
				else if(count % 3 == 1)
					result = new String(strByte, beginIndex, range - 1, Charset.forName(encoding));
				else if(count %3 ==2)
					result = new String(strByte, beginIndex, range - 2, Charset.forName(encoding));		
			}
			else if("ms949".equals(encoding) || "MS949".equals(encoding))
			{
				if(count % 2 ==0)
					result = new String(strByte, beginIndex, range, Charset.forName(encoding));
				else if(count % 2 == 1)
					result = new String(strByte, beginIndex, range - 1, Charset.forName(encoding));
			}
		} catch(UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	
	private static class SortNode {

		private int left;
		private int right;

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		public SortNode(int i, int j) {
			left = i;
			right = j;
		}
	}

	private static final String FOLDER_SEPARATOR = "/";
	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
	private static final String TOP_PATH = "..";
	private static final String CURRENT_PATH = ".";
	private static final char EXTENSION_SEPARATOR = 46;
	private static final int IP_ADDRESS = 0;
	public static final int EMAIL_ADDRESS = 1;
	public static final int WEB_ADDRESS = 2;
	public static final int ZIP_CODE = 3;
	public static final int SS_NO = 4;
	public static final int ER_NO = 5;
	public static final int TEL_NO = 6;
	public static final int SS_SNO = 7;
	public static final String IP_ADDRESS_PATTERN = "((([2][0-4][0-9])|([2][5][0-5])|([1][0-9]{2})|([1-9][0-9])|([0-9]))\\.){3}(([2][0-4][0-9])|([2][5][0-5])|([1][0-9]{2})|([1-9][0-9])|([0-9]))";
	public static final String EMAIL_ADDRESS_PATTERN = ".+@.+\\..+(\\..+){0,1}";
	public static final String WEB_ADDRESS_PATTERN = "http://.+";
	public static final String ZIP_CODE_PATTERN = "[0-9]{3}-[0-9]{3}";
	public static final String SSNO_PATTERN = "[0-9]{2}(([0][1-9])|([1][0-2]))[0|1|2|3][0-9]-[1|2|3|4][0-9]{6}";
	public static final String SSSNO_PATTERN = "[0-9]{2}(([0][1-9])|([1][0-2]))[0|1|2|3][0-9][1|2|3|4][0-9]{6}";
	public static final String ERNO_PATTERN = "[0-9]{3}-[0-9]{2}-[0-9]{5}";
	public static final String TELNO_PATTERN = "[0](([2])|([0-9]{2}))-[1-9][0-9]{2,3}-[0-9]{4}";
	public static final String LINE_SEP = System.getProperty("line.separator");
	public static final int LINE_SEP_LEN = LINE_SEP.length();
	public static final String EMPTY_STRING_ARRAY[] = new String[0];
	private static Random rgen = new Random();

	public static boolean isEmpty(CharSequence str) {
		if (null == str)
			return true;
		int i = 0;
		for (int n = str.length(); i < n; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;

		return true;
	}

	public static boolean hasLength(CharSequence str) {
		return str != null && str.length() > 0;
	}

	public static boolean hasLength(String str) {
		return hasLength(((CharSequence) (str)));
	}

	public static boolean hasText(CharSequence str) {
		if (!hasLength(str))
			return false;
		int strLen = str.length();
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return true;

		return false;
	}

	public static boolean hasText(String str) {
		return hasText(((CharSequence) (str)));
	}

	public static boolean containsWhitespace(CharSequence str) {
		if (!hasLength(str))
			return false;
		int strLen = str.length();
		for (int i = 0; i < strLen; i++)
			if (Character.isWhitespace(str.charAt(i)))
				return true;

		return false;
	}

	public static boolean containsWhitespace(String str) {
		return containsWhitespace(((CharSequence) (str)));
	}

	public static String trimWhitespace(String str) {
		if (!hasLength(str))
			return str;
		StringBuilder sb;
		for (sb = new StringBuilder(str); sb.length() > 0
				&& Character.isWhitespace(sb.charAt(0)); sb.deleteCharAt(0))
			;
		for (; sb.length() > 0
				&& Character.isWhitespace(sb.charAt(sb.length() - 1)); sb
				.deleteCharAt(sb.length() - 1))
			;
		return sb.toString();
	}

	public static String trimAllWhitespace(String str) {
		if (!hasLength(str))
			return str;
		StringBuffer sb = new StringBuffer(str);
		for (int index = 0; sb.length() > index;)
			if (Character.isWhitespace(sb.charAt(index)))
				sb.deleteCharAt(index);
			else
				index++;

		return sb.toString();
	}

	public static String trimLeadingWhitespace(String str) {
		if (!hasLength(str))
			return str;
		StringBuilder sb;
		for (sb = new StringBuilder(str); sb.length() > 0
				&& Character.isWhitespace(sb.charAt(0)); sb.deleteCharAt(0))
			;
		return sb.toString();
	}

	public static String trimTrailingWhitespace(String str) {
		if (!hasLength(str))
			return str;
		StringBuilder sb;
		for (sb = new StringBuilder(str); sb.length() > 0
				&& Character.isWhitespace(sb.charAt(sb.length() - 1)); sb
				.deleteCharAt(sb.length() - 1))
			;
		return sb.toString();
	}

	public static String trimLeadingCharacter(String str, char leadingChar) {
		if (!hasLength(str))
			return str;
		StringBuilder sb;
		for (sb = new StringBuilder(str); sb.length() > 0
				&& sb.charAt(0) == leadingChar; sb.deleteCharAt(0))
			;
		return sb.toString();
	}

	public static String trimTrailingCharacter(String str, char trailingChar) {
		if (!hasLength(str))
			return str;
		StringBuilder sb;
		for (sb = new StringBuilder(str); sb.length() > 0
				&& sb.charAt(sb.length() - 1) == trailingChar; sb
				.deleteCharAt(sb.length() - 1))
			;
		return sb.toString();
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null)
			return false;
		if (str.startsWith(prefix))
			return true;
		if (str.length() < prefix.length()) {
			return false;
		} else {
			String lcStr = str.substring(0, prefix.length()).toLowerCase();
			String lcPrefix = prefix.toLowerCase();
			return lcStr.equals(lcPrefix);
		}
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null)
			return false;
		if (str.endsWith(suffix))
			return true;
		if (str.length() < suffix.length()) {
			return false;
		} else {
			String lcStr = str.substring(str.length() - suffix.length())
					.toLowerCase();
			String lcSuffix = suffix.toLowerCase();
			return lcStr.equals(lcSuffix);
		}
	}

	public static boolean substringMatch(CharSequence str, int index,
			CharSequence substring) {
		for (int j = 0; j < substring.length(); j++) {
			int i = index + j;
			if (i >= str.length() || str.charAt(i) != substring.charAt(j))
				return false;
		}

		return true;
	}

	public static int countOccurrencesOf(String str, String sub) {
		if (str == null || sub == null || str.length() == 0
				|| sub.length() == 0)
			return 0;
		int count = 0;
		int idx;
		for (int pos = 0; (idx = str.indexOf(sub, pos)) != -1; pos = idx
				+ sub.length())
			count++;

		return count;
	}

	public static String replace(String inString, String oldSubstring,
			String newSubstring) {
		if (!hasLength(inString) || !hasLength(oldSubstring)
				|| newSubstring == null)
			return inString;
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		int index = inString.indexOf(oldSubstring);
		int patLen = oldSubstring.length();
		for (; index >= 0; index = inString.indexOf(oldSubstring, pos)) {
			sb.append(inString.substring(pos, index));
			sb.append(newSubstring);
			pos = index + patLen;
		}

		sb.append(inString.substring(pos));
		return sb.toString();
	}

	public static String delete(String inString, String toDeleteSubstring) {
		return replace(inString, toDeleteSubstring, "");
	}

	public static String deleteAny(String inString, String charsToDelete) {
		if (!hasLength(inString) || !hasLength(charsToDelete))
			return inString;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (charsToDelete.indexOf(c) == -1)
				sb.append(c);
		}

		return sb.toString();
	}

	public static String quote(String str) {
		return str == null ? null : (new StringBuilder()).append("'")
				.append(str).append("'").toString();
	}

	public static Object quoteIfString(Object obj) {
		return (obj instanceof String) ? quote((String) obj) : obj;
	}

	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	public static String unqualify(String qualifiedName, char separator) {
		return qualifiedName
				.substring(qualifiedName.lastIndexOf(separator) + 1);
	}

	public static String capitalize(String str) {
		return changeFirstCharacterCase(str, true);
	}

	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	public static String changeFirstCharacterCase(String str, boolean capitalize) {
		if (str == null || str.length() == 0)
			return str;
		StringBuilder sb = new StringBuilder(str.length());
		if (capitalize)
			sb.append(Character.toUpperCase(str.charAt(0)));
		else
			sb.append(Character.toLowerCase(str.charAt(0)));
		sb.append(str.substring(1));
		return sb.toString();
	}

	public static String getFilename(String path) {
		if (path == null) {
			return null;
		} else {
			int separatorindex = path.lastIndexOf("/");
			return separatorindex == -1 ? path : path
					.substring(separatorindex + 1);
		}
	}

	public static String getFilenameExtension(String path) {
		if (path == null)
			return null;
		int extIndex = path.lastIndexOf('.');
		if (extIndex == -1)
			return null;
		int folderIndex = path.lastIndexOf("/");
		if (folderIndex > extIndex)
			return null;
		else
			return path.substring(extIndex + 1);
	}

	public static String stripFilenameExtension(String path) {
		if (path == null)
			return null;
		int extIndex = path.lastIndexOf('.');
		if (extIndex == -1)
			return path;
		int folderIndex = path.lastIndexOf("/");
		if (folderIndex > extIndex)
			return path;
		else
			return path.substring(0, extIndex);
	}

	public static String applyRelativePath(String path, String relativePath) {
		if (path == null || relativePath == null)
			return null;
		int separatorIndex = path.lastIndexOf("/");
		if (separatorIndex != -1) {
			String newPath = path.substring(0, separatorIndex);
			if (!relativePath.startsWith("/"))
				newPath = (new StringBuilder()).append(newPath).append("/")
						.toString();
			return (new StringBuilder()).append(newPath).append(relativePath)
					.toString();
		} else {
			return relativePath;
		}
	}

	public static String cleanPath(String path) {
		if (path == null)
			return null;
		String pathToUse = replace(path, "\\", "/");
		int prefixIndex = pathToUse.indexOf(":");
		String prefix = "";
		if (prefixIndex != -1) {
			prefix = pathToUse.substring(0, prefixIndex + 1);
			pathToUse = pathToUse.substring(prefixIndex + 1);
		}
		if (pathToUse.startsWith("/")) {
			prefix = (new StringBuilder()).append(prefix).append("/")
					.toString();
			pathToUse = pathToUse.substring(1);
		}
		String pathArray[] = delimitedListToStringArray(pathToUse, "/");
		List pathElements = new LinkedList();
		int tops = 0;
		for (int i = pathArray.length - 1; i >= 0; i--) {
			String element = pathArray[i];
			if (".".equals(element))
				continue;
			if ("..".equals(element)) {
				tops++;
				continue;
			}
			if (tops > 0)
				tops--;
			else
				pathElements.add(0, element);
		}

		for (int i = 0; i < tops; i++)
			pathElements.add(0, "..");

		return (new StringBuilder()).append(prefix)
				.append(collectionToDelimitedString(pathElements, "/"))
				.toString();
	}

	public static boolean pathEquals(String path, String target) {
		return cleanPath(path).equals(cleanPath(target));
	}

	public static Locale parseLocaleString(String localeString) {
		for (int i = 0; i < localeString.length(); i++) {
			char ch = localeString.charAt(i);
			if (ch != '_' && ch != ' ' && !Character.isLetterOrDigit(ch))
				throw new IllegalArgumentException((new StringBuilder())
						.append("Locale value \"").append(localeString)
						.append("\" contains invalid characters.").toString());
		}

		String parts[] = tokenizeToStringArray(localeString, "_ ", false, false);
		String language = parts.length <= 0 ? "" : parts[0];
		String country = parts.length <= 1 ? "" : parts[1];
		String variant = "";
		if (parts.length >= 2) {
			int endIndexOfCountryCode = localeString.indexOf(country)
					+ country.length();
			variant = trimLeadingWhitespace(localeString
					.substring(endIndexOfCountryCode));
			if (variant.startsWith("_"))
				variant = trimLeadingCharacter(variant, '_');
		}
		return language.length() <= 0 ? null : new Locale(language, country,
				variant);
	}

	public static String toLanguageTag(Locale locale) {
		return (new StringBuilder())
				.append(locale.getLanguage())
				.append(hasText(locale.getCountry()) ? (new StringBuilder())
						.append("-").append(locale.getCountry()).toString()
						: "").toString();
	}

	public static String[] addStringToArray(String array[], String str) {
		if (ObjectUtils.isEmpty(array)) {
			return (new String[] { str });
		} else {
			String newArr[] = new String[array.length + 1];
			System.arraycopy(array, 0, newArr, 0, array.length);
			newArr[array.length] = str;
			return newArr;
		}
	}

	public static String[] concatenateStringArrays(String array1[],
			String array2[]) {
		if (ObjectUtils.isEmpty(array1))
			return array2;
		if (ObjectUtils.isEmpty(array2)) {
			return array1;
		} else {
			String newArr[] = new String[array1.length + array2.length];
			System.arraycopy(array1, 0, newArr, 0, array1.length);
			System.arraycopy(array2, 0, newArr, array1.length, array2.length);
			return newArr;
		}
	}

	public static String[] mergeStringArrays(String array1[], String array2[]) {
		if (ObjectUtils.isEmpty(array1))
			return array2;
		if (ObjectUtils.isEmpty(array2))
			return array1;
		List result = new ArrayList();
		result.addAll(Arrays.asList(array1));
		String arr$[] = array2;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			String str = arr$[i$];
			if (!result.contains(str))
				result.add(str);
		}

		return toStringArray(result);
	}

	public static String[] sortStringArray(String array[]) {
		if (ObjectUtils.isEmpty(array)) {
			return new String[0];
		} else {
			Arrays.sort(array);
			return array;
		}
	}

	public static String[] sort(String src[], int left, int right, boolean flag) {
		if (src == null)
			return src;
		if (left < 0)
			left = 0;
		if (right >= src.length)
			right = src.length - 1;
		Stack stack = new Stack();
		SortNode sortnode = new SortNode(left, right);
		stack.push(sortnode);
		if (flag)
			do {
				if (stack.empty())
					break;
				SortNode sortnode1 = (SortNode) stack.pop();
				int k1 = sortnode1.getLeft();
				int i2 = sortnode1.getRight();
				int k = rand(k1, i2);
				swap(src, k1, k);
				int i1 = k1;
				for (int k2 = k1 + 1; k2 <= i2; k2++)
					if (src[k2].compareToIgnoreCase(src[k1]) < 0)
						swap(src, ++i1, k2);

				swap(src, k1, i1);
				if (i1 < i2)
					stack.push(new SortNode(i1 + 1, i2));
				if (i1 > k1)
					stack.push(new SortNode(k1, i1 - 1));
			} while (true);
		else
			do {
				if (stack.empty())
					break;
				SortNode sortnode2 = (SortNode) stack.pop();
				int l1 = sortnode2.getLeft();
				int j2 = sortnode2.getRight();
				int l = rand(l1, j2);
				swap(src, l1, l);
				int j1 = l1;
				for (int l2 = l1 + 1; l2 <= j2; l2++)
					if (src[l2].compareToIgnoreCase(src[l1]) > 0)
						swap(src, ++j1, l2);

				swap(src, l1, j1);
				if (j1 < j2)
					stack.push(new SortNode(j1 + 1, j2));
				if (j1 > l1)
					stack.push(new SortNode(l1, j1 - 1));
			} while (true);
		return src;
	}

	public static String[] toStringArray(Collection collection) {
		if (collection == null)
			return null;
		else
			return (String[]) collection.toArray(new String[collection.size()]);
	}

	public static String[] toStringArray(Enumeration enumeration) {
		if (enumeration == null) {
			return null;
		} else {
			List list = Collections.list(enumeration);
			return (String[]) list.toArray(new String[list.size()]);
		}
	}

	public static String[] trimArrayElements(String array[]) {
		if (ObjectUtils.isEmpty(array))
			return new String[0];
		String result[] = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			String element = array[i];
			result[i] = element == null ? null : element.trim();
		}

		return result;
	}

	public static String[] removeDuplicateStrings(String array[]) {
		if (ObjectUtils.isEmpty(array))
			return array;
		Set set = new TreeSet();
		String element;
		for (Iterator i$ = set.iterator(); i$.hasNext(); set.add(element))
			element = (String) i$.next();

		return toStringArray(set);
	}

	public static String[] split(String toSplit, String delimiter) {
		if (!hasLength(toSplit) || !hasLength(delimiter))
			return null;
		int offset = toSplit.indexOf(delimiter);
		if (offset < 0) {
			return null;
		} else {
			String beforeDelimiter = toSplit.substring(0, offset);
			String afterDelimiter = toSplit.substring(offset
					+ delimiter.length());
			return (new String[] { beforeDelimiter, afterDelimiter });
		}
	}

	public static Properties splitArrayElementsIntoProperties(String array[],
			String delimiter) {
		return splitArrayElementsIntoProperties(array, delimiter, null);
	}

	public static Properties splitArrayElementsIntoProperties(String array[],
			String delimiter, String charsToDelete) {
		if (ObjectUtils.isEmpty(array))
			return null;
		Properties result = new Properties();
		String arr$[] = array;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			String element = arr$[i$];
			if (charsToDelete == null)
				element = deleteAny(element, charsToDelete);
			String splittedElement[] = split(element, delimiter);
			if (splittedElement != null)
				result.setProperty(splittedElement[0].trim(),
						splittedElement[1].trim());
		}

		return result;
	}

	public static String[] tokenizeToStringArray(String str, String delimiter) {
		return tokenizeToStringArray(str, delimiter, true, true);
	}

	public static String[] tokenizeToStringArray(String str, String delimiter,
			boolean trimTokens, boolean ignoreEmptyTokens) {
		if (str == null)
			return null;
		StringTokenizer st = new StringTokenizer(str, delimiter);
		List tokens = new ArrayList();
		do {
			if (!st.hasMoreTokens())
				break;
			String token = st.nextToken();
			if (trimTokens)
				token = token.trim();
			if (!ignoreEmptyTokens || token.length() > 0)
				tokens.add(token);
		} while (true);
		return toStringArray(tokens);
	}

	public static String[] delimitedListToStringArray(String str,
			String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}

	public static String[] delimitedListToStringArray(String str,
			String delimiter, String charsToDelete) {
		if (str == null)
			return new String[0];
		if (delimiter == null)
			return (new String[] { str });
		List result = new ArrayList();
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++)
				result.add(deleteAny(str.substring(i, i + 1), charsToDelete));

		} else {
			int pos;
			int delPos;
			for (pos = 0; (delPos = str.indexOf(delimiter, pos)) != -1; pos = delPos
					+ delimiter.length())
				result.add(deleteAny(str.substring(pos, delPos), charsToDelete));

			if (str.length() > 0 && pos <= str.length())
				result.add(deleteAny(str.substring(pos), charsToDelete));
		}
		return toStringArray(result);
	}

	public static String[] commaDelimitedListToStringArray(String str) {
		return delimitedListToStringArray(str, ",");
	}

	public static Set commaDelimitedListToSet(String str) {
		Set set = new TreeSet();
		String tokens[] = commaDelimitedListToStringArray(str);
		String arr$[] = tokens;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			String token = arr$[i$];
			set.add(token);
		}

		return set;
	}

	public static String collectionToDelimitedString(Collection coll,
			String delim, String prefix, String suffix) {
		if (CollectionUtils.isEmpty(coll))
			return "";
		StringBuilder sb = new StringBuilder();
		Iterator it = coll.iterator();
		do {
			if (!it.hasNext())
				break;
			sb.append(prefix).append(it.next()).append(suffix);
			if (it.hasNext())
				sb.append(delim);
		} while (true);
		return sb.toString();
	}

	public static String collectionToDelimitedString(Collection coll,
			String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}

	public static String collectionToCommaDelimitedString(Collection coll) {
		return collectionToDelimitedString(coll, ",");
	}

	public static String arrayToDelimitedString(Object arr[], String delim) {
		if (ObjectUtils.isEmpty(arr))
			return "";
		if (arr.length == 1)
			return ObjectUtils.nullSafeToString(arr[0]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0)
				sb.append(delim);
			sb.append(arr[i]);
		}

		return sb.toString();
	}

	public static String arrayToCommaDelimitedString(String arr[]) {
		return arrayToDelimitedString(arr, ",");
	}

	public static boolean isHangul(char inputChar) {
		String unicodeBlock = Character.UnicodeBlock.of(inputChar).toString();
		return "HANGUL_JAMO".equals(unicodeBlock)
				|| "HANGUL_SYLLABLES".equals(unicodeBlock)
				|| "HANGUL_COMPATIBILITY_JAMO".equals(unicodeBlock);
	}

	public static boolean isHangul(String inString, boolean full) {
		if (!hasLength(inString))
			return false;
		char chars[] = inString.toCharArray();
		if (!full) {
			for (int i = 0; i < chars.length; i++)
				if (isHangul(chars[i]))
					return true;

			return false;
		}
		for (int i = 0; i < chars.length; i++)
			if (!isHangul(chars[i]))
				return false;

		return true;
	}

	public static boolean isLetter(String inString) {
		if (inString == null)
			return false;
		char chars[] = inString.toCharArray();
		for (int i = 0; i < chars.length; i++)
			if (!Character.isLetter(chars[i]))
				return false;

		return true;
	}

	public static boolean isDigit(String inString) {
		if (inString == null)
			return false;
		char chars[] = inString.toCharArray();
		for (int i = 0; i < chars.length; i++)
			if (!Character.isDigit(chars[i]))
				return false;

		return true;
	}

	public static boolean isLetterOrDigit(String inString) {
		if (inString == null)
			return false;
		char chars[] = inString.toCharArray();
		for (int i = 0; i < chars.length; i++)
			if (!Character.isLetterOrDigit(chars[i]))
				return false;

		return true;
	}

	public static Object nvl(Object obj, Object rvalue) {
		return obj != null ? obj : rvalue;
	}

	public static String nvl(String str, String rStr) {
		return str != null ? str : rStr;
	}

	public static String nvl(String str) {
		return str != null ? str : "";
	}

	public static boolean isFormattedString(String string, int patternId) {
		switch (patternId) {
		case 0: // '\0'
			return isFormattedString(
					string,
					"((([2][0-4][0-9])|([2][5][0-5])|([1][0-9]{2})|([1-9][0-9])|([0-9]))\\.){3}(([2][0-4][0-9])|([2][5][0-5])|([1][0-9]{2})|([1-9][0-9])|([0-9]))");

		case 1: // '\001'
			return isFormattedString(string, ".+@.+\\..+(\\..+){0,1}");

		case 2: // '\002'
			return isFormattedString(string, "http://.+");

		case 3: // '\003'
			return isFormattedString(string, "[0-9]{3}-[0-9]{3}");

		case 4: // '\004'
			return isFormattedString(string,
					"[0-9]{2}(([0][1-9])|([1][0-2]))[0|1|2|3][0-9]-[1|2|3|4][0-9]{6}");

		case 5: // '\005'
			return isFormattedString(string, "[0-9]{3}-[0-9]{2}-[0-9]{5}");

		case 6: // '\006'
			return isFormattedString(string,
					"[0](([2])|([0-9]{2}))-[1-9][0-9]{2,3}-[0-9]{4}");

		case 7: // '\007'
			return isFormattedString(string,
					"[0-9]{2}(([0][1-9])|([1][0-2]))[0|1|2|3][0-9][1|2|3|4][0-9]{6}");
		}
		return false;
	}

	public static boolean isFormattedString(String string, String pattern) {
		if (string == null || pattern == null)
			return false;
		else
			return string.matches(pattern);
	}

	public static String toZipCodePattern(String string) {
		if (string == null)
			return "";
		if (string.length() != 6 || !isDigit(string)) {
			return "";
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(string.substring(0, 3));
			buffer.append('-');
			buffer.append(string.substring(3, 6));
			return buffer.toString();
		}
	}

	public static String toErNoPattern(String string) {
		if (string == null)
			return "";
		if (string.length() != 10 || !isDigit(string)) {
			return "";
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(string.substring(0, 3));
			buffer.append('-');
			buffer.append(string.substring(3, 5));
			buffer.append('-');
			buffer.append(string.substring(5, 10));
			return buffer.toString();
		}
	}

	public static String toSsNoPattern(String string) {
		if (string == null)
			return "";
		if (string.length() != 13 || !isDigit(string)) {
			return "";
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(string.substring(0, 6));
			buffer.append('-');
			buffer.append(string.substring(6));
			return buffer.toString();
		}
	}

	public static String toPureDigit(String string) {
		if (string == null)
			return "";
		else
			return string.replaceAll("[^0-9]", "");
	}

	public static String numberFormat(double dvalue, String format) {
		DecimalFormat decimalformat = new DecimalFormat(format);
		return decimalformat.format(dvalue);
	}

	public static String numberFormat(float fvalue, String format) {
		DecimalFormat decimalformat = new DecimalFormat(format);
		return decimalformat.format(fvalue);
	}

	public static String numberFormat(long lvalue, String format) {
		DecimalFormat decimalformat = new DecimalFormat(format);
		return decimalformat.format(lvalue);
	}

	public static String numberFormat(int ivalue, String format) {
		DecimalFormat decimalformat = new DecimalFormat(format);
		return decimalformat.format(ivalue);
	}

	public static String numberFormat(short svalue, String format) {
		DecimalFormat decimalformat = new DecimalFormat(format);
		return decimalformat.format(svalue);
	}

	public static boolean isSpace(String string) {
		if (string == null)
			return false;
		else
			return string.trim().length() <= 0;
	}

	public static String lpad(String str, int length, String pad) {
		if (str == null)
			str = "";
		if (pad == null)
			pad = " ";
		int j = str.length();
		if (j > length)
			return str.substring(0, length);
		if (j == length)
			return str;
		int k = pad.length();
		int l = length - j;
		int i1 = l / k;
		int j1 = l % k;
		StringBuffer stringbuffer = new StringBuffer();
		for (; i1 > 0; i1--)
			stringbuffer.append(pad);

		if (j1 > 0)
			stringbuffer.append(pad.substring(0, j1));
		stringbuffer.append(str);
		return stringbuffer.toString();
	}

	public static String rpad(String str, int length, String pad) {
		if (str == null)
			str = "";
		if (pad == null)
			pad = " ";
		int j = str.length();
		if (j > length)
			return str.substring(j - length);
		if (j == length)
			return str;
		int k = pad.length();
		int l = length - j;
		int i1 = l / k;
		int j1 = l % k;
		StringBuffer stringbuffer = new StringBuffer();
		stringbuffer.append(str);
		for (; i1 > 0; i1--)
			stringbuffer.append(pad);

		if (j1 > 0)
			stringbuffer.append(pad.substring(0, j1));
		return stringbuffer.toString();
	}

	private static int rand(int i, int j) {
		return i + Math.abs(rgen.nextInt()) % ((j - i) + 1);
	}

	private static Object[] swap(Object aobj[], int i, int j) {
		Object obj = aobj[i];
		aobj[i] = aobj[j];
		aobj[j] = obj;
		return aobj;
	}


	public static String RemoveBlank(String str)
	{
		return str.trim();
	}
	
}

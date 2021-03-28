package com.demo;

public class StringUtil
{
	public static int maxLengthValue =0;
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> 'xxxxx'
	public static String replicate(char c, int n)
	{
		String result = "";
		for ( int i =0; i<n; i++ )
		{
			result += c;
		}
			return result;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c)
	{
		String paddedString ="";
		int stringSize = s.length();
		if (n > stringSize)
		{
			paddedString = replicate(c, n - stringSize);
		}
		paddedString += s;
		return paddedString;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] stringArray = new String[arr.length];
		for (int i=0; i < arr.length; i++)
		{
			stringArray[i] = Integer.toString(arr[i]);
		}
		return stringArray;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] intArray = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			intArray[i] = Integer.parseInt(arr[i]);
		}
		return intArray;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		maxLengthValue = -1;
		for (String element :arr)
		{
			maxLengthValue = Math.max(maxLengthValue, element.length());
		}
		return maxLengthValue;
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String []arr, char c)
	{
		int maxLength = maxLength(arr);
		for(int i =0; i<arr.length; i++) {
			arr[i] = lpad(arr[i], maxLength, c);
		}
	}
}

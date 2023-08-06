public class Vigenere{
	public static void main(String[] args) {
		
		System.out.print("Plain Text : "+decrypt("OZELNVUXTGWHVUBJLVTYDKURVDVFKPNA","tryhard"));
		System.out.println();
		System.out.print("Plain Text : "+decrypt("XCECKVJSLKOUHTXIIYEXBOGRTIEEBXJIG","Practice"));

	}

	public static StringBuffer encrypt(String plain,String key){

		StringBuffer cipherText=new StringBuffer();

		for (int i=0; i<plain.length() ;i++) {

			int indexChar=(int)plain.charAt(i)-97;
			int indexKey=(int)key.charAt(i%key.length())-97;
			int value=(indexKey+indexChar)%26;
			char character=(char) (value+97);
			cipherText.append(character);
			
		}
		return cipherText;

	}

	public static StringBuffer decrypt(String cipherUf,String keyUf){
		String key=keyUf.toLowerCase();
		String cipher=cipherUf.toLowerCase();
		char character='a';
		StringBuffer plainText=new StringBuffer();
		System.out.println("Cipher Text: "+cipherUf+" Using key: "+key);

		for (int i=0; i<cipher.length() ;i++) {

			int indexChar=(int)cipher.charAt(i)-97;
			int indexKey=(int)key.charAt(i%key.length())-97;
			int value=(indexChar-indexKey);

			if (value<0) {
				character=(char) ((26+value)+97);
			}else{
				character=(char) (value+97);

			}
			plainText.append(character);
			
		}

		return plainText;
	}
}
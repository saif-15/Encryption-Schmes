public class AffineCipher{

	public static void main(String[] args) {

		int[] numbers={1,3,5,7,9,11,15,17,19,21,23,25,121};
		for (int num :numbers ) {
			System.out.println(num+" inverse -> "+inverse(num));
		}

		System.out.println();
		System.out.println(decrypt("piwqpgxu kbbgxi wgjniv owniei go oike hq di pgbbgwalh dah ikoy",19,10));
	}

	public static StringBuffer encrypt(String plain,int keyA,int keyB){

		StringBuffer cipherText=new StringBuffer("");
		for (int i=0;i<plain.length();i++) {
			int value=(int)plain.charAt(i);
			if(value==32){
				cipherText.append(" ");
			}
			else{
				int index=value-97;
				int t= ((index*keyA)+keyB);
				if(t>=26)
					t=(t%26)+97;
				else
					t=t+97;
				cipherText.append((char)t);

			}
		}
		return cipherText;
	}
	public static StringBuffer decrypt(String cipher,int keyA,int keyB){
		System.out.println("Decrypting using Affine Cipher with Keys "+keyA+" and "+keyB+":");

		StringBuffer plainText=new StringBuffer("");
		for (int i=0;i<cipher.length();i++) {
			int value=(int)cipher.charAt(i);
			if(value==32){
				plainText.append(" ");
			}
			else{
				int index=value-97;
				int t= (index-keyB);
				if(t<0){
					t=t+26;
				}
				else if(t>=26)
					t=(t%26);
				t=((t*inverse(keyA))%26)+97;
				plainText.append((char)t);

			}
		}
		return plainText;
	}

	public static int inverse(int key){
		int inverse=0;
		int value=0;
		int multiplier=1;
		int number=26;
		while(true){
			value= (number*multiplier)+1;
			 multiplier++;
			 if(value%key==0){
			 	inverse=value/key;
			 	break;
			 }
		}
		return inverse;
	}




}
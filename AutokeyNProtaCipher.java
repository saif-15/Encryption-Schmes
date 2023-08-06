class AutokeyNProtaCipher{

	public static void main(String[] args) {
	
	System.out.println();
	System.out.println(decryptAutokey("dlcjm hw tusklmj tuwgn me vygczwttrnwr hnrt xuaklalmf vyi cgqhelbkhk dq xem lwgyxt","keysize"));		
	System.out.println(encryptOrDecryptPortaCipher("goiindugafybxjqofbnuynxjwhrcbinzolnsnjpjvgysety","bonusmarks"));
	}



	public static StringBuffer encryptAutokey(String plain,String key){

		StringBuffer cipher=new StringBuffer();
		int j=0;
		int spaces=0;
	
		for (int i=0;i<plain.length() ;i++ ) {
			
			int letter=(int) plain.charAt(i);

			if(letter==32){
				cipher.append(" ");
				spaces++;
				continue;
			}
			int index=letter-97;
			int keyLetter=0;

			if(i-spaces==key.length()){
				j=0;
				if ((int) plain.charAt(j)==32) {
					j++;
				}
				keyLetter=(int) plain.charAt(j);
			}
				
			else if(i-spaces<key.length())
				keyLetter=(int) key.charAt(j);
			else{
				if ((int) plain.charAt(j)==32) {
					j++;
				}
				keyLetter=(int) plain.charAt(j);
				}
			int keyIndex=keyLetter-97;
			j++;
		
			int character=((index+keyIndex)%26)+97;
//			int character=((index-keyIndex)%26)+97;

			cipher.append((char)character);

		}
		return cipher;
	}


		public static StringBuffer decryptAutokey(String cipher,String key){

		System.out.println(cipher);
		System.out.println("Decoding using AutoKeyCipher");

		StringBuffer plain=new StringBuffer();
		int j=0;
		int spaces=0;
		int ch;
		char character='a';
	
		for (int i=0;i<cipher.length() ;i++ ) {
			
			int letter=(int) cipher.charAt(i);
			

			if(letter==32){
				plain.append(" ");
				spaces++;
				continue;	
			}
			
			int index=letter-97; //10
			int keyLetter=0;

			if(i-spaces==key.length()){
				j=0;
				if ((int) plain.charAt(j)==32) {
					j++;
				}
				keyLetter=(int) plain.charAt(j);
			}
				
			else if(i-spaces<key.length())
				keyLetter=(int) key.charAt(j);
			else{
				if ((int) plain.charAt(j)==32) {
					j++;
				}
				keyLetter=(int) plain.charAt(j);
				}

			int keyIndex=keyLetter-97; //23
			j++;
			ch=(index-keyIndex);
			if (ch<0)
				character=(char) ((26+ch)+97);
			else
				character=(char) (ch+97);
			
			plain.append(character);
		}
		return plain;
}

	public static StringBuffer encryptOrDecryptPortaCipher(String message,String key){

		System.out.println();
		System.out.println(message);
		System.out.println("Decoding Using Prota Cipher Technique:");
		char[][] table={{'n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'},
						{'o','p','q','r','s','t','u','v','w','x','y','z','n','m','a','b','c','d','e','f','g','h','i','j','k','l'},
						{'p','q','r','s','t','u','v','w','x','y','z','n','o','l','m','a','b','c','d','e','f','g','h','i','j','k'},
						{'q','r','s','t','u','v','w','x','y','z','n','o','p','k','l','m','a','b','c','d','e','f','g','h','i','j'},
						{'r','s','t','u','v','w','x','y','z','n','o','p','q','j','k','l','m','a','b','c','d','e','f','g','h','i'},
						{'s','t','u','v','w','x','y','z','n','o','p','q','r','i','j','k','l','m','a','b','c','d','e','f','g','h'},
						{'t','u','v','w','x','y','z','n','o','p','q','r','s','h','i','j','k','l','m','a','b','c','d','e','f','g'},
						{'u','v','w','x','y','z','n','o','p','q','r','s','t','g','h','i','j','k','l','m','a','b','c','d','e','f'},
						{'v','w','x','y','z','n','o','p','q','r','s','t','u','f','g','h','i','j','k','l','m','a','b','c','d','e'},
						{'w','x','y','z','n','o','p','q','r','s','t','u','v','e','f','g','h','i','j','k','l','m','a','b','c','d'},
						{'x','y','z','n','o','p','q','r','s','t','u','v','w','d','e','f','g','h','i','j','k','l','m','a','b','c'},
						{'y','z','n','o','p','q','r','s','t','u','v','w','x','c','d','e','f','g','h','i','j','k','l','m','a','b'},
						{'z','n','o','p','q','r','s','t','u','v','w','x','y','b','c','d','e','f','g','h','i','j','k','l','m','a'}};


		StringBuffer text=new StringBuffer();
	
		for (int i=0; i<message.length() ;i++) {

			int indexChar=(int)message.charAt(i)-97;
			int indexKey=(int)key.charAt(i%key.length())-97;
			text.append(table[indexKey/2][indexChar]);
			
		}

		return text;
	}
}

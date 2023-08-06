import java.util.*;
public class HillCipher{
	public static void main(String[] args) {
		int[][] key1={{18,9},{27,36}};
		int[][] key2={{7,8},{11,11}};
	//	System.out.println("CIPHER: "+encrypt("either you value the things or you lost value",key1));
		System.out.println("PLAIN: "+decrypt("ogplrsmidwvggipljmqjcviccxqgmvbaovodta",key1));
	//	System.out.println("PLAIN: "+decrypt("APADJTFTWLFJ",key2));
	}

	public static StringBuffer encrypt(String p,int[][] key){
		StringBuffer cipher=new StringBuffer();
		String plain=p.replace(" ","");
		System.out.println("PLAIN:  "+p);
		int index_2=0;

		for (int i=0;i<plain.length();i+=2 ) {
			int index_1=(int)plain.charAt(i)-97;
			try{
				index_2=(int)plain.charAt(i+1)-97;
			}catch(Exception e){
				index_2=23;
			}
			finally{
				Model m=new Model(index_1,index_2);
				Model resultant=multiplyMatrix(key,m.chunck);
				cipher.append((char) resultant.chunck[0][0]);
				cipher.append((char)resultant.chunck[1][0]);
			}	
		}

			return cipher;
	}
		

	public static StringBuffer decrypt(String c,int[][] key){
		StringBuffer plain=new StringBuffer();
		String cipher=c.toLowerCase();
		System.out.println("CIPHER:  "+c);
		int index_2=0;


		for (int i=0;i<cipher.length();i+=2 ) {
			int index_1=(int)cipher.charAt(i)-97;
			try{
				index_2=(int)cipher.charAt(i+1)-97;
			}catch(Exception e){
				index_2=23;
			}
			finally{
				Model m=new Model(index_1,index_2);
				Model resultant=multiplyMatrix(inverseMatrix(key),m.chunck);
				plain.append((char) resultant.chunck[0][0]);
				plain.append((char)resultant.chunck[1][0]);
			}	
		}

			return plain;
	}


	public static Model multiplyMatrix(int[][] keys,int[][] matrix){

		int result_1=(keys[0][0]*matrix[0][0]+keys[0][1]*matrix[1][0])%26;
		int result_2=(keys[1][0]*matrix[0][0]+keys[1][1]*matrix[1][0])%26;
		return new Model(result_1+97,result_2+97);
	}

	public static int[][] inverseMatrix(int[][] matrix){
		int det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
		int[][] inverseMatrix=new int[2][2];
		if(det<0){
			det=det+26;
		}

		int inverseOfDet=inverse(det);
		inverseMatrix[0][0] = matrix[1][1];
		inverseMatrix[1][1] =  matrix[0][0];


		inverseMatrix[0][1] = 	matrix[0][1]-26;
		inverseMatrix[1][0] = 	matrix[1][0]-26;

		inverseMatrix[0][0] = inverseOfDet*inverseMatrix[0][0];
		inverseMatrix[1][1] = inverseOfDet*inverseMatrix[1][1];
		inverseMatrix[0][1] = inverseOfDet*(-inverseMatrix[0][1]);
		inverseMatrix[1][0] = inverseOfDet*(-inverseMatrix[1][0]);

		return inverseMatrix;

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

class Model{

	public int[][] chunck;
	Model(int r1,int r2){
		chunck=new int[2][1];
		chunck[0][0]=r1;
		chunck[1][0]=r2;
	} 
}
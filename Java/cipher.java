import java.util.Scanner;

public class cipher{
	
	public String input, key;
	private String output="", alphabets="abcdefghijklmnopqrstuvwxyz", ALPHABETS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public int inputLength, counter, charPosition;
	static Scanner cin = new Scanner(System.in);

	public void encryptSubtitution(int keyPosition){
		for(counter=0;counter<inputLength;counter++){
			charPosition = (int)input.charAt(counter);
			if((charPosition>=65)&&(charPosition<=90)){
				output = output + ALPHABETS.charAt(((charPosition+keyPosition+64)%64)%26);
			}else if((charPosition>=97)&&(charPosition<=122)){
				output = output + alphabets.charAt(((charPosition+keyPosition+96)%96)%26);
			}else{
				output = output + input.charAt(counter);
			}
		}
		System.out.println("\nCipherText : " + output);
	}
	
	public void decryptSubtitution(int keyPosition){
		for(counter=0;counter<inputLength;counter++){
			charPosition = (int)input.charAt(counter);
			if((charPosition>=65)&&(charPosition<=90)){
				output = output + ALPHABETS.charAt(((charPosition-keyPosition+90)%65)%26);
			}else if((charPosition>=97)&&(charPosition<=122)){
				output = output + alphabets.charAt(((charPosition-keyPosition+122)%97)%26);
			}else{
				output = output + input.charAt(counter);
			}
		}
		System.out.println("\nPlainText : " + output);
	}
	
	public void encryptVigenere(int keyLength,int keyPosition[]){
		int i;
		for(counter=0,i=0;counter<inputLength;counter++,i++){
			charPosition = (int)input.charAt(counter);
			if((charPosition>=65)&&(charPosition<=90)){
				output = output + ALPHABETS.charAt(((charPosition+keyPosition[i%keyLength]+64)%64)%26);
			}else if((charPosition>=97)&&(charPosition<=122)){
				output = output + alphabets.charAt(((charPosition+keyPosition[i%keyLength]+96)%96)%26);
			}else{
				output = output + input.charAt(counter);
			}
		}
		System.out.println("\nCipherText : " + output);
	}
	
	public void decryptVigenere(int keyLength,int keyPosition[]){
		int i;
		for(counter=0,i=0;counter<inputLength;counter++,i++){
			charPosition = (int)input.charAt(counter);
			if((charPosition>=65)&&(charPosition<=90)){
				output = output + ALPHABETS.charAt(((charPosition-keyPosition[i%keyLength]+90)%65)%26);
			}else if((charPosition>=97)&&(charPosition<=122)){
				output = output + alphabets.charAt(((charPosition-keyPosition[i%keyLength]+122)%97)%26);
			}else{
				output = output + input.charAt(counter);
			}
		}
		System.out.println("\nPlainText : " + output);
	}
	
	public static void main(String args[]){
		cipher cc = new cipher();
		int option;
		
		System.out.print("Press:\t1.Substitution Cipher\n\t2.Vigenere Cipher :(1|2) ");
		option = cin.nextInt();
		
		if((option==1)||(option==2)){
			int encryptOrDecrypt;
			System.out.print("\nPress:\t1.Encrypt\n\t2.Decrypt :(1|2) ");
			encryptOrDecrypt = cin.nextInt();
			if(encryptOrDecrypt==1){
				System.out.print("\nPlaintext : ");
			}else{
				System.out.print("\nCiphertext : ");
			}
			cc.input = cin.nextLine();
			cc.input = cin.nextLine();
			cc.inputLength = cc.input.length();
			if(option==1){
				int keyPosition;
				System.out.print("Enter key : ");
				cc.key = cin.nextLine();
				keyPosition = (int)cc.key.charAt(0);
				if(keyPosition<91){
					keyPosition-=65;
				}else{
					keyPosition-=97;
				}
				switch(encryptOrDecrypt){
					case 1:
						cc.encryptSubtitution(keyPosition);
						break;
					case 2:
						cc.decryptSubtitution(keyPosition);
						break;
				}
			}else{
				int keyLength, i;
				System.out.print("Enter key : ");
				cc.key = cin.nextLine();
				keyLength = cc.key.length();
				int keyPosition[] = new int[keyLength];
				for(i=0;i<keyLength;i++){
					keyPosition[i] = (int)cc.key.charAt(i);
					if(keyPosition[i]<91){
						keyPosition[i]-=65;
					}else{
						keyPosition[i]-=97;
					}
				}
				switch(encryptOrDecrypt){
					case 1:
						cc.encryptVigenere(keyLength,keyPosition);
						break;
					case 2:
						cc.decryptVigenere(keyLength,keyPosition);
						break;
				};
			}
		}
		else{
			System.out.println(":::[ Input should have been 1 or 2 ]:::");
		}
	}
}
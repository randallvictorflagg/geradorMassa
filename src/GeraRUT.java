import java.util.Random;

public class GeraRUT {

	GeraRUT(){
		
		
	}
	public String generateRUT(){

		String RUT = "";

		Random rdn = new Random();

		for (int x = 0; x < 8; x++){

			RUT = RUT + rdn.nextInt(9);

		}

		RUT = validateRUT(RUT);

		return RUT;
	}

	public String validateRUT(String RUT){

		int calc = 0;
		int controller = 2;
		int mod = 0;

		for (int x = RUT.length() - 1; x >= 0 ; x--){

			calc = calc + Integer.parseInt(String.valueOf(RUT.charAt(x))) * controller;

			controller++;

			if (controller > 7){
				controller = 2;
			}

		}

		mod = calc % 11;

		if (11 - mod==11){
			return RUT + "0";
		}else if(11 - mod == 10){
			return RUT + "K";
		}else{
			return RUT + (11 - mod);
		}
	}
	
}

package no.hvl.dat108;

public class TestMain {

	public static void main(String[] args) {
		
		DeltakerEAO DeltakerEAO = new DeltakerEAO();
		String password = "password";
		String pwdCryp = PassordUtil.krypterPassord(password);
		
		Deltaker deltaker = new Deltaker(98979691, "Are", "Daehlen", pwdCryp, 'M');
		

		DeltakerEAO.leggTilDeltaker(deltaker);
	}

}

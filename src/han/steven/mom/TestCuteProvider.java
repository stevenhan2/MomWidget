package han.steven.mom;


public class TestCuteProvider implements CuteProvider {

	@Override
	public Cute getNextCute() {
		return new Cute(R.drawable.ruby1,"Tester","Tester says hi to you!");
	}

}

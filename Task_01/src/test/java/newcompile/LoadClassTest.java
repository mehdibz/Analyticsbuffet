package newcompile;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoadClassTest {

	@Test
	public void test() {
		try{
			Support TestObj = new Support();
			TestObj.LoadClass(".\\target\\classes\\NewClass.class");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

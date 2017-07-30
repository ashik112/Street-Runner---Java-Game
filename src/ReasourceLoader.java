
	import java.io.InputStream;


	final public class ReasourceLoader {

		public static InputStream load(String n){
			
			InputStream input=ReasourceLoader.class.getResourceAsStream(n);
			if(input==null){
				input=ReasourceLoader.class.getResourceAsStream("/"+n);
				
			}
			return input;
		}
	}




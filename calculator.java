public class calculator {

	public Integer test(String args) {
				
		String str = args;
		
		if(str.contains("+")) {
			
			String[] parts = str.split("\\+");
			return sum(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
		}
		else if(str.contains("-")) {
			
			String[] parts = str.split("\\-");
			return sub(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
		}
		else if(str.contains("*")) {
			
			String[] parts = str.split("\\*");
			return mult(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
		}
		return -99999;
	}
	
	public Integer sum(int a, int b) {
		
		return a+b;
		
	}
	
	public Integer sub(int a, int b) {
		
		return a-b;
		
	}
	
	public Integer mult(int a, int b) {
		
		return a*b;
		
	}
	public String StringAdder(String a,String b){
		return a+b;
	}
	
	
}

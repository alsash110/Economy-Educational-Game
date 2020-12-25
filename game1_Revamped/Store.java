package game1_Revamped;

public class Store extends Upgradable {

	private int level = 1;
	private int limit ;
	
	public Store(){
		
		this.limit = 10;
	}
	@Override
	public int upgrade() {
		setLimit(limit+ 5);
		return level++;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getLevel(){
		
		return level;
	}

	
}
